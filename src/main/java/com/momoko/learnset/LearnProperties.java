package com.momoko.learnset;

/**
 * Created by momoko on 2019/11/21
 *
 * @author momoko
 */

import java.io.IOException;
import java.util.Properties;

/**
 * 用Properties读取配置文件，一共有三步：
 *
 * 创建Properties实例；
 * 调用load()读取文件；
 * 调用getProperty()获取配置。
 */
public class LearnProperties {
    public static void main(String[] args) {
        //读取properties文件
        String f = "src/main/resources/settings.properties";
        Properties props = new Properties();
        try {
            props.load(new java.io.FileInputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");
        System.out.println(filepath+interval);
    }
}
