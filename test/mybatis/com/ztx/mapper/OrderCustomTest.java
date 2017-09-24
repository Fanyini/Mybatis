package mybatis.com.ztx.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import mybatis_01.mybatis.com.ztx.mapper.OrdersCustomMapper;
import mybatis_01.mybatis.com.ztx.po.OrdersCustom;

public class OrderCustomTest {
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
	public void testFindOrdersUser() throws Exception{
		// 创建会话（必须有）
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<OrdersCustom> list = ordersCustomMapper.findOrdersUser();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserResulMap() throws Exception{
		// 创建会话（必须有）
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<Order> list = ordersCustomMapper.findOrdersUserResulMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}
}
