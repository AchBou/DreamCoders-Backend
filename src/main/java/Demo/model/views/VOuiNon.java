package Demo.model.views;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "V_OUI_NON", schema = "ADMIN")
public class VOuiNon {
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
        VOuiNon vOuiNon = (VOuiNon) o;
        return Objects.equals(code, vOuiNon.code) &&
                Objects.equals(abreviation, vOuiNon.abreviation) &&
                Objects.equals(signification, vOuiNon.signification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, abreviation, signification);
    }
}
