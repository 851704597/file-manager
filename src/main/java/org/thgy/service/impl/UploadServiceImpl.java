package org.thgy.service.impl;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thgy.dto.UploadInfo;
import org.thgy.service.UploadService;

import java.io.File;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.UUID;

/**
 * @CLassName UploadServiceImpl
 * @Description TODO
 * @Author pzh
 * @Date 2022/7/5 10:40
 * @Version 1.0
 **/

@Service
public class UploadServiceImpl implements UploadService {
     private final static String images_PATH = "/images/";


        @Override
        public UploadInfo upload(MultipartFile file, String uploadFilePath) throws Exception {
                if (file.isEmpty())
                        return null;
                UploadInfo uploadInfo = new UploadInfo();
                String originalFilename;
                String fileName;
                originalFilename = file.getOriginalFilename();
                UUID uuid4 = Generators.randomBasedGenerator().generate();
                fileName = uuid4+ file.getOriginalFilename();
                String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
                long fileSize = file.getSize();
                File packageFile = new File(uploadFilePath);
                if (!packageFile.exists()) {
                        packageFile.mkdir();
                }
                InetAddress address = InetAddress.getLocalHost();
                String hostAddress = address.getHostAddress();
                File targetFile = new File(uploadFilePath+"/" +fileName);
//                String ss = images_PATH+ targetFile.toString();
                file.transferTo(targetFile);
                uploadInfo.setBeginFileName(originalFilename);
                uploadInfo.setLastFileName(fileName);
                uploadInfo.setFileType(fileType);
                uploadInfo.setFileSize(new BigDecimal(fileSize));
                uploadInfo.setFilePath(images_PATH +fileName);
                uploadInfo.setResult("200");
                return uploadInfo;
        }
}
