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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator1")
	@SequenceGenerator(name="SequenceIdGenerator1", sequenceName = "QUE_SEQ",allocationSize=1)
	@Column(name="ID_QUESTION", insertable=false, updatable=false)
	private Integer idQuestion;

	private String intitule;

	@Column(name="TYPE")
	private String type;
	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT",referencedColumnName = "NO_ENSEIGNANT")
	private Enseignant enseignantt;

	//uni-directional many-to-one association to Qualificatif
	@ManyToOne
	@JoinColumn(name="ID_QUALIFICATIF",referencedColumnName = "ID_QUALIFICATIF")
	private Qualificatif qualificatiff;

	public Question() {
	}
			public Question(String intitule, String type, Enseignant enseignant,Qualificatif qualificatif) {
				super();
				this.intitule = intitule;
				this.type = type;
				this.enseignantt=enseignant;
		this.qualificatiff= qualificatif;
	}
	public Question(int id,String intitule, String type, Enseignant enseignant, Qualificatif qualificatif) {
		super();
		this.idQuestion = id;
		this.intitule = intitule;
		this.type = type;
		this.enseignantt = enseignant;
		this.qualificatiff = qualificatif;
	}

	public Integer getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(Integer idQuestion) {
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
		return this.qualificatiff;
	}

	public void setQualificatiff(Qualificatif qualificatiff) {
		this.qualificatiff = qualificatiff;
	}

}