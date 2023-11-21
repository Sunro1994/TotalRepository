package com.itbank.model;

/*
 * 이름         널?       유형            
---------- -------- ------------- 
IDX        NOT NULL NUMBER        
MENU_NAME  NOT NULL VARCHAR2(100) 
MENU_TYPE  NOT NULL VARCHAR2(50)  
MENU_INTRO          VARCHAR2(200) 
MENU_PRICE NOT NULL NUMBER        
MENU_PWD   NOT NULL VARCHAR2(100) 
 */
public class MenuDTO {
	private int idx;
	private String menu_name;
	private String menu_type;
	private String menu_intro;
	private int menu_price;
	private String menu_pwd;
	public String getMenu_type() {
		return menu_type;
	}
	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	public String getMenu_pwd() {
		return menu_pwd;
	}
	public void setMenu_pwd(String menu_pwd) {
		this.menu_pwd = menu_pwd;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_intro() {
		return menu_intro;
	}
	public void setMenu_intro(String menu_intro) {
		this.menu_intro = menu_intro;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
}
