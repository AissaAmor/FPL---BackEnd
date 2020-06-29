package spring.session.FPL.Services;

import java.util.List;

import spring.session.FPL.Entity.Sondage;

public interface SondageService {

	public void AjoutSondage (Sondage sondage) ;

	public Sondage getSondageById(Integer id);

	List<Sondage> getAll();
	
}
