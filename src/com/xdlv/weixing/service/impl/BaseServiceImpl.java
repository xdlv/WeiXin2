package com.xdlv.weixing.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.xdlv.weixing.bean.PrimaryKey;
import com.xdlv.weixing.bean.PrimaryKeyMapper;
import com.xdlv.weixing.service.BaseService;

public class BaseServiceImpl implements BaseService {

	PrimaryKeyMapper primaryKeyMapper;
	
	static Map<String, int[]> primaryKeyMap = new HashMap<String, int[]>();
	final static int PRE_OCCUPY_MAX = 10;
	
	public void setPrimaryKeyMapper(PrimaryKeyMapper primaryKeyMapper) {
		this.primaryKeyMapper = primaryKeyMapper;
	}
	
	@Override
	public int getAllCount() {
		return 0;
	}

	@Override
	public int getPrimaryKey(String tableName) {
		int[] value;
		synchronized (primaryKeyMap) {
			value = primaryKeyMap.get(tableName);
			if (value == null || value[0] == value[1]){
				PrimaryKey primaryKey = primaryKeyMapper.selectPrimaryKeyByKey(tableName);
				if (primaryKey == null){
					value = new int[]{1, PRE_OCCUPY_MAX};
					primaryKeyMapper.insert(new PrimaryKey(tableName, PRE_OCCUPY_MAX));
				} else {
					value = new int[]{primaryKey.getCurrentId() + 1, primaryKey.getCurrentId() + PRE_OCCUPY_MAX};
					primaryKeyMapper.updateByPrimaryKey(new PrimaryKey(tableName, value[1]));
				}
				primaryKeyMap.put(tableName, value);
			} else {
				value[0] += 1;
			}
		}
		return value[0];
	}
}