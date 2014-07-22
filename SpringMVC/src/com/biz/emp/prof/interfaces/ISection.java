package com.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ISection {

	void insertValues(Object o)throws SQLException;
	void updateSection(Object o,String columnName,int value)throws SQLException;
	ArrayList<Object> selectData() throws SQLException;
	
}
