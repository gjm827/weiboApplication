package com.bit.weibo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    private FastDFSClient fastDFSClient;

    @RequestMapping(method = RequestMethod.POST,value="/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file)
    {
        String url = null;
        try {
            url = fastDFSClient.uploadFile(file);
            url = "http://120.27.243.108:8888/group1/"+url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}
