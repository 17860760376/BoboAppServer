package com.bobo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadMoreController {

//    @GetMapping(value = "/upload/more")
//    public String upload(){
//        return  "upload";
//    }
    @Value("${business.host}")
    String imageHost;


    @PostMapping(value = "/upload/more")
    @ResponseBody
    public List<String> upload(@RequestParam("userpic") MultipartFile[] file) throws IOException {
        List<String> list = new ArrayList<>();
        for(MultipartFile file2 : file){
            if (file2 != null && file2.getOriginalFilename() != null) {
                //获取文件扩展名
                String originalFilename = file2.getOriginalFilename();// xxx.png
                //获取扩展名
                String extend = originalFilename.substring(originalFilename.lastIndexOf("."));
                //重新生成唯一的文件名
                String newName = UUID.randomUUID().toString();
                File file1 = new File("D:" + File.separator + "upload", newName + extend);
                file2.transferTo(file1);
                list.add(imageHost + newName + extend);
            }
        }
      return list;
    }
}
