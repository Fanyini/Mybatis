package mybatis_01.mybatis.com.ztx.po;

// 用户信息的包装类型
public class UserQueryVo {

	// 在这里包装所需要的查询条件
	private UserCustomer userCustomer;

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

}
