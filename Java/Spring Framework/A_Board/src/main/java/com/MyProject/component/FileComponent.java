package com.MyProject.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {
	
	private String saveDirectory = "C:\\upload";
	
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	
	public String makeFileName(MultipartFile f) {
		
		String fileName = f.getOriginalFilename();
		String ext = fileName.substring(fileName.lastIndexOf("."));
		
		String storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += ext;
		File dest = new File(saveDirectory,storedFileName);
		
		try {
			f.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return storedFileName;
	}


	public int delete(String storedFileName) {
		boolean flag = false;
		File f = new File(saveDirectory,storedFileName);
		System.out.println(f.exists());
		if(f.exists()) {
			
			flag = f.delete();
		}
		
		
		return flag==true? 1 : 0;
	}
}
