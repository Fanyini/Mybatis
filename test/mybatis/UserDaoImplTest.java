package mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis_01.mybatis.com.ztx.Dao.UserDao;
import mybatis_01.mybatis.com.ztx.Dao.UserDaoImpl;
import mybatis_01.mybatis.com.ztx.mapper.UserMapper;
import mybatis_01.mybatis.com.ztx.po.User;
import mybatis_01.mybatis.com.ztx.po.UserCustomer;
import mybatis_01.mybatis.com.ztx.po.UserQueryVo;

public class UserDaoImplTest {

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
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		User user = userDao.findUserById(1);
		
		System.out.println(user);
	}
	@Test
	public void testFindUserByName() throws Exception {
		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis 自动生成mapper代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用UserMapper 代理

		List<User> user = userMapper.findUserByName("");

		System.out.println(user);
		sqlSession.close();

	}
	
	
	@Test
	public void testFindUserList() throws Exception {
		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis 自动生成mapper代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		UserQueryVo queryVo = new UserQueryVo();
		UserCustomer customer = new UserCustomer();
		customer.setSex("1");
		customer.setUsername("小明");
		queryVo.setUserCustomer(customer);
		
		// 调用UserMapper 代理

		List<UserCustomer> user = userMapper.findUserList(queryVo);

		System.out.println(user);
		sqlSession.close();
	}
	
	
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		// 创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper对象，mybatis 自动生成mapper代理
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 调用UserMapper 代理

		List<UserCustomer> user = userMapper.findUserByIdResultMap(1);

		System.out.println(user);
		sqlSession.close();
	}
}
