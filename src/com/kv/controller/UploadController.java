package com.kv.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UploadController {

	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(HttpServletRequest req, HttpServletResponse res) throws IllegalStateException, IOException {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResplver = new CommonsMultipartResolver(req.getSession().getServletContext());
		// 判断request是否有文件上传，即多部分请求
		if (multipartResplver.isMultipart(req)) {
			//判断 request 是否有文件上传,即多部分请求...    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)(req);  
              
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                MultipartFile file = multiRequest.getFile(iter.next());  
                String fileName = file.getOriginalFilename();  
                String path ="D:/upload/" +fileName;  
                File localFile = new File(path);  
                file.transferTo(localFile);  
            }  
		}
		
		return "success";
	}
}
