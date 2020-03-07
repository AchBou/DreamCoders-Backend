package Demo.model;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(name="ID_QUESTION", insertable=false, updatable=false)
	private long idQuestion;

	private String intitule;

	@Column(name="TYPE")
	private String type;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT", insertable=false, updatable=false)
	private Enseignant enseignantt;

	//uni-directional many-to-one association to Qualificatif
	@ManyToOne
	@JoinColumn(name="ID_QUALIFICATIF", insertable=false, updatable=false)
	private Qualificatif qualificatiff;

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

	public Enseignant getEnseignantt() {
		return this.enseignantt;
	}

	public void setEnseignantt(Enseignant enseignantt) {
		this.enseignantt = enseignantt;
	}

	public Qualificatif getQualificatiff() {
		qualificatiff.setIdQualificatif(2);
		return this.qualificatiff;
	}

	public void setQualificatiff(Qualificatif qualificatiff) {
		this.qualificatiff = qualificatiff;
	}

}