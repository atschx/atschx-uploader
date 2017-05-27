package me.atschx.uploader.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {
	
	Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	Map<String,Object> upload(@RequestPart Part file,HttpServletRequest request){

		logger.info("file.getContentType():{}", file.getContentType());
		logger.info("file.getName():{}", file.getName());
		
//		file.
		logger.info("file.getOriginalFilename():{}", file.getSubmittedFileName());
		logger.info("file.getSize():{}", file.getSize());
		
		
		try {
			logger.info(request.getScheme());
			logger.info(request.getServerName());
			logger.info(request.getServletPath());
			logger.info(request.getRequestURL().toString());
			FileCopyUtils.copy(new File(""),null);
			file.write("/tmp/upload/"+file.getSubmittedFileName());
//			file.transferTo(new File("/data/"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("thumbnailsUrl", "http://localhost/medical/"+file.getSubmittedFileName());
		
		
		return hashMap;
	}
	
	

}
