package leetcode_152;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jafu on 5/24/16.
 */
public class Problem162Test {
    @Test
    public void findPeakElement() throws Exception {
        Problem162 p = new Problem162();
        Assert.assertEquals(p.findPeakElement(null), 0);
        Assert.assertEquals(p.findPeakElement(new int[]{}), 0);
        Assert.assertEquals(p.findPeakElement(new int[]{1}), 0);
        Assert.assertEquals(p.findPeakElement(new int[]{1, 2}), 1);
        Assert.assertEquals(p.findPeakElement(new int[]{2, 1}), 0);
        Assert.assertEquals(p.findPeakElement(new int[]{1, 3, 2}), 1);
        Assert.assertEquals(p.findPeakElement(new int[]{3, 2, 1}), 0);
        Assert.assertEquals(p.findPeakElement(new int[]{1, 2, 3}), 2);
    }

}