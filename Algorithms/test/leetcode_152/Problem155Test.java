package leetcode_152;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangchen on 16/5/22.
 */
public class Problem155Test {
    Problem155 problem155 = new Problem155();
    @Test
    public void push() throws Exception {
        problem155.pop();
        Assert.assertTrue(problem155.getMin() == 0);

        problem155.push(1);
        Assert.assertTrue(problem155.getMin() == 1);

        problem155.push(-1);
        Assert.assertTrue(problem155.getMin() == -1);

        problem155.push(8);
        Assert.assertTrue(problem155.getMin() == -1);

        problem155.push(-2);
        Assert.assertTrue(problem155.getMin() == -2);

        problem155.pop();
        Assert.assertTrue(problem155.getMin() == -1);
    }

    @Test
    public void pop() throws Exception {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void top() throws Exception {
        problem155.push(-10);
        problem155.push(14);
        problem155.push(-20);
        problem155.pop();
        problem155.push(-10);
        problem155.push(-7);
        System.out.println(problem155.getMin());
    }

    @Test
    public void getMin() throws Exception {

    }

}