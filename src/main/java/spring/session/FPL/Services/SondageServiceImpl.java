package spring.session.FPL.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.FPL.Entity.Sondage;
import spring.session.FPL.Repositories.SondageRepository;

@Service("SondageService")
public class SondageServiceImpl implements SondageService {

	@Autowired
	SondageRepository sondagerepository;
	
	@Autowired
	SondageService sondageservice ;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void AjoutSondage(Sondage sondage) {
		sondagerepository.save(sondage);
		
	}

	@Override
	public Sondage getSondageById(Integer id) {
		return sondagerepository.findById(id).get();
	}

	@Override
	public List<Sondage> getAll() {
		
		return sondagerepository.findAll();
				
	}

}
