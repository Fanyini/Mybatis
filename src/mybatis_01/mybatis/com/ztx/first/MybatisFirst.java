package mybatis_01.mybatis.com.ztx.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.naming.resources.Resource;
import org.junit.Test;

import mybatis_01.mybatis.com.ztx.po.User;

public class MybatisFirst {

	@Test
	public void findUserByIdTest() throws IOException{
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
}
