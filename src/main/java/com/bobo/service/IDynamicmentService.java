package com.bobo.service;

import com.bobo.pojo.Dynamicment;
import com.bobo.utils.ServerResponse;
import org.apache.catalina.Server;

public interface IDynamicmentService {

    /**
     * 根据客户端传入的数据，将用户发布的动态内容保存到数据库中
     * @param dynamicment
     * @return
     */
    ServerResponse insertDynamicment(Dynamicment dynamicment);

    /**
     * 根据传递给前端的对应的动态的id,来进行动态的删除操作
     * @param dynamicmentId
     * @return
     */
    ServerResponse deleteDynamicment(Integer dynamicmentId);
}
