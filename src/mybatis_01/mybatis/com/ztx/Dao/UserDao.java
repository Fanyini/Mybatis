package mybatis_01.mybatis.com.ztx.Dao;

import mybatis_01.mybatis.com.ztx.po.User;

/**
 *  dao接口，用户管理
 * @author dell
 *
 */
public interface UserDao {

	// 
	public User findUserById(int id) throws Exception;
	
	//
	public void insertUser(User user) throws Exception;
	
	//
	public void deleteUser(int id)throws Exception;
}
