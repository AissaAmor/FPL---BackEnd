package spring.session.FPL.Services;

import spring.session.FPL.Entity.User;

public interface UserService {

	public void AjoutUser(User user);

//	public void UpdateAdmin(Admin admin);

	public void DeleteUser(User user);
	
	public User getUserById(Integer id);

	public User loadByUsername(String username);
}
