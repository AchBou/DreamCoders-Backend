package Demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RUBRIQUE_QUESTION database table.
 * 
 */
@Entity
@Table(name="RUBRIQUE_QUESTION")
@NamedQuery(name="RubriqueQuestion.findAll", query="SELECT r FROM RubriqueQuestion r")
public class RubriqueQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RubriqueQuestionPK id;

	private BigDecimal ordre;

	//uni-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="ID_QUESTION", insertable=false, updatable=false)
	private Question questionn;

	//uni-directional many-to-one association to Rubrique
	@ManyToOne
	@JoinColumn(name="ID_RUBRIQUE", insertable=false, updatable=false)
	private Rubrique rubriquee;

	public RubriqueQuestion() {
	}

	public RubriqueQuestionPK getId() {
		return this.id;
	}

	public void setId(RubriqueQuestionPK id) {
		this.id = id;
	}

	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

	public Question getQuestionn() {
		return this.questionn;
	}

	public void setQuestionn(Question questionn) {
		this.questionn = questionn;
	}

	public Rubrique getRubriquee() {
		return this.rubriquee;
	}

	public void setRubriquee(Rubrique rubriquee) {
		this.rubriquee = rubriquee;
	}

}