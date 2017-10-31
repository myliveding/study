package com.dzr.study.test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author dingzr
 * @Description
 * @ClassName FileHandel
 * @since 2017/5/27 17:07
 */
public class FileHandel {

    private static Stream readFile() {
        try {
            // Java8用流的方式读文件，更加高效
            //Files.lines(Paths.get("D:\\upload\\微信号.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
            return Files.lines(Paths.get("D:\\upload\\微信号.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of("");
    }


    private static void oldReadFile() {
        File file = new File("D:\\upload\\微信号.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte b[] = new byte[1024];
            int a = is.read(b);
            String str[] = new String(b, 0, a).split("");
            int count = 0;
            for (int i = 0; i < str.length; i++) {
                if ("a".equals(str[i])) count++;
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        System.err.println(readFile().filter(t -> null != t && String.valueOf(t).contains("service")).count());
        System.err.println(readFile().filter(Objects::isNull).count());
        System.err.println(readFile().filter(t -> t.toString().equals("")).count());
        oldReadFile();
    }
}
