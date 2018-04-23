package org.sheng.as;

/**
 * @author shengxingyue, created on 2018/4/1
 */
public class MainTest {

    public static void main(String[] args) {
        int a = -6;
        for (int i = 0; i < 32; i++) {
            int j = (a & (0x80000000 >>> i)) >>> (31 - i);
            System.out.print(j);
        }
    }
}
