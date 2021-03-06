package com.che.test.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫问题
 * <p>
 * 10个人围成一个圆圈，编号为1~10（令N=10），
 * 从第一号开始报数，报到3（令M=3）的倍数的人离开，
 * 一直数下去，直到最后只有一个人，
 * 求此人编号
 */
public class JosephusProblem {

    @Test
    public void test() {
        int N = 10, M = 3;
        System.out.println("模拟法：最后的人=" + mock(N, M));
        System.out.println("递归法：最后的人=" + recursion(N, M));
    }

    /**
     * 约瑟夫问题的模拟法
     *
     * @param N 人数
     * @param M 离开的报数
     * @return 最后的人
     */
    private int mock(int N, int M) {
        List<Integer> list = new ArrayList<>();
        //初始化数组，代表所有人
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        // 每次计数开始的索引
        int startIndex = 0;
        // 删除的位置
        int removeIndex;
        //循环删除
        while (true) {
            // 【起始位置】+【报号数】-1 =【len】
            int len = startIndex + M - 1;
            // 如果 len > list.size(),相当于转了一圈，又重新开始;
            if (len > list.size() - 1) {
                removeIndex = len % list.size();
            } else {
                removeIndex = len;
            }
            list.remove(removeIndex);
            startIndex = removeIndex;
            //只有最后一位时，返回
            if (list.size() == 1) {
                return list.get(0);
            }
        }

    }

    /**
     * 约瑟夫问题的递归法
     * <p>
     * 递推公式:
     * (1)、f[1]=0;
     * (2)、f[i]=(f[i-1]+m)%i; (i>1)
     * <p>
     * 参考：http://www.acmerblog.com/joseph-problem-3394.html
     */
    public int recursion(int N, int M) {
        int s = 0;
        for (int i = 2; i <= N; i++) {
            s = (s + M) % i;
        }
        return s + 1;
    }

}