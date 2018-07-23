package com.kaishengit.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;

/**
 * @author jinjianghao
 * @date 2018/7/23
 */
@RequestMapping("/file")
@Controller
public class FileUploadController {

    @GetMapping("/upload")
    public String fileUploadPage() {
        return "file/upload";
    }

    @PostMapping("/upload")
    public String fileUpload(MultipartFile file, RedirectAttributes attributes){
        if(!file.isEmpty()) {
            try {
                // 上传控件的那么属性值
                System.out.println(file.getName());
                //  文件大小
                System.out.println(FileUtils.byteCountToDisplaySize(file.getSize()));
                // 上传文件是否未空
                System.out.println(file.isEmpty());
                // MIME类型
                System.out.println(file.getContentType());
                // 文件原始名称
                System.out.println(file.getOriginalFilename());

                // 文件上传
                File direction = new File("d:/temp/img/");
                if(!direction.exists()) {
                    direction.mkdirs();
                }
                OutputStream outputStream = new FileOutputStream(new File(direction,file.getOriginalFilename()));
                InputStream inputStream = file.getInputStream();

                IOUtils.copy(inputStream, outputStream);

                // 释放资源
                outputStream.flush();
                outputStream.close();
                inputStream.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不能为空");
            attributes.addFlashAttribute("message","文件不能未空");
        }
        return "redirect:/file/upload";
    }

}
