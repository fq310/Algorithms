package leetcode_152;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jason on 16-4-20.
 */
public class Problem153Test {

    @Test
    public void findMin() throws Exception {
        Problem153 p = new Problem153();
        Assert.assertEquals(p.findMin(null), 0);
        Assert.assertEquals(p.findMin(new int[]{}), 0);
        Assert.assertEquals(p.findMin(new int[]{1}), 1);
        Assert.assertEquals(p.findMin(new int[]{1, 2}), 1);
        Assert.assertEquals(p.findMin(new int[]{2, 1}), 1);
        Assert.assertEquals(p.findMin(new int[]{1, 2, 3}), 1);
        Assert.assertEquals(p.findMin(new int[]{3, 1, 2}), 1);
        Assert.assertEquals(p.findMin(new int[]{2, 3, 1}), 1);
        Assert.assertEquals(p.findMin(new int[]{1, 2, 3, 4}), 1);
        Assert.assertEquals(p.findMin(new int[]{4, 1, 2, 3}), 1);
        Assert.assertEquals(p.findMin(new int[]{3, 4, 1, 2}), 1);
        Assert.assertEquals(p.findMin(new int[]{2, 3, 4 ,1}), 1);
    }
}