package leetcode_152;

import java.util.*;

/**
 * Created by jafu on 5/25/16.
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class Problem164 {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0], min = nums[0];
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        //一开始我也非常不理解为什么要加1, 然后让我遇到了这个用例{1, 2}
        int length = ((max - min) / nums.length) + 1;

        //用最大值减去最小值再除以数组的长度,效果是什么呢:
        //如果这个数组越稀疏,那么长度就会越大,最后计算出的桶的个数就会越少
        //反之,如果这个数组越稠密,length就会越小,那么计算出最后的bucketNumber就会越多
        //不管是哪种情况,都是保证了每个桶里的元素不会太多,这样排序耗费的时间少
        int bucketNumber = ((max - min) / length) + 2;
        //一开始我是加1的,因为{1, 2},但是当我遇到了{1,10000000},我就知道要加2了
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNumber + 1; ++i) {
            bucketList.add(new ArrayList<>());
        }
        for (int i : nums) {
            int bucketIndex = (i - min) / length;//要额外注意这里哦,不能用i直接除
            bucketList.get(bucketIndex).add(i);
        }
        for (List<Integer> bucket : bucketList) {
            Collections.sort(bucket);
        }
        bucketList = getNonEmptyList(bucketList);

        int totalMax = 0;
        for (int i = 0; i < bucketList.size(); ++i) {
            List<Integer> bucket = bucketList.get(i);
            int bucketMax = -1;
            for (int j = 0; j < bucket.size() - 1; ++j) {
                bucketMax = Math.max(bucketMax, bucket.get(j + 1) - bucket.get(j));
            }
            if (i < bucketList.size() - 1) {
                totalMax = Math.max(totalMax, Math.max(bucketMax, (startOfNextBucket(bucketList, i) - endOfThisBucket(bucket))));
            } else {
                totalMax = Math.max(totalMax, bucketMax);
            }
        }
        return totalMax;
    }

    private Integer startOfNextBucket(List<List<Integer>> bucketList, int i) {
        return bucketList.get(i + 1).get(0);
    }

    private Integer endOfThisBucket(List<Integer> bucket) {
        return bucket.get(bucket.size() - 1);
    }

    private List<List<Integer>> getNonEmptyList(List<List<Integer>> bucketList) {
        List<List<Integer>> nonEmptyBuckets = new ArrayList<>();
        for (List<Integer> bucket : bucketList) {
            if (bucket.size() != 0) {
                nonEmptyBuckets.add(bucket);
            }
        }
        return nonEmptyBuckets;
    }
}
