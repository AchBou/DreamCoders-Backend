package Demo.model;

import Demo.model.views.VEtatEvaluation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EVALUATION database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluation.findAll", query="SELECT e FROM Evaluation e")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SequenceIdGenerator15")
	@SequenceGenerator(name="SequenceIdGenerator15", sequenceName = "EVE_SEQ",allocationSize=1)
	@Column(name="ID_EVALUATION")
	private long idEvaluation;

	@Temporal(TemporalType.DATE)
	@Column(name="DEBUT_REPONSE")
	private Date debutReponse;

	@Column(name="DESIGNATION")
	private String designation;

	@ManyToOne
	@JoinColumn(name="ETAT")
	private VEtatEvaluation etat;

	@Temporal(TemporalType.DATE)
	@Column(name="FIN_REPONSE")
	private Date finReponse;

	@Column(name="NO_EVALUATION")
	private BigDecimal noEvaluation;

	@Column(name="PERIODE")
	private String periode;

	@Column(name="ANNEE_UNIVERSITAIRE")
	@JsonIgnore
	String anne_Universitaire;

	@Column(name = "CODE_UE")
	@JsonIgnore
	String code_eu;

	@Column(name = "CODE_EC")
	@JsonIgnore
	String code_ec;

	@Column(name = "CODE_FORMATION")
	@JsonIgnore
	String code_formation;

	//uni-directional many-to-one association to ElementConstitutif
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODE_EC", referencedColumnName="CODE_EC", insertable=false, updatable=false),
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false),
		@JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE", insertable=false, updatable=false)
		})
    @JsonIgnoreProperties(value = { "evaluations" })
    private ElementConstitutif elementConstitutif;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Enseignant enseignant;

	//uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ANNEE_UNIVERSITAIRE", referencedColumnName="ANNEE_UNIVERSITAIRE", insertable=false, updatable=false),
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false)
		})
	private Promotion promotion;

	//bi-directional many-to-one association to UniteEnseignement
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false),
		@JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE", insertable=false, updatable=false)
		})
    @JsonIgnoreProperties(value = { "evaluations" })
    private UniteEnseignement uniteEnseignement;

	@OneToMany(mappedBy = "evaluation")
	@JsonIgnoreProperties(value = "evaluation")
	@OrderBy(value = "idRubriqueEvaluation")
	@JsonIgnore
	private List<RubriqueEvaluation> rubriqueEvaluations;

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

	public VEtatEvaluation getEtat() {
		return this.etat;
	}

	public void setEtat(VEtatEvaluation etat) {
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

	public String getAnne_Universitaire() {
		return anne_Universitaire;
	}

	public void setAnne_Universitaire(String anne_Universitaire) {
		this.anne_Universitaire = anne_Universitaire;
	}

	public String getCode_eu() {
		return code_eu;
	}

	public void setCode_eu(String code_eu) {
		this.code_eu = code_eu;
	}

	public String getCode_ec() {
		return code_ec;
	}

	public void setCode_ec(String code_ec) {
		this.code_ec = code_ec;
	}

	public String getCode_formation() {
		return code_formation;
	}

	public void setCode_formation(String code_formation) {
		this.code_formation = code_formation;
	}

	public ElementConstitutif getElementConstitutif() {
		return this.elementConstitutif;
	}

	public void setElementConstitutif(ElementConstitutif elementConstitutiff) {
		this.elementConstitutif = elementConstitutiff;
		if(elementConstitutiff!=null){
			this.setCode_ec(elementConstitutiff.getId().getCodeEc());
		}
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignantt) {
		this.enseignant = enseignantt;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotionn) {
		this.promotion = promotionn;
		this.setAnne_Universitaire(promotionn.getId().getAnneeUniversitaire());
		this.setCode_formation(promotionn.getId().getCodeFormation());
	}

	public UniteEnseignement getUniteEnseignement() {
		return this.uniteEnseignement;
	}

	public void setUniteEnseignement(UniteEnseignement uniteEnseignementt) {
		this.uniteEnseignement = uniteEnseignementt;
		setCode_eu(uniteEnseignementt.getId().getCodeUe());
	}

	public List<RubriqueEvaluation> getRubriqueEvaluations() {
		return rubriqueEvaluations;
	}

	public void setRubriqueEvaluations(List<RubriqueEvaluation> rubriqueEvaluations) {
		this.rubriqueEvaluations = rubriqueEvaluations;
	}
	public void setRubriqueEvaluation(RubriqueEvaluation rubriqueEvaluation) {
		this.rubriqueEvaluations.add(rubriqueEvaluation);
	}
}