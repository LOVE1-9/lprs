package com.example.demo.controller;


import com.example.demo.result.UploadResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@CrossOrigin
@Api(value = "图片上传")
@RestController
public class UploadController {
    @ResponseBody
    @PostMapping("api/upload")
    public UploadResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String path = "E:/workspace-idea/lprs/Spring-bootDemo/res/image";
        OCRController ocr = new OCRController();
        String plate = ocr.getPlate(file);
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        if (suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png")) {
            fileName = UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, fileName);
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            long size = 0;
            //保存
            try {
                file.transferTo(targetFile);
                size = file.getSize();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
            String fileUrl = "http://localhost:8080";
            //文件获取路径
            fileUrl = fileUrl + request.getContextPath() + "/image/" + fileName;
            return new UploadResult(true,"null",plate,fileUrl);
        } else {
            return new UploadResult(false,"error","null");
        }
    }
}

