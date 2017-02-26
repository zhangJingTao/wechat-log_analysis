package com.sleep.wechat;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * step0.处理同步助手导出的文件
 */
public class FileHandler {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        File file = new File(filePath);
        if (file.exists()){
            List<String> lines = FileUtils.readLines(file,"UTF-8");
            List<String> result = new ArrayList<String>();
            for (String line :lines) {
                //处理 2017-02-21 21:36:54
                int len = "2017-02-21 21:36:54".length();
                if (line.length()>len){
                    System.out.println(line.substring(len));
                    result.add(line.substring(len));
                }
            }
            File fileOut = new File(filePath+".out");
            FileUtils.writeLines(fileOut,result);
        }
    }
}
