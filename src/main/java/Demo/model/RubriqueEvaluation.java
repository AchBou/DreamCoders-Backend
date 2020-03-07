package Demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


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
	private Evaluation evaluationn;

	//uni-directional many-to-one association to Rubrique
	@ManyToOne
	@JoinColumn(name="ID_RUBRIQUE", insertable=false, updatable=false)
	private Rubrique rubriquee;

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

	public Evaluation getEvaluationn() {
		return this.evaluationn;
	}

	public void setEvaluationn(Evaluation evaluationn) {
		this.evaluationn = evaluationn;
	}

	public Rubrique getRubriquee() {
		return this.rubriquee;
	}

	public void setRubriquee(Rubrique rubriquee) {
		this.rubriquee = rubriquee;
	}

}