package mybatis_01.mybatis.com.ztx.mapper;

import java.util.List;

import org.apache.logging.log4j.core.config.Order;

import mybatis_01.mybatis.com.ztx.po.OrdersCustom;

public interface OrdersCustomMapper {

	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	public List<Order> findOrdersUserResulMap()throws Exception;
}
