package com.cloud.commons.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件处理工具类
 * @author haoliuyang
 */
public class FileUtil {
    /**
     * 文件上传
     * @param file 文件参数
     * @return 返回类型String
     * @throws IOException 异常
     */
    public static String fileUpload(MultipartFile file) throws IOException {
        //图片上传成功后，将图片的地址写到数据库
        //保存图片的路径（这是存在我项目中的images下了，你们可以设置路径）
        String filePath = "E:\\image/";
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        //封装上传文件位置的全路径
        File targetFile = new File(filePath, originalFilename);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
//        图片路径
        return filePath + originalFilename;
    }
}
