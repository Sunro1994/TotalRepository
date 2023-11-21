package board2;

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
	
	private FileUtil() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}

	private String saveDirectory = "E:\\board2_upload_file";
	private int maxPostSize = 20 * 1024 * 1024;
	private String encoding = "UTF-8";
	private DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
	// <jsp:useBean>, <jsp:setProperty>로 처리할 수 없는 유형의 객체를 처리하기 위해서 만든다
	public BoardDTO getDTO(HttpServletRequest request) throws IOException {
		// 반환형 준비
		BoardDTO dto = null;
		
		// 파일 업로드 및 MultipartRequest 객체 생성 (다른 파라미터 불러오기 위해서)
		MultipartRequest mpRequest = new MultipartRequest(
				request, saveDirectory, maxPostSize, encoding, policy
		);
		
		// 모든 파라미터를 문자열 형태로 가져오기
		String idx = mpRequest.getParameter("idx");
		String title = mpRequest.getParameter("title");
		String writer = mpRequest.getParameter("writer");
		String content = mpRequest.getParameter("content");
		File uploadFile = mpRequest.getFile("uploadFile");
		
		// 잘 들어오는지 확인	(여러 방식으로 테스트해본다. 첨부파일을 넣거나 빼거나 등등)
		System.out.println(idx);
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		System.out.println(uploadFile);
		System.out.println();
		
		dto = new BoardDTO();
		if(idx != null) {	// 새글이면 idx가 안들어오고, 수정이면 idx도 들어온다
			dto.setIdx(Integer.parseInt(idx));	// 문자열을 정수형으로 변환
		}
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		if(uploadFile != null) {	// 사용자가 파일을 첨부할 수도 있고, 아닐수도 있다
			dto.setUploadFile(uploadFile.getName());
		}
		
		return dto;	// 만들어진 dto 반환
	}

	public boolean delete(String uploadFile) {
		boolean flag = false;
		File f = new File(saveDirectory, uploadFile);
		if(f.exists()) {
			flag = f.delete();
		}
		return flag;
	}
}



















