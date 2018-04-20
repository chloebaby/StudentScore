package interfaceDAO;

import model.Users;

public interface UserDAO {
	void createUser(Users u);
	Users userCheck(String id);
    void deleteUser(String id);
    void updateUser(Users u);
}
