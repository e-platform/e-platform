package example;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Resource
	private UserDaoImpl userDaoImpl;
//	@Resource
//	private DataSource dataSource;

	/*xml配置方式
//	public DataSource getDataSource() {
//		return dataSource;
//	}

//	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	*/
	@Transactional
	public String getUserName(){
		System.out.println("====userDaoImpl====="+userDaoImpl);
		System.out.println(userDaoImpl.getList("from User"));
		//System.out.println(userDaoImpl.getList("from User"));
		return "zenglongx";
	}
	
	@Transactional
	public void test(){
		User user = new User();
		user.setUserName("邢增龙");
		//新增
		userDaoImpl.save(user);
		System.out.println("新增："+user);
		//查询
		List<User> users = userDaoImpl.findByNmae("邢增龙");
		if(users.size() > 0){
			User usert = users.get(0);
			usert.setUserName("李姣");
			userDaoImpl.update(usert);
			System.out.println("修改："+usert);
			userDaoImpl.delete(usert.getUserId());
			System.out.println("删除："+usert);
		}
	}
	
}
