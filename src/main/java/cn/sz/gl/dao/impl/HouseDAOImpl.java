package cn.sz.gl.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.sz.gl.dao.IHouseDAO;
import cn.sz.gl.factory.MySqlSessionFactory;
import cn.sz.gl.pojo.House;

public class HouseDAOImpl implements IHouseDAO {

	public List<House> findHouse(Map<String, Object> map) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getMySqlSession();
			return sqlSession.selectList("cn.sz.gl.pojo.House.findHouse", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSqlSession();
		}
		return null;
	}

	public int getCount(Map<String, Object> map) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getMySqlSession();
			return sqlSession.selectOne("cn.sz.gl.pojo.House.countHouse", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSqlSession();
		}
		return 0;
	}

}
