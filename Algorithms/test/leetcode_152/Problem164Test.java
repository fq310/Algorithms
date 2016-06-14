package leetcode_152;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jafu on 5/25/16.
 */
public class Problem164Test {
    @Test
    public void maximumGap() throws Exception {
        Problem164 p = new Problem164();
        Assert.assertEquals(p.maximumGap(null), 0);
        Assert.assertEquals(p.maximumGap(new int[]{}), 0);
        Assert.assertEquals(p.maximumGap(new int[]{1}), 0);
        Assert.assertEquals(p.maximumGap(new int[]{1, 2}), 1);
        Assert.assertEquals(p.maximumGap(new int[]{1, 2, 3}), 1);
        Assert.assertEquals(p.maximumGap(new int[]{2, 1, 4, 5, 6, 7}), 2);
        Assert.assertEquals(p.maximumGap(new int[]{}), 0);
        Assert.assertEquals(p.maximumGap(new int[]{1,10000000}), 9999999);
        Assert.assertEquals(p.maximumGap(new int[]{100,3,2,1}), 97);

    }

}