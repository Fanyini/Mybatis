package mybatis_01.mybatis.com.ztx.Dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis_01.mybatis.com.ztx.po.User;

public class UserDaoImpl implements UserDao {

	SqlSessionFactory sqlSessionFactory = null;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();

		User user = session.selectOne("test.findUserById", 1);

		session.close();

		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();

		session.insert("test.insertUser", user);
		// 提交事务
		session.commit();

		session.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {

		SqlSession session = sqlSessionFactory.openSession();

		session.delete("test.deleteUser", id);
		// 提交事务
		session.commit();
		// 关闭会话
		session.close();

	}

}
