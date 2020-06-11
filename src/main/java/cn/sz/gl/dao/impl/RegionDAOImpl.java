package cn.sz.gl.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.sz.gl.dao.IRegionDAO;
import cn.sz.gl.factory.MySqlSessionFactory;
import cn.sz.gl.pojo.Region;

public class RegionDAOImpl implements IRegionDAO {

	public List<Region> findRegion() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MySqlSessionFactory.getMySqlSession();
			return sqlSession.selectList("cn.sz.gl.pojo.Region.findRegion");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MySqlSessionFactory.closeSqlSession();
		}
		return null;
	}

}
