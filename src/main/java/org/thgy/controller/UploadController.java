package org.thgy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thgy.dto.UploadInfo;
import org.thgy.service.UploadService;

import java.awt.*;

/**
 * @CLassName UploadController
 * @Description TODO
 * @Author pzh
 * @Date 2022/7/5 10:24
 * @Version 1.0
 **/

@RequestMapping("/file")
@RestController
@Validated
public class UploadController {
    @Autowired
    private UploadService uploadService;
//    private final static String UPLOAD_PATH = "D:\\file";
    private final static String UPLOAD_PATH = "/usr/local/web/file";

    @PostMapping( "/upload")
    public UploadInfo uploadTest(@RequestParam("file") MultipartFile file){

        System.out.println("file++++++++++++++++++++"+file);

        UploadInfo uploadInfo = null;
        try{
            uploadInfo = uploadService.upload(file,UPLOAD_PATH);
            System.out.println("上传成功");

        }catch (Exception e){
            System.out.println(e.toString());
        }
        return uploadInfo;
    }

}
