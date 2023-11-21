package com.itbank.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.MenuDTO;

@Repository
public interface orderDAO {

	@Select("select * from order_menu order by menu_type")
	ArrayList<MenuDTO> selectList();

	@Insert("insert into order_menu(menu_name, menu_intro, menu_price ,menu_type, menu_pwd) "
			+ "values(#{menu_name}, #{menu_intro}, #{menu_price},#{menu_type} , #{menu_pwd})")
	int insert(MenuDTO dto);

	
	@Select("select * from order_menu where idx=${idx}")
	MenuDTO selectOne(int idx);
	
	@Update("update order_menu"
			+ " set menu_name=#{menu_name},menu_intro=#{menu_intro}, menu_price=#{menu_price}"
			+ ",menu_type=#{menu_type} where idx=${idx}")
	int modify(MenuDTO dto);

	@Delete("delete order_menu where idx=${idx}")
	int delete(int idx);

	@Select("select * from order_menu where menu_type='술'")
	ArrayList<MenuDTO> selectDrink();
	
	@Select("select * from order_menu where menu_type='추가메뉴'")
	ArrayList<MenuDTO> selectAdditional();

	@Select("select * from order_menu where instr(menu_name,#{findFood})>0 or instr(menu_intro,#{findFood})>0")
	ArrayList<MenuDTO> search(String findFood);

	@Select("select * from order_menu where idx=(select  round(dbms_random.value(1,3),0) from dual)")
	MenuDTO selectRandom();

	
	
}
