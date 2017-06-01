package com.example.demo.load.controller;

import com.example.demo.load.service.LoadService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cuizhixiang on 2017/6/1.
 * 上传下载
 **/
@RestController
public class LoadController {

    @Autowired
    private LoadService loadService;

    /**
     * 文件上传
     *
     * @param uploadFile 上传文件
     * @return 上传结果
     */
    @RequestMapping("upload-file")
    public String uploadContractFile(@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile) {
        return loadService.fileUpLoad(uploadFile);
    }
}
