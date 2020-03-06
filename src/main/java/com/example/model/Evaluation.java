package com.example.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EVALUATION database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluation.findAll", query="SELECT e FROM Evaluation e")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EVALUATION")
	private long idEvaluation;

	@Temporal(TemporalType.DATE)
	@Column(name="DEBUT_REPONSE")
	private Date debutReponse;

	private String designation;

	private String etat;

	@Temporal(TemporalType.DATE)
	@Column(name="FIN_REPONSE")
	private Date finReponse;

	@Column(name="NO_EVALUATION")
	private BigDecimal noEvaluation;

	private String periode;

	//uni-directional many-to-one association to ElementConstitutif
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODE_EC", referencedColumnName="CODE_EC", insertable=false, updatable=false),
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false),
		@JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE", insertable=false, updatable=false)
		})
	private ElementConstitutif elementConstitutiff;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT", insertable=false, updatable=false)
	private Enseignant enseignantt;

	//uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ANNEE_UNIVERSITAIRE", referencedColumnName="ANNEE_UNIVERSITAIRE", insertable=false, updatable=false),
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false)
		})
	private Promotion promotionn;

	//bi-directional many-to-one association to UniteEnseignement
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false),
		@JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE", insertable=false, updatable=false)
		})
	private UniteEnseignement uniteEnseignementt;

	public Evaluation() {
	}

	public long getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public Date getDebutReponse() {
		return this.debutReponse;
	}

	public void setDebutReponse(Date debutReponse) {
		this.debutReponse = debutReponse;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getFinReponse() {
		return this.finReponse;
	}

	public void setFinReponse(Date finReponse) {
		this.finReponse = finReponse;
	}

	public BigDecimal getNoEvaluation() {
		return this.noEvaluation;
	}

	public void setNoEvaluation(BigDecimal noEvaluation) {
		this.noEvaluation = noEvaluation;
	}

	public String getPeriode() {
		return this.periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public ElementConstitutif getElementConstitutiff() {
		return this.elementConstitutiff;
	}

	public void setElementConstitutiff(ElementConstitutif elementConstitutiff) {
		this.elementConstitutiff = elementConstitutiff;
	}

	public Enseignant getEnseignantt() {
		return this.enseignantt;
	}

	public void setEnseignantt(Enseignant enseignantt) {
		this.enseignantt = enseignantt;
	}

	public Promotion getPromotionn() {
		return this.promotionn;
	}

	public void setPromotionn(Promotion promotionn) {
		this.promotionn = promotionn;
	}

	public UniteEnseignement getUniteEnseignementt() {
		return this.uniteEnseignementt;
	}

	public void setUniteEnseignementt(UniteEnseignement uniteEnseignementt) {
		this.uniteEnseignementt = uniteEnseignementt;
	}

}