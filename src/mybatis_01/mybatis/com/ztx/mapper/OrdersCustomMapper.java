package mybatis_01.mybatis.com.ztx.mapper;

import java.util.List;

import mybatis_01.mybatis.com.ztx.po.Orders;
import mybatis_01.mybatis.com.ztx.po.OrdersCustom;

public interface OrdersCustomMapper {

	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	public List<Orders> findOrdersUserResulMap()throws Exception;
	
	// 查询订单（关联用户）及订单明细
	public List<Orders> findOrdersAndOrderDetailResulMap()throws Exception;
}
