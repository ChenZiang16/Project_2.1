package com.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 上传文件转换为String字符串，或字符串转为jps给浏览器
 * @author Administrator
 *
 */

@Controller
public class ImageController {

	@RequestMapping("/getImage")
	public void getImage(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			System.out.println("image request ...");
			
			OutputStream out = response.getOutputStream();
			
			File file = new File("G:"+File.separator +"workspace"+File.separator+"IMG.txt");
			
            String result = FileUtils.readFileToString(file,"utf-8");
            
            BASE64Decoder decoder = new BASE64Decoder();
            
            byte[] bytes =decoder.decodeBuffer(result);
            
            for(byte b:bytes) {
            	if(b< 0) {
            		b += 256;
            	}
            }
            
            out.write(bytes);
            
            out.flush();
            
            out.close();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/storeImage")
	@ResponseBody
	public String storeImage(MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		
		String name = file.getOriginalFilename();
		
		if(StringUtils.isBlank(name) || !name.endsWith("jpg")) {
			return "error";
		}
		
		System.out.println("收到上传的图片：" + name);
		
		try {
			
//			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("G:"+File.separator +"workspace"+File.separator + file.getOriginalFilename())));
//			out.write(file.getBytes());
//			out.flush();
//			out.close();
			
            BASE64Encoder encoder = new BASE64Encoder();
            
            String result = encoder.encode(file.getBytes());

            System.out.println(result);

            FileUtils.writeStringToFile(new File("G:"+File.separator +"workspace"+File.separator+"IMG.txt"),result,"utf-8");
           
			
			return "success";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
}
