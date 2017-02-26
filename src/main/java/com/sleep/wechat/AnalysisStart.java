package com.sleep.wechat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.sleep.wechat.domain.WordDomain;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by zhangjingtao on 2017/2/26.
 */
public class AnalysisStart {
    static Logger log = Logger.getLogger(AnalysisStart.class);


    public static void main(String[] args) throws IOException {
        log.info("=================================================");
        log.info("分析开始");
        log.info("=================================================");
        String filePath = args[0];
        log.info("filePath:" + filePath);
        File file = new File(filePath);
        if (!file.exists()) log.error("file no exists!" + file.getAbsolutePath());
        if (file.exists()) {
            List<String> lines = FileUtils.readLines(file, "UTF-8");
            List<WordDomain> domainList = new ArrayList<WordDomain>();
            JiebaSegmenter segmenter = new JiebaSegmenter();
            //遍历每一行 将结果存储
            for (String line : lines) {
                List<SegToken> tokens = segmenter.process(line, JiebaSegmenter.SegMode.INDEX);
                for (SegToken token : tokens) {
                    int index = domainList.indexOf(new WordDomain(token.word));
                    if (index < 0) {
                        domainList.add(new WordDomain(token.word, 1));
                    } else {
                        domainList.get(index).addCount();
                    }
                }
            }
            //排序
            Collections.sort(domainList, new Comparator<WordDomain>() {
                public int compare(WordDomain o1, WordDomain o2) {
                    return o2.getCount()-o1.getCount();
                }
            });
            File resultFile = new File("result.txt");
            JSONObject json = new JSONObject(true);
            for (int i = 0; i < domainList.size(); i++) {
                WordDomain domain = domainList.get(i);
                FileUtils.writeStringToFile(resultFile,domain.getWord() + "," + domain.getCount()+"\r\n","UTF-8",true);
            }
            log.info("=================================================");
            log.info("分析完成："+resultFile.getAbsolutePath());
            log.info("=================================================");
        }

    }
}
