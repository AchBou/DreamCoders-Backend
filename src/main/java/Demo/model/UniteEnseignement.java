package Demo.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the UNITE_ENSEIGNEMENT database table.
 * 
 */
@Entity
@Table(name="UNITE_ENSEIGNEMENT")
@NamedQuery(name="UniteEnseignement.findAll", query="SELECT u FROM UniteEnseignement u")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UniteEnseignement implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UniteEnseignementPK id;

	private String description;

	private String designation;

	@Column(name="NBH_CM")
	private BigDecimal nbhCm;

	@Column(name="NBH_TD")
	private BigDecimal nbhTd;

	@Column(name="NBH_TP")
	private BigDecimal nbhTp;

	private String semestre;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy= "uniteEnseignement")
	private List<Evaluation> evaluations;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT", insertable=false, updatable=false)
	private Enseignant enseignantt;

	//uni-directional many-to-one association to Formation
	@ManyToOne
	@JoinColumn(name="CODE_FORMATION", insertable=false, updatable=false)
	private Formation formationn;

	public UniteEnseignement() {
	}

	public UniteEnseignementPK getId() {
		return this.id;
	}

	public void setId(UniteEnseignementPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getNbhCm() {
		return this.nbhCm;
	}

	public void setNbhCm(BigDecimal nbhCm) {
		this.nbhCm = nbhCm;
	}

	public BigDecimal getNbhTd() {
		return this.nbhTd;
	}

	public void setNbhTd(BigDecimal nbhTd) {
		this.nbhTd = nbhTd;
	}

	public BigDecimal getNbhTp() {
		return this.nbhTp;
	}

	public void setNbhTp(BigDecimal nbhTp) {
		this.nbhTp = nbhTp;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


	@JsonIgnore
	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setUniteEnseignement(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setUniteEnseignement(null);

		return evaluation;
	}


	@JsonIgnore
	public Enseignant getEnseignantt() {
		return this.enseignantt;
	}

	public void setEnseignantt(Enseignant enseignantt) {
		this.enseignantt = enseignantt;
	}

	@JsonIgnore
	public Formation getFormationn() {
		return this.formationn;
	}

	public void setFormationn(Formation formationn) {
		this.formationn = formationn;
	}

}