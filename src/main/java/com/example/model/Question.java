package com.example.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the QUESTION database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_QUESTION")
	private long idQuestion;

	private String intitule;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignant;

	//bi-directional many-to-one association to Qualificatif
	@ManyToOne
	@JoinColumn(name="ID_QUALIFICATIF")
	private Qualificatif qualificatif;

	//bi-directional many-to-one association to QuestionEvaluation
	@OneToMany(mappedBy="question")
	private List<QuestionEvaluation> questionEvaluations;

	//bi-directional many-to-one association to RubriqueQuestion
	@OneToMany(mappedBy="question")
	private List<RubriqueQuestion> rubriqueQuestions;

	public Question() {
	}

	public long getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Qualificatif getQualificatif() {
		return this.qualificatif;
	}

	public void setQualificatif(Qualificatif qualificatif) {
		this.qualificatif = qualificatif;
	}

	public List<QuestionEvaluation> getQuestionEvaluations() {
		return this.questionEvaluations;
	}

	public void setQuestionEvaluations(List<QuestionEvaluation> questionEvaluations) {
		this.questionEvaluations = questionEvaluations;
	}

	public QuestionEvaluation addQuestionEvaluation(QuestionEvaluation questionEvaluation) {
		getQuestionEvaluations().add(questionEvaluation);
		questionEvaluation.setQuestion(this);

		return questionEvaluation;
	}

	public QuestionEvaluation removeQuestionEvaluation(QuestionEvaluation questionEvaluation) {
		getQuestionEvaluations().remove(questionEvaluation);
		questionEvaluation.setQuestion(null);

		return questionEvaluation;
	}

	public List<RubriqueQuestion> getRubriqueQuestions() {
		return this.rubriqueQuestions;
	}

	public void setRubriqueQuestions(List<RubriqueQuestion> rubriqueQuestions) {
		this.rubriqueQuestions = rubriqueQuestions;
	}

	public RubriqueQuestion addRubriqueQuestion(RubriqueQuestion rubriqueQuestion) {
		getRubriqueQuestions().add(rubriqueQuestion);
		rubriqueQuestion.setQuestion(this);

		return rubriqueQuestion;
	}

	public RubriqueQuestion removeRubriqueQuestion(RubriqueQuestion rubriqueQuestion) {
		getRubriqueQuestions().remove(rubriqueQuestion);
		rubriqueQuestion.setQuestion(null);

		return rubriqueQuestion;
	}

}