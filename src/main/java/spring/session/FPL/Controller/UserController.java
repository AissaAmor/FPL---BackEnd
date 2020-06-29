package spring.session.FPL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.FPL.Configuration.JwtTokenUtil;
import spring.session.FPL.Entity.JwtResponse;
import spring.session.FPL.Configuration.*;
import spring.session.FPL.Entity.User;
import spring.session.FPL.Repositories.UserRepository;
import spring.session.FPL.Services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userservice ;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(path = "/add" , method = RequestMethod.POST)
	public void ajoutUser (@RequestBody User user) {
		user.setPassword(BCryptManagerUtil.passwordEncoder().encode(user.getPassword()));
		userservice.AjoutUser(user);
	}
	
	public boolean comparePassword(String requestPass, String currentPassword) {
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
		if (passencoder.matches(requestPass,currentPassword)) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

		User user = userservice.loadByUsername(authenticationRequest.getUsername());
		String reqPassword = authenticationRequest.getPassword();
		String currentPass = user.getPassword();
		if (comparePassword(reqPassword, currentPass)) {
			System.out.println("valid" + "/" + user.getPassword());
			final String token = jwtTokenUtil.generateToken(user);
			return ResponseEntity.ok(new JwtResponse(token));
		} else {
			System.out.println("invalid" + "/" + reqPassword + "/" + currentPass);
			return ResponseEntity.ok(null);
		}
	}
}
