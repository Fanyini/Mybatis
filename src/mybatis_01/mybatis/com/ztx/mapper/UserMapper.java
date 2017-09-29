package mybatis_01.mybatis.com.ztx.mapper;

import java.util.List;

import mybatis_01.mybatis.com.ztx.po.User;
import mybatis_01.mybatis.com.ztx.po.UserCustomer;
import mybatis_01.mybatis.com.ztx.po.UserQueryVo;

/**
 *  dao接口，用户管理
 * @author dell
 *
 */
public interface UserMapper {

	// 
	public User findUserById(int id) throws Exception;
	
	// 
	public List<User> findUserByName(String value)throws Exception;
	
	//
	public void insertUser(User user) throws Exception;
	
	//
	public void deleteUser(int id)throws Exception;
	
	public List<UserCustomer> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	// 使用resultMap 映射结果集
	public List<UserCustomer> findUserByIdResultMap(int id) throws Exception;

	//
	public void updateUser(User user) throws Exception;
}
