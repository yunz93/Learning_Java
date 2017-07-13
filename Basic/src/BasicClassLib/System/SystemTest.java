package BasicClassLib.System;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * System test
 * Created by Administrator on 2017/6/20 0020.
 */
public class SystemTest {
    public static void main(String[] args) throws Exception {
        // GET ALL Environment Variable of system
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + " -----> " + env.get(name));
        }
        // 获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        Properties props = System.getProperties();
        props.store(new FileOutputStream("props.txt"), "System Properties");
    }
 }
