package com.TravelMaker.component;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class FileComponent {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
    private String saveDirectory = "C:\\TravelImg";
    
    /* 생성자 */
    public FileComponent(){
        File dir = new File(saveDirectory);
        if(dir.exists() == false){
           dir.mkdirs();
        }
    }

    /* 파일 업로드  */
    public String upload(MultipartFile upload){
    	if(upload.getOriginalFilename().startsWith("http")) {
    		File dest = new File(saveDirectory, upload.getOriginalFilename());
    		
    		 try {
				upload.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		 
    		 return upload.getOriginalFilename();
    	}
    	
        String originalFileName = upload.getOriginalFilename();
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
        String EncodingProfileImg = UUID.randomUUID().toString().replace("-", "");
        EncodingProfileImg += ext;

        File dest = new File(saveDirectory, EncodingProfileImg);
        System.out.println(EncodingProfileImg);

        try {
            upload.transferTo(dest);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return null;
        }
        return EncodingProfileImg;
    }





}
