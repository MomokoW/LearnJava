package com.momoko;

/**
 * Created by momoko on 2020/12/22.
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        int[] arr = new int[10];
        System.out.println(arr.length);
    }
}

enum Season1 {
    //1.提供当前枚举类的对各对象：多个对象之间用逗号隔开，末尾对象分号结束
    SPRING("春天","春暖花开"),

    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");

    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }



    //4.其他诉求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    }