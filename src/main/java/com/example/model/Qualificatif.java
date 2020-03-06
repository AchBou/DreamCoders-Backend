package com.example.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the QUALIFICATIF database table.
 * 
 */
@Entity
@NamedQuery(name="Qualificatif.findAll", query="SELECT q FROM Qualificatif q")
public class Qualificatif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_QUALIFICATIF")
	private long idQualificatif;

	private String maximal;

	private String minimal;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="qualificatif")
	private List<Question> questions;

	//bi-directional many-to-one association to QuestionEvaluation
	@OneToMany(mappedBy="qualificatif")
	private List<QuestionEvaluation> questionEvaluations;

	public Qualificatif() {
	}

	public long getIdQualificatif() {
		return this.idQualificatif;
	}

	public void setIdQualificatif(long idQualificatif) {
		this.idQualificatif = idQualificatif;
	}

	public String getMaximal() {
		return this.maximal;
	}

	public void setMaximal(String maximal) {
		this.maximal = maximal;
	}

	public String getMinimal() {
		return this.minimal;
	}

	public void setMinimal(String minimal) {
		this.minimal = minimal;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setQualificatif(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setQualificatif(null);

		return question;
	}

	public List<QuestionEvaluation> getQuestionEvaluations() {
		return this.questionEvaluations;
	}

	public void setQuestionEvaluations(List<QuestionEvaluation> questionEvaluations) {
		this.questionEvaluations = questionEvaluations;
	}

	public QuestionEvaluation addQuestionEvaluation(QuestionEvaluation questionEvaluation) {
		getQuestionEvaluations().add(questionEvaluation);
		questionEvaluation.setQualificatif(this);

		return questionEvaluation;
	}

	public QuestionEvaluation removeQuestionEvaluation(QuestionEvaluation questionEvaluation) {
		getQuestionEvaluations().remove(questionEvaluation);
		questionEvaluation.setQualificatif(null);

		return questionEvaluation;
	}

}