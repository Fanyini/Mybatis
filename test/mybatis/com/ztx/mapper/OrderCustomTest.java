package mybatis.com.ztx.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import mybatis_01.mybatis.com.ztx.mapper.OrdersCustomMapper;
import mybatis_01.mybatis.com.ztx.po.Orders;
import mybatis_01.mybatis.com.ztx.po.OrdersCustom;
import mybatis_01.mybatis.com.ztx.po.User;

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
		
		List<Orders> list = ordersCustomMapper.findOrdersUserResulMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersAndOrderDetailResulMap() throws Exception{
		// 创建会话（必须有）
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<Orders> list = ordersCustomMapper.findOrdersAndOrderDetailResulMap();
		
		System.out.println(list.toString());
		
		sqlSession.close();
	}
	
	@Test
	public void testFindUserAndItemsResulMap() throws Exception{
		// 创建会话（必须有）
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		
		List<User> list = ordersCustomMapper.findUserAndItemsResulMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		List<Orders> list = ordersCustomMapper.findOrdersUserLazyLoading();
		for(Orders orders : list){
			// 执行getUser() 去查询用户信息，这里实现的是按需查询
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}
}
