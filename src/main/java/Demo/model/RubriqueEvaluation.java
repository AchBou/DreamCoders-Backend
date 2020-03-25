package Demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the RUBRIQUE_EVALUATION database table.
 * 
 */
@Entity
@Table(name="RUBRIQUE_EVALUATION")
@NamedQuery(name="RubriqueEvaluation.findAll", query="SELECT r FROM RubriqueEvaluation r")
public class RubriqueEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RUBRIQUE_EVALUATION")
	private long idRubriqueEvaluation;

	private String designation;

	private BigDecimal ordre;

	//uni-directional many-to-one association to Evaluation
	@ManyToOne
	@JoinColumn(name="ID_EVALUATION", insertable=false, updatable=false)
	private Evaluation evaluation;

	//uni-directional many-to-one association to Rubrique
	@ManyToOne
	@JoinColumn(name="ID_RUBRIQUE", insertable=false, updatable=false)
	private Rubrique rubrique;

	@OneToMany(mappedBy = "rubriqueEvaluation")
	@JsonIgnoreProperties(value = "rubriqueEvaluation")
	@OrderBy(value = "idQuestionEvaluation")
	private List<QuestionEvaluation> questionEvaluations;

	public RubriqueEvaluation() {
	}

	public long getIdRubriqueEvaluation() {
		return this.idRubriqueEvaluation;
	}

	public void setIdRubriqueEvaluation(long idRubriqueEvaluation) {
		this.idRubriqueEvaluation = idRubriqueEvaluation;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

	public Evaluation getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Evaluation evaluationn) {
		this.evaluation = evaluationn;
	}

	public Rubrique getRubrique() {
		return this.rubrique;
	}

	public void setRubrique(Rubrique rubriquee) {
		this.rubrique = rubriquee;
	}

	public List<QuestionEvaluation> getQuestionEvaluations() {
		return questionEvaluations;
	}
	public void setQuestionEvaluations(List<QuestionEvaluation> questionEvaluations) {
		this.questionEvaluations = questionEvaluations;
	}
}