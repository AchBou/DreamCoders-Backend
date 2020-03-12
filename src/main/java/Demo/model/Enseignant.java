package Demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the ENSEIGNANT database table.
 * 
 */
@Entity
@NamedQuery(name="Enseignant.findAll", query="SELECT e FROM Enseignant e")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "ENS_SEQ",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	@Column(name="NO_ENSEIGNANT")
	private Integer noEnseignant;

	private String adresse;

	@Column(name="CODE_POSTAL")
	private String codePostal;

	@Column(name="EMAIL_PERSO")
	private String emailPerso;

	@Column(name="EMAIL_UBO")
	private String emailUbo;

	private String mobile;

	private String nom;

	private String pays;

	private String prenom;

	private String sexe;

	private String telephone;

	@Column(name="TYPE")
	private String type;

	private String ville;

	@OneToMany(mappedBy = "enseignantt")
	@JsonIgnoreProperties(value = "enseignantt")
	private List<Evaluation> evaluations;

	public Enseignant() {
	}


	public Integer getNoEnseignant() {
		return this.noEnseignant;
	}

	public void setNoEnseignant(Integer noEnseignant) {
		this.noEnseignant = noEnseignant;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getEmailPerso() {
		return this.emailPerso;
	}

	public void setEmailPerso(String emailPerso) {
		this.emailPerso = emailPerso;
	}

	public String getEmailUbo() {
		return this.emailUbo;
	}

	public void setEmailUbo(String emailUbo) {
		this.emailUbo = emailUbo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}