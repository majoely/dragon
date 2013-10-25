/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DragonData;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Curtd
 */
@Entity
@Table(name = "GHELP2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ghelp2.findAll", query = "SELECT g FROM Ghelp2 g"),
    @NamedQuery(name = "Ghelp2.findById", query = "SELECT g FROM Ghelp2 g WHERE g.id = :id"),
    @NamedQuery(name = "Ghelp2.findByTutorial", query = "SELECT g FROM Ghelp2 g WHERE g.tutorial = :tutorial")})
public class Ghelp2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TUTORIAL")
    private String tutorial;

    public Ghelp2() {
    }

    public Ghelp2(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ghelp2)) {
            return false;
        }
        Ghelp2 other = (Ghelp2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DragonData.Ghelp2[ id=" + id + " ]";
    }
    
}
