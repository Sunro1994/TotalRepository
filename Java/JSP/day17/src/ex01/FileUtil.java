package ex01;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUtil {

	private static FileUtil instance = new FileUtil();
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	private FileUtil() {}
	
	// 프로젝트 내부 폴더가 아니라, 고정된 특정 위치에 파일을 업로드 하도록 지정한다
	private String saveDirectory = "E:\\upload";
	private int maxPostSize = 1024 * 1024 * 20;
	private String encoding = "UTF-8";
	private DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	public String getFileName(HttpServletRequest request) throws IOException {
		String fileName = null;
		
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		MultipartRequest mpRequest = new MultipartRequest(
				request, saveDirectory, maxPostSize, encoding, policy
		);
		
		File f = mpRequest.getFile("uploadFile");
		fileName = f.getName();				// 업로드된 파일의 이름
		
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());
		
		return fileName;
	}
	
}










