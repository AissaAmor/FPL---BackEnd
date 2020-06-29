package spring.session.FPL.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.FPL.Entity.Sondage;
import spring.session.FPL.Repositories.SondageRepository;
import spring.session.FPL.Repositories.UserRepository;
import spring.session.FPL.Services.SondageService;
import spring.session.FPL.Services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sondage")
public class SondageController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userservice ;
	
	@Autowired
	SondageRepository sondagerepository;
	
	@Autowired
	SondageService sondageservice ;
	
	@RequestMapping(path = "/add" , method = RequestMethod.POST)
	public void ajtouSondage(@RequestBody Sondage sondage){
		sondageservice.AjoutSondage(sondage);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Sondage> getAll() {
		System.out.println("eee");
		return sondageservice.getAll();

	}
	
}
