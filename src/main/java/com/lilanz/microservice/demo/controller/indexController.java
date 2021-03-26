package com.lilanz.microservice.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.lilanz.microservice.demo.bean.User;
import com.lilanz.microservice.demo.service.UserServer;
import com.lilanz.microservice.demo.until.ImageMarkLogoByIcon;
import com.lilanz.microservice.demo.until.PrintScreen4DJNativeSwingUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/home")
public class indexController {

    @Resource
    private UserServer userServer;

    @ResponseBody
    @RequestMapping(value = "/hello")
    public Object hello(String jsonObject, HttpServletRequest request) {
        System.out.println("/home/hello\nparams:" + jsonObject);
        System.out.println(request.getParameter("c"));
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping(value = "/getImage")
    public Object getImage(@RequestBody JSONObject jsonObject) {
        System.out.println("into...");
        PrintScreen4DJNativeSwingUtils.printUrlScreen2jpg("content.jpg",
                jsonObject.getString("url"),
                jsonObject.getInteger("starX"),
                jsonObject.getInteger("starY"),
                jsonObject.getInteger("maxWidth"),
                jsonObject.getInteger("maxHeight"));
        System.out.println("out...");
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/CompositePicture")
    public Object CompositePicture(@RequestBody JSONObject jsonObject) {
        System.out.println("into...");
        String srcImgPath = PrintScreen4DJNativeSwingUtils.printUrlScreen2jpg("content.jpg",
                jsonObject.getString("url"),
                jsonObject.getInteger("starX"),
                jsonObject.getInteger("starY"),
                jsonObject.getInteger("maxWidth"),
                jsonObject.getInteger("maxHeight"));
        System.out.println("srcImgPath=" + srcImgPath);
        ImageMarkLogoByIcon.markImageByIcon(jsonObject.getString("iconPath"),
                srcImgPath,
                jsonObject.getString("targetPath"),
                jsonObject.getInteger("iconX"),
                jsonObject.getInteger("iconY"));
        System.out.println("out");
        return "success";
    }

    @Transactional
    @ResponseBody
    @RequestMapping("/insertTest")
    public String insertTest() {
        /*User user = new User();
        user.setAge(23);
        user.setInfo("666");
        user.setName("Alice");
        int exe = userServer.insert(user);*/
        String sql = "insert into sc_t_ysqmlsb(fbid,zdrq,signid,remark) values(23,getdate(),1,'666')";
        int exe = userServer.insert_sql(sql);
        System.out.println("exe=" + exe);
        int x = 1/0;
        return "success";
    }

}
