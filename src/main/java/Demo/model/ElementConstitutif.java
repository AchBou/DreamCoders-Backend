package Demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ELEMENT_CONSTITUTIF database table.
 * 
 */
@Entity
@Table(name="ELEMENT_CONSTITUTIF")
@NamedQuery(name="ElementConstitutif.findAll", query="SELECT e FROM ElementConstitutif e")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ElementConstitutif implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ElementConstitutifPK id;

	private String description;

	private String designation;

	@Column(name="NBH_CM")
	private BigDecimal nbhCm;

	@Column(name="NBH_TD")
	private BigDecimal nbhTd;

	@Column(name="NBH_TP")
	private BigDecimal nbhTp;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT", insertable=false, updatable=false)
	@JsonIgnore
	private Enseignant enseignantt;

	//uni-directional many-to-one association to UniteEnseignement
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CODE_FORMATION", referencedColumnName="CODE_FORMATION", insertable=false, updatable=false),
		@JoinColumn(name="CODE_UE", referencedColumnName="CODE_UE", insertable=false, updatable=false)
		})
	@JsonIgnore
	private UniteEnseignement uniteEnseignementt;

	public ElementConstitutif() {
	}

	public ElementConstitutifPK getId() {
		return this.id;
	}

	public void setId(ElementConstitutifPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getNbhCm() {
		return this.nbhCm;
	}

	public void setNbhCm(BigDecimal nbhCm) {
		this.nbhCm = nbhCm;
	}

	public BigDecimal getNbhTd() {
		return this.nbhTd;
	}

	public void setNbhTd(BigDecimal nbhTd) {
		this.nbhTd = nbhTd;
	}

	public BigDecimal getNbhTp() {
		return this.nbhTp;
	}

	public void setNbhTp(BigDecimal nbhTp) {
		this.nbhTp = nbhTp;
	}

	public Enseignant getEnseignantt() {
		return this.enseignantt;
	}

	public void setEnseignantt(Enseignant enseignantt) {
		this.enseignantt = enseignantt;
	}

	public UniteEnseignement getUniteEnseignementt() {
		return this.uniteEnseignementt;
	}

	public void setUniteEnseignementt(UniteEnseignement uniteEnseignementt) {
		this.uniteEnseignementt = uniteEnseignementt;
	}

}