package com.xdlv.weixing.bean;

import com.xdlv.weixing.bean.PrimaryKey;

public interface PrimaryKeyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_primary_key
	 * @mbggenerated
	 */
	int deletePrimaryKeyByKey(String tableName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_primary_key
	 * @mbggenerated
	 */
	int insert(PrimaryKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_primary_key
	 * @mbggenerated
	 */
	PrimaryKey selectPrimaryKeyByKey(String tableName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_primary_key
	 * @mbggenerated
	 */
	int updateByPrimaryKey(PrimaryKey record);
}