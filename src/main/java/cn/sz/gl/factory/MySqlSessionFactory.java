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
	//������ͬһ���̷߳�Χ�ڣ�����һ������
	private static ThreadLocal<SqlSession> threadlocal = new ThreadLocal<SqlSession>();
	
	static {
		try {
			is = Resources.getResourceAsStream(RESOURCE);
			builder = new SqlSessionFactoryBuilder();
			factory = builder.build(is);
		} catch (IOException e) {
			System.out.println("********************�����ļ��쳣************************");
		}
	}
	
	
	/**
	 * ������ȡ���ݿ�����
	 * @return
	 */
	public static SqlSession getMySqlSession() {
		//��threadlocal�����У���ȡ���Ӷ���
		SqlSession sqlSession = threadlocal.get();
		//���threadlocal���棬û�б������Ӷ�����ôͨ������������һ�����ݿ����Ӷ���
		if(sqlSession==null) {
			sqlSession = factory.openSession();
		}
		//��ȡ���Ӻ󣬰����Ӷ������threadlocal���棬��������رո����ӣ��ͺ���ʹ�ø�����
		threadlocal.set(sqlSession);
		return sqlSession;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public static void closeSqlSession() {
		//Ҫ��ر����ӣ�������Ҫ��threadlocal�����ȡ����
		SqlSession sqlSession = threadlocal.get();
		if(sqlSession!=null) {
			sqlSession.close();
		}
		//��Ҫ���threadlocal,�����´��ٻ�ȡ���ӵ�ʱ�򣬻�õ�һ���Ѿ��رյ�����
		threadlocal.set(null);
	}
	
}
