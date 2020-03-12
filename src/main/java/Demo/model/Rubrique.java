package Demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RUBRIQUE database table.
 * 
 */
@Entity
@NamedQuery(name="Rubrique.findAll", query="SELECT r FROM Rubrique r")
public class Rubrique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "RUB_SEQ",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SequenceIdGenerator")
	@Column(name="ID_RUBRIQUE")
	private Integer idRubrique;

	private String designation;

	private BigDecimal ordre;

	@Column(name="TYPE")
	private String type;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignantt;

	public Rubrique() {
	}
	public Rubrique(String type, String designation, Enseignant enseignant,BigDecimal ordre) {
		super();
		this.type = type;
		this.enseignantt = enseignant;
		this.designation = designation;
		this.ordre = ordre;
	}
	public Rubrique(int id,String type, String designation, Enseignant enseignant,BigDecimal ordre ) {
		super();
		this.idRubrique = id;
		this.type = type;
		this.enseignantt = enseignant;
		this.designation = designation;
		this.ordre = ordre;
	}

	public Integer getIdRubrique() {
		return this.idRubrique;
	}

	public void setIdRubrique(Integer idRubrique) {
		this.idRubrique = idRubrique;
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

}