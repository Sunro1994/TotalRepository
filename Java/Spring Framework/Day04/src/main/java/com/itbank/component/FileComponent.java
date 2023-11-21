package com.itbank.component;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileComponent {

	private String saveDirectory = "C:\\upload";
	
	
	//생성자가 생성될 때 딱 한번 생성된다.
	public FileComponent() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}
	
	public String upload(MultipartFile f) {
		String fileName = null;
		//사용자가 올린 파일이름
		String originalFileName = f.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		System.out.println("ext : "+ ext);
		String storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += "."+f.getContentType().split("/")[1];
		File dest = new File(saveDirectory,storedFileName);
		try {
			f.transferTo(dest);
			//서버에 저장될 파일 이름, 서버에 저장이 되어있는건지 파악하기 위한 파일네임을 다시 지정
			fileName = dest.getName();  // == f.getOrigianlFilename();
			//해당 클래스를 불러올 때 클래스 내부에서 예외처리를 모두 처리하고 불러오는 것이 좋기 때문에 try-catch문을 써준다.
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
}
