package com.xdlv.weixing.bean;

import com.xdlv.weixing.bean.Dzlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DzlistMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_dzlist
	 * @mbggenerated
	 */
	int insert(Dzlist record);

	List<Dzlist> selectDzlists(@Param("userid")String userid,@Param("isok")String isok, @Param("start")int start, @Param("end")int end);

	int getDzListCount(Dzlist dzlist);

	List<Dzlist> selectDzlistsByYearAndMonth(@Param("wxid")String wxid
			, @Param("year")int year, @Param("month")int month);

    void updateDzlistStatus(Dzlist dzlist);
}