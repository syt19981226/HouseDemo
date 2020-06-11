package cn.sz.gl.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sz.gl.dao.IHouseStyleDAO;
import cn.sz.gl.factory.MySqlSessionFactory;
import cn.sz.gl.pojo.HouseStyle;

public class HouseStyleDAOImpl implements IHouseStyleDAO {

	public List<HouseStyle> findall() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getMySqlSession();
			return sqlSession.selectList("cn.sz.gl.pojo.HouseStyle.findallstyle");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSqlSession();
		}
		return null;
	}

}
