package com.bobo.controller;

import com.bobo.pojo.Dynamicment;
import com.bobo.service.IDynamicmentPicturesService;
import com.bobo.service.IDynamicmentService;
import com.bobo.service.impl.DynamicmentPicturesService;
import com.bobo.service.impl.DynamicmentService;
import com.bobo.utils.ServerResponse;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/dynamicment/")
@Controller
public class DynamicmentController {

    @Autowired
    IDynamicmentService iDynamicmentService;
    @Autowired
    IDynamicmentPicturesService iDynamicmentPicturesService;

    @ResponseBody
    @PostMapping(value = "release")
    public List<ServerResponse> releaseDynamicment(@RequestParam("pictures")MultipartFile[] file,
                                             Dynamicment dynamicment) throws IOException {
        ServerResponse serverResponse = iDynamicmentService.insertDynamicment(dynamicment);
        ServerResponse serverResponse1 = iDynamicmentPicturesService.insertDynamicmentPictures(file,(Integer)serverResponse.getData());
        List<ServerResponse> serverResponseList = new ArrayList<>();
        serverResponseList.add(serverResponse);
        serverResponseList.add(serverResponse1);
        return serverResponseList;
    }

    @ResponseBody
    @GetMapping(value = "delete")
    public List<ServerResponse> deleteDynamicment(@RequestParam("dynamicmentId")Integer id){
        ServerResponse serverResponse=iDynamicmentService.deleteDynamicment(id);
        ServerResponse serverResponse1=iDynamicmentPicturesService.deleteDynamicmentPicetureBydynamicmentId(id);
        List<ServerResponse> serverResponseList = new ArrayList<>();
        serverResponseList.add(serverResponse);
        serverResponseList.add(serverResponse1);
        return serverResponseList;
    }
}
