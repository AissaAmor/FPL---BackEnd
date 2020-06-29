package spring.session.FPL.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_user ;
	private String nom ;
	private String prenom ;
	private String username ;
	private String password ;
	
//	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "Sondage")
//	private List<Sondage> sondage;
	
	public User(int id_user, String nom, String prenom, String username, String password) {
		super();
		Id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public int getId_user() {
		return Id_user;
	}

	public void setId_user(int id_user) {
		Id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [Id_user=" + Id_user + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
