package com.example.demo.load.service;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by cuizhixiang on 2017/6/1.
 **/
@Component
public class LoadService {

    /**
     * 文件上传
     *
     * @param uploadFile 上传文件
     * @return 上传结果
     */
    public String fileUpLoad(@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) {
        if (uploadFile == null) {
            return "未上传文件";
        }
        //上传文件名
        String fullName = uploadFile.getOriginalFilename();
        //获取文件夹的绝对路径
        File uploadFolder = new File("fileUpload").getAbsoluteFile();
        //生成上传文件的文件名
        String imageName = UUID.randomUUID() + fullName.substring(fullName.lastIndexOf("."));
        try {
            //判断路径是否存在
            if (!uploadFolder.exists()) {
                boolean mkdir = uploadFolder.mkdirs();
            }
            //上传文件
            uploadFile.transferTo(new File(uploadFolder, imageName));
        } catch (Exception e) {
            return "上传失败";
        }
        return "上传成功";
    }
}
