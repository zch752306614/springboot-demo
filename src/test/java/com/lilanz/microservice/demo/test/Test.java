package com.lilanz.microservice.demo.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/1/12 14:18
 */
public class Test {

    static class Solution {
        public static String longestCommonPrefix(String[] strs) {
            int len = strs.length;
            if (len == 0) {
                return "";
            }
            if (len == 1) {
                return strs[0];
            }
            String str = strs[0];
            for (String s : strs) {
                if (str.length() == 0) {
                    return str;
                }
                while (!s.startsWith(str)) {
                    str = str.substring(0, str.length() - 1);
                }
            }
            return str;
        }
    }

    static void test1() {
        List<String> list =Arrays.asList("a","ad","dr");
        list.stream().forEach(System.out::println);
        //或者如下也可以
        list.stream().forEach(a -> System.out.println(a));
        //或者不创建流也可以直接使用函数
        list.forEach(System.out::println);
        //或者
        list.forEach(a -> System.out.println(a));
    }

    static void test2() {
        //该random函数若是不传递参数，那么就采用当前时间的毫秒数当做种子数，若是传递了参数，就用传递的数字作为种子数了，但是这样的话，生成的随机数就是伪随机数，虽然随机，但是点几次，都基本一样，因为传入的种子数限制了函数的选择性
        Random random = new Random();
        //受到limit限制，只会随机显示10个数字，因为没有传递参数，那么每次点击都会不一样，否则，若传递了种子数，点击几次都一样
        random.ints().limit(10).forEach(System.out::println);
        //像下面的都一样
        random = new Random(10);//传递了种子数
        random.ints().limit(10).forEach(System.out::println);
    }

    static void test3() {
        //用数组来转换集合
        List<Integer> list = Arrays.asList(9,3,3);
        //distinct()函数，是去重复函数
        list = list.stream().distinct().map(i -> i*i).collect(Collectors.toList());
        //打印输出list
        list.forEach(System.out::println);
    }

    static void test4() {
        List<Integer> list = Arrays.asList(12,34,23,12,3,34);
        IntSummaryStatistics stats= list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("stats = " + stats);
        list.stream().map(Integer::doubleValue).forEach(System.out::println);
        //最大值
        System.out.println(stats.getMax());
        //最小值
        System.out.println(stats.getMin());
        //平均值
        System.out.println(stats.getAverage());
        //总数
        System.out.println(stats.getCount());
        //总和
        System.out.println(stats.getSum());
    }

    static void test5() {
        /*List list = Arrays.asList(0, 1, 2, 3);
        int count = list.stream().reduce(0, (acc, item) -> acc + item).intValue();
        System.out.println(count);*/
    }

    static void test6() {

    }

    public static void main(String[] args) {
        /*String[] strs = new String[]{"ab", "a"};
        System.out.println(Solution.longestCommonPrefix(strs));*/

        test5();

    }
}
