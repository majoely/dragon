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
@Table(name = "INTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intro.findAll", query = "SELECT i FROM Intro i"),
    @NamedQuery(name = "Intro.findById", query = "SELECT i FROM Intro i WHERE i.id = :id"),
    @NamedQuery(name = "Intro.findByIntro", query = "SELECT i FROM Intro i WHERE i.intro = :intro")})
public class Intro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "INTRO")
    private String intro;

    public Intro() {
    }

    public Intro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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
        if (!(object instanceof Intro)) {
            return false;
        }
        Intro other = (Intro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DragonData.Intro[ id=" + id + " ]";
    }
    
}
