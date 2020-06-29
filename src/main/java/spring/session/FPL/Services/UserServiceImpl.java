package spring.session.FPL.Services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.FPL.Entity.User;
import spring.session.FPL.Repositories.UserRepository;

@Service("AdminService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository ;
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void AjoutUser(User user) {
		userRepository.save(user);
	}

//	@Override
//	public void UpdateAdmin(Admin admin) {
//		adminrepository.save(admin);
//	}
	

	@Override
	public void DeleteUser(User user) {
		userRepository.delete(user);		
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();

	}

	@Override
	public User loadByUsername(String username) {
		
		TypedQuery<User> query = (TypedQuery<User>) em
				.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
		User user = query.setParameter("username", username).getSingleResult();
		return user;
	}

}
