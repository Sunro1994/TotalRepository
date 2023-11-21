package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO dao;
	
	
	public MemberDTO login(MemberDTO dto) {
		//1)해쉬처리되지 않은 사용자 입력값(request에 담겨서 넘어온 데이터)를 받아서
		//2) DB의 저장된 값과 비교할 수 있도록 해쉬처리하고
		// 현재 DB의 데이터
		MemberDTO dbUser = dao.selectOne(dto);
		// DB에서 가져온 현재 비밀번호와 salt값
		if(dbUser!=null) {
			
		String dbPw = dbUser.getUserpw();
		String dbSalt = dbUser.getSalt();
		//입력한 비밀번호값을 해쉬코드화해서 현재 비밀번호와 비교한다.
		String tryHash = hashComponent.getHash(dto.getUserpw(), dbSalt);
		if(tryHash.equals(dbPw)) {
			//3) 반환 값을 DAO에게 넘긴다. 
			return dbUser;
		}
		//4) DAO에 의해 처리된 값(객체)를 컨트롤러에게 반환하여 이후 처리를 진행하도록 한다.
		
		}
		return null;
	}


	public int join(MemberDTO dto) {
		
		String salt = hashComponent.getSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setUserpw(hash);
		dto.setSalt(salt);
		
		int row = dao.insertMember(dto);
		
		
		
		return row;
	}


	public List<MemberDTO> selectAll() {

		List<MemberDTO> list = dao.selectAll();
		list.forEach(member -> member.setUserpw("x"));
		
		
		return list;
	}

	
}
