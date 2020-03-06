package com.example.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the QUESTION_EVALUATION database table.
 * 
 */
@Entity
@Table(name="QUESTION_EVALUATION")
@NamedQuery(name="QuestionEvaluation.findAll", query="SELECT q FROM QuestionEvaluation q")
public class QuestionEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_QUESTION_EVALUATION", insertable=false, updatable=false)
	private long idQuestionEvaluation;

	private String intitule;

	private BigDecimal ordre;

	//uni-directional many-to-one association to Qualificatif
	@ManyToOne
	@JoinColumn(name="ID_QUALIFICATIF", insertable=false, updatable=false)
	private Qualificatif qualificatiff;

	//uni-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="ID_QUESTION", insertable=false, updatable=false)
	private Question questionn;

	//uni-directional many-to-one association to RubriqueEvaluation
	@ManyToOne
	@JoinColumn(name="ID_RUBRIQUE_EVALUATION", insertable=false, updatable=false)
	private RubriqueEvaluation rubriqueEvaluationn;

	public QuestionEvaluation() {
	}

	public long getIdQuestionEvaluation() {
		return this.idQuestionEvaluation;
	}

	public void setIdQuestionEvaluation(long idQuestionEvaluation) {
		this.idQuestionEvaluation = idQuestionEvaluation;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

	public Qualificatif getQualificatiff() {
		return this.qualificatiff;
	}

	public void setQualificatiff(Qualificatif qualificatiff) {
		this.qualificatiff = qualificatiff;
	}

	public Question getQuestionn() {
		return this.questionn;
	}

	public void setQuestionn(Question questionn) {
		this.questionn = questionn;
	}

	public RubriqueEvaluation getRubriqueEvaluationn() {
		return this.rubriqueEvaluationn;
	}

	public void setRubriqueEvaluationn(RubriqueEvaluation rubriqueEvaluationn) {
		this.rubriqueEvaluationn = rubriqueEvaluationn;
	}

}