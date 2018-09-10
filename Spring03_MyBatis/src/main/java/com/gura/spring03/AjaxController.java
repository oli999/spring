package com.gura.spring03;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AjaxController {
	
	@RequestMapping("/ajax/upload_form")
	public String uploadForm(){
		
		return "ajax/upload_form";
	}
	@RequestMapping("/ajax/upload")
	@ResponseBody
	public Map<String, Object> upload(@RequestParam MultipartFile file){
		String orgFileName=file.getOriginalFilename();
		System.out.println("업로드된 파일명:"+orgFileName);
		Map<String, Object> map=new HashMap<>();
		map.put("msg", "업로드된 파일명은 "+orgFileName+" 입니다.");
		return map;
	}
	@RequestMapping("/ajax/upload2")
	@ResponseBody
	public Map<String, Object> upload2(HttpSession session ,
			@RequestParam MultipartFile file){
		// upload 폴더의 실제 경로 
		String realPath=
				session.getServletContext().getRealPath("/upload");
		String orgFileName=file.getOriginalFilename();
		// 저장할 파일의 상세 경로
		String filePath=realPath+File.separator;
		
		// 파일 시스템에 저장할 파일명을 만든다.
		String saveFileName=System.currentTimeMillis()+orgFileName;
		// 업로드 폴더가 존재 하지 않으면 만든다. 
		File uploadFolder=new File(filePath);
		if(!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		try {
			//업로드 폴더에 파일을 저장한다.
			file.transferTo(new File(filePath+saveFileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
		//저장된 파일명을 json 으로 응답하기 위해 
		Map<String, Object> map=new HashMap<>();
		map.put("fileName", saveFileName);
		
		return map;
	}
}



















