package com.itbank.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.MenuDTO;

@Repository
public interface BasketDAO {

	@Insert("insert into order_basket(food_id,price) "
			+ "values("
			+ "(select idx from order_menu where idx=${idx}),"
			+ "(select menu_price from order_menu where idx=${idx}))")
	int insert(int idx);

	@Select("select * from order_menu where idx in (select food_id from order_basket)")
	ArrayList<MenuDTO> selectList();

	@Select("select sum(menu_price) from order_menu where idx in (select food_id from order_basket)")
	int totalPrice();

	@Delete("delete order_basket")
	int deleteAll();

	
	
}
