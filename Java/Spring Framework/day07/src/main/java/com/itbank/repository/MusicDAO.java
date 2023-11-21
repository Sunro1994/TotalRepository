package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.MusicDTO;

@Repository
public interface MusicDAO {

	List<MusicDTO> selectAll();

}
