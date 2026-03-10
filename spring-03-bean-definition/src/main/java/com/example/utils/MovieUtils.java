package com.example.utils;

import org.springframework.stereotype.Component;

/**
 * 通用工具类，使用 @Component 注册到容器
 */
@Component  // 告诉 Spring：请管理这个类
public class MovieUtils {

    /**
     * 格式化电影时长：将分钟数转换为"X小时X分钟"格式
     */
    public String formatDuration(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return hours > 0 ? hours + "小时" + mins + "分钟" : mins + "分钟";
    }
}