package spring.session.FPL.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sondage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_sondage ;
	private String titre;
	private String description;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "Id_user")
//	private User user;
	
	public Sondage(int id_sondage, String titre, String description) {
		super();
		Id_sondage = id_sondage;
		this.titre = titre;
		this.description = description;
	}

	
	public Sondage() {
		super();
	}


	public int getId_sondage() {
		return Id_sondage;
	}

	public void setId_sondage(int id_sondage) {
		Id_sondage = id_sondage;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Sondage [Id_sondage=" + Id_sondage + ", titre=" + titre + ", description=" + description + "]";
	}
	
	
	
}
