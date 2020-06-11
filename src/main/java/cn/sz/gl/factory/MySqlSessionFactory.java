package cn.sz.gl.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {

	private static final String RESOURCE = "mybatis_config.xml";
	private static InputStream is = null;
	private static SqlSessionFactoryBuilder builder = null;
	private static SqlSessionFactory factory = null;
	//用来在同一个线程范围内，共享一个对象
	private static ThreadLocal<SqlSession> threadlocal = new ThreadLocal<SqlSession>();
	
	static {
		try {
			is = Resources.getResourceAsStream(RESOURCE);
			builder = new SqlSessionFactoryBuilder();
			factory = builder.build(is);
		} catch (IOException e) {
			System.out.println("********************配置文件异常************************");
		}
	}
	
	
	/**
	 * 用来获取数据库连接
	 * @return
	 */
	public static SqlSession getMySqlSession() {
		//从threadlocal对象中，获取连接对象
		SqlSession sqlSession = threadlocal.get();
		//如果threadlocal里面，没有保存连接对象，那么通过工厂来创建一个数据库连接对象
		if(sqlSession==null) {
			sqlSession = factory.openSession();
		}
		//获取连接后，把连接对象存入threadlocal里面，方便后续关闭该连接，和后续使用该连接
		threadlocal.set(sqlSession);
		return sqlSession;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public static void closeSqlSession() {
		//要想关闭连接，首先需要从threadlocal里面获取连接
		SqlSession sqlSession = threadlocal.get();
		if(sqlSession!=null) {
			sqlSession.close();
		}
		//需要清空threadlocal,否则下次再获取连接的时候，会得到一个已经关闭的连接
		threadlocal.set(null);
	}
	
}
