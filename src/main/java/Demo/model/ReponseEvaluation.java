package Demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REPONSE_EVALUATION database table.
 * 
 */
@Entity
@Table(name="REPONSE_EVALUATION")
@NamedQuery(name="ReponseEvaluation.findAll", query="SELECT r FROM ReponseEvaluation r")
public class ReponseEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_REPONSE_EVALUATION")
	private long idReponseEvaluation;

	private String commentaire;

	private String nom;

	private String prenom;

	//uni-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="NO_ETUDIANT", insertable=false, updatable=false)
	private Etudiant etudiantt;

	//uni-directional many-to-one association to Evaluation
	@ManyToOne
	@JoinColumn(name="ID_EVALUATION", insertable=false, updatable=false)
	private Evaluation evaluationn;

	public ReponseEvaluation() {
	}

	public long getIdReponseEvaluation() {
		return this.idReponseEvaluation;
	}

	public void setIdReponseEvaluation(long idReponseEvaluation) {
		this.idReponseEvaluation = idReponseEvaluation;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Etudiant getEtudiantt() {
		return this.etudiantt;
	}

	public void setEtudiantt(Etudiant etudiantt) {
		this.etudiantt = etudiantt;
	}

	public Evaluation getEvaluationn() {
		return this.evaluationn;
	}

	public void setEvaluationn(Evaluation evaluationn) {
		this.evaluationn = evaluationn;
	}

}