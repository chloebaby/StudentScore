package service;

import DAOImplementation.UserDAOImplementation;
import interfaceDAO.UserDAO;
import model.Users;

public class UserService {
	private static UserService um = null;
	static {
		if(um == null) {
			um = new UserService();
			um.setUserDAO(new UserDAOImplementation());
		}
	}
	
	UserDAO useDAO;
	public UserDAO getUserDAO() {
		return useDAO;
	}
	
	public static UserService getInstance() {
		return um;
	}
	
	public void setUserDAO(UserDAO useDAO) {
		this.useDAO = useDAO;
	}
	
	public void createUser(Users u) {
		useDAO.createUser(u);
	}
	
	public Users userCheck(String name) {
		return useDAO.userCheck(name);
	}
	
	public void updateUser(Users u) {
		useDAO.updateUser(u);
	}

}
