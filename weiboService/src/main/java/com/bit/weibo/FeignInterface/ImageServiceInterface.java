package com.bit.weibo.FeignInterface;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Component
@FeignClient(name = "fileService", configuration = com.bit.weibo.FeignInterface.ImageServiceInterface.MultipartSupportConfig.class)
public interface ImageServiceInterface {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST,

            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},

            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    @ResponseBody

    String uploadFile(@RequestPart(value = "file") MultipartFile file);

    class MultipartSupportConfig {

        @Bean
        public SpringFormEncoder feignFormEncoder() {

            return new SpringFormEncoder();

        }

    }

}