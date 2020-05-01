package com.leetcode.util;

import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
    private static Logger logger = LoggerFactory.getLogger(TimeTool.class);


    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    public interface Task{
        void excute();
    };

    public static void check(String title, Task task){
        if (task == null) {return ;}
        title = StringUtils.isEmpty(title)?"":("【" + title + "】");
        logger.info(title);
        logger.info("开始时间：" + sdf.format(new Date()));
        long startTime = System.currentTimeMillis();
        task.excute();
        long endTime = System.currentTimeMillis();
        logger.info("结束时间：" + sdf.format(new Date()));
        double res = (endTime - startTime) / 1000.0;
        logger.info("共耗时：{}秒" ,res);
        logger.info("------------------------------------------------");
    }
}
