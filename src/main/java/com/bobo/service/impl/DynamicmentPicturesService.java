package com.bobo.service.impl;

import com.bobo.common.ResponseCode;
import com.bobo.dao.DynamicmentPictureMapper;
import com.bobo.pojo.Dynamicment;
import com.bobo.pojo.DynamicmentPicture;
import com.bobo.service.IDynamicmentPicturesService;
import com.bobo.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DynamicmentPicturesService implements IDynamicmentPicturesService {

    /**
     * 根据动态表单中创建的id，将动态中的图片保存到数据库中
     * @param files
     * @param id
     * @return
     */

    @Value("${business.host}")
    String imageHost;

    @Autowired
    DynamicmentPictureMapper dynamicmentPictureMapper;

    @Override
    public ServerResponse insertDynamicmentPictures(MultipartFile[] file, Integer id) throws IOException {
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
        int count=0;
        for(String img: list){
            DynamicmentPicture dynamicmentPicture = new DynamicmentPicture();
            dynamicmentPicture.setDynamicmentId(id);
            dynamicmentPicture.setPicture(img);
            int temp = dynamicmentPictureMapper.insert(dynamicmentPicture);
            if(temp != 0)count++;
        }
        if(count!=list.size())
            return ServerResponse.createServerResponseByFail(ResponseCode.DYNAMICMENT_PICTURE_SAVE_FAIL.getCode(),ResponseCode.DYNAMICMENT_PICTURE_SAVE_FAIL.getMsg());
        return ServerResponse.createServerResponseBySucess();
    }



    @Override
    public ServerResponse deleteDynamicmentPicetureBydynamicmentId(Integer dynamicmentId) {
        dynamicmentPictureMapper.deleteBydynamicmentId(dynamicmentId);
        return ServerResponse.createServerResponseBySucess();
    }
}
