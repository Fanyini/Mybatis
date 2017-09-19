package mybatis_01.mybatis.com.ztx.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis_01.mybatis.com.ztx.po.User;

public class MybatisFirst {

	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";

		// 得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件的信息
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 通过会话工厂，创建会话SqlSession
		// 打开会话
		SqlSession session = sessionFactory.openSession();

		// 通过sqlSession操作数据库\
		// 第一个参数：映射文件中statement 的id，等于 namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne 结果是与映射文件中所匹配的resultType类型的参数
		User user = session.selectOne("test.findUserById", 1);

		System.out.println(user);

		// 释放资源
		session.close();
	}

	// 通过姓名模糊查询
	@Test
	public void findUserByNameTest() throws IOException {
		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = factory.openSession();

		List<User> userList = sqlSession.selectList("test.findUserByName", "小明");

		System.out.println(userList);

		sqlSession.close();

	}

	// 向数据库中插入一条数据
	@Test
	public void insertUserTest() throws Exception {
		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = factory.openSession();

		User user = new User();
		user.setAddress("河南郑州");
		user.setBirthday(new Date());
		user.setUsername("王小明");
		session.insert("test.insertUser", user);
		// 提交事务
		session.commit();
		// 获取用户信息主键
		System.out.println(user.getId());
		// 关闭会话
		session.close();
	}
	
	
	// 删除用户信息
	@Test
	public void deleteUserTest() throws Exception{
		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = factory.openSession();
		
		session.delete("test.deleteUser", 27);
		// 提交事务
		session.commit();
		// 关闭会话
		session.close();
	}

	// 更新用户信息
	@Test
	public void updateUserTest() throws IOException{
		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = factory.openSession();

		User user = new User();
		user.setId(28);
		user.setAddress("河南郑州");
		user.setBirthday(new Date());
		user.setUsername("王da明");
		session.insert("test.updateUser", user);
		// 提交事务
		session.commit();
		// 关闭会话
		session.close();
	}
}
