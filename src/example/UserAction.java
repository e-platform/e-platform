package example;

import javax.annotation.Resource;

public class UserAction extends ExampleSupport{
	public String userName;
	
	@Resource
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	
	public String execute() throws Exception {
		//System.out.println("======userService.getUserName()===="+userService.getUserName());
		this.setUserName(userService.getUserName());
		userService.test();
		return SUCCESS;
    }
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserName() {
		
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
