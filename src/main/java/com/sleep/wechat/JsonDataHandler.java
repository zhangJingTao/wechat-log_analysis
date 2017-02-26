package com.sleep.wechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * step2.将产生的结果处理成json数据
 */
public class JsonDataHandler {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        if (file.exists()){
            JSONArray array = new JSONArray();
            List<String> lines = FileUtils.readLines(file,"UTF-8");
            for (String line :lines) {
                String[] words = line.split(",");
                JSONObject json = new JSONObject();
                json.put("name",words[0]);
                json.put("value",words[1]);
                array.add(json);
            }
            System.out.println(array.toJSONString());
            //使用fileutils写到 /webapps/data.json下
        }
    }
}
