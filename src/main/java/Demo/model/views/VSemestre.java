package Demo.model.views;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "V_SEMESTRE", schema = "ADMIN")
public class VSemestre {
    private String code;
    private String abreviation;
    private String signification;

    @Basic
    @Id
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "ABREVIATION")
    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    @Basic
    @Column(name = "SIGNIFICATION")
    public String getSignification() {
        return signification;
    }

    public void setSignification(String signification) {
        this.signification = signification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VSemestre vSemestre = (VSemestre) o;
        return Objects.equals(code, vSemestre.code) &&
                Objects.equals(abreviation, vSemestre.abreviation) &&
                Objects.equals(signification, vSemestre.signification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, abreviation, signification);
    }
}
