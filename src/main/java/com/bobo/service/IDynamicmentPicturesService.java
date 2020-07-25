package com.bobo.service;

import com.bobo.utils.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IDynamicmentPicturesService {

    /**
     * 根据前端传入的数据，将用户发布动态中的图片根据动态数据库中的id，保存到动态图片表单中
     * @param files
     * @return
     */
    ServerResponse insertDynamicmentPictures(MultipartFile[] files,Integer id) throws IOException;

    /**
     * 根据动态的id来删除对应的图片
     * @param dynamicmentId
     * @return
     */
    ServerResponse deleteDynamicmentPicetureBydynamicmentId(Integer dynamicmentId);
}
