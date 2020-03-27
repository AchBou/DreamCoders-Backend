package Demo.modelPerso;

import java.math.BigDecimal;
import java.util.Date;

public class EvaluationPers {

    private String code_formation;
    private String annee_universitaire;
    private String code_ue;
    private String code_ec;
    private BigDecimal no_evaluantion;
    private String designation;
    private String etat;
    private String periode;
    private Date debut_reponse;
    private Date fin_reponse;

    public String getCode_formation() {
        return code_formation;
    }

    public void setCode_formation(String code_formation) {
        this.code_formation = code_formation;
    }

    public String getAnnee_universitaire() {
        return annee_universitaire;
    }

    public void setAnnee_universitaire(String annee_universitaire) {
        this.annee_universitaire = annee_universitaire;
    }

    public String getCode_ue() {
        return code_ue;
    }

    public void setCode_ue(String code_ue) {
        this.code_ue = code_ue;
    }

    public String getCode_ec() {
        return code_ec;
    }

    public void setCode_ec(String code_ec) {
        this.code_ec = code_ec;
    }

    public BigDecimal getNo_evaluantion() {
        return no_evaluantion;
    }

    public void setNo_evaluantion(BigDecimal no_evaluantion) {
        this.no_evaluantion = no_evaluantion;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Date getDebut_reponse() {
        return debut_reponse;
    }

    public void setDebut_reponse(Date debut_reponse) {
        this.debut_reponse = debut_reponse;
    }

    public Date getFin_reponse() {
        return fin_reponse;
    }

    public void setFin_reponse(Date fin_reponse) {
        this.fin_reponse = fin_reponse;
    }

    @Override
    public String toString() {
        return "EvaluationPers{" +
                "code_formation='" + code_formation + '\'' +
                ", annee_universitaire='" + annee_universitaire + '\'' +
                ", code_ue='" + code_ue + '\'' +
                ", code_ec='" + code_ec + '\'' +
                ", no_evaluantion=" + no_evaluantion +
                ", designation='" + designation + '\'' +
                ", etat='" + etat + '\'' +
                ", periode='" + periode + '\'' +
                ", debut_reponse=" + debut_reponse +
                ", fin_reponse=" + fin_reponse +
                '}';
    }
}
