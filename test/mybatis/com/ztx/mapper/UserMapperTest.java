package mybatis.com.ztx.mapper;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import mybatis_01.mybatis.com.ztx.mapper.UserMapper;
import mybatis_01.mybatis.com.ztx.po.User;

import org.junit.Before;
import org.junit.Test;

public class UserMapperTest {

	SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";

		// 得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件的信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserById() throws Exception {
		// 创建会话（必须有）
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis 自动生成mapper代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// 调用UserMapper 代理

		User user = userMapper.findUserById(1);

		System.out.println(user);

	}
	
	@Test 
	public void testFindUserByName() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> userList = userMapper.findUserByName("小明");
		
		System.out.println(userList);
		
		sqlSession.close();
	}

	
}
