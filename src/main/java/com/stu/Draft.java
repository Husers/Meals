package com.stu;

/**
 * Created by huser
 * On 17/2/12.
 */
public class Draft {
    public static void main(String[] args) {
        String a = Draft.class.getResource("/data/data.properties").getPath();
        System.err.println(a);
    }
}
