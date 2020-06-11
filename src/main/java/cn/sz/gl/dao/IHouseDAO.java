package cn.sz.gl.dao;

import java.util.List;
import java.util.Map;

import cn.sz.gl.pojo.House;

public interface IHouseDAO {

	/**
	 * 多条件查询房屋信息，并完成分页
	 * @param map
	 * @return
	 */
	public List<House> findHouse(Map<String,Object> map);
	
	/**
	 * 统计满足条件的数据的总行数，配合分页使用
	 * @param map
	 * @return
	 */
	public int getCount(Map<String,Object> map);
}
