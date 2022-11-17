package org.thgy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @CLassName UploadInfo
 * @Description TODO
 * @Author pzh
 * @Date 2022/7/5 10:30
 * @Version 1.0
 **/


@Data
@NoArgsConstructor
public class UploadInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 上传结果
     * */
     private String result;


    /**
     * 初始文件名
     * */

     private String beginFileName;


    /**
     * 最终上传文件名
     * */
     private String lastFileName;

    /**
     * 文件类型
     * */

    private String FileType;


    /**
     * 文件大小
     * */
     private BigDecimal fileSize;

    /**
     * 文件上传的地址
     * */
     private String filePath;

}
