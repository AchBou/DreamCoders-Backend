package Demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

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
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SequenceIdGenerator1")
	@SequenceGenerator(name="SequenceIdGenerator1", sequenceName = "REV_SEQ",allocationSize=1)
	@Column(name="ID_RUBRIQUE_EVALUATION")
	private long idRubriqueEvaluation;

	private String designation;

	@Nullable
	private BigDecimal ordre;

	//uni-directional many-to-one association to Evaluation
	@ManyToOne
	@JoinColumn(name="ID_EVALUATION")
	@JsonIgnore
	private Evaluation evaluation;

	//uni-directional many-to-one association to Rubrique
	@ManyToOne
	@JoinColumn(name="ID_RUBRIQUE")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Rubrique rubrique;

	@OneToMany(mappedBy = "rubriqueEvaluation")
	@JsonIgnoreProperties(value = "rubriqueEvaluation")
	private List<QuestionEvaluation> questionEvaluations;

	public RubriqueEvaluation() {
	}
	public RubriqueEvaluation(Evaluation evaluation, Rubrique rubrique) {
		this.evaluation = evaluation;
		this.rubrique = rubrique;
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

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
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

	public RubriqueEvaluation(String designation, BigDecimal ordre, Evaluation evaluation, Rubrique rubrique) {
		this.designation = designation;
		this.ordre = ordre;
		this.evaluation = evaluation;
		this.rubrique = rubrique;
	}
}