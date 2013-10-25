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
@Table(name = "TUTORIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutorial.findAll", query = "SELECT t FROM Tutorial t"),
    @NamedQuery(name = "Tutorial.findById", query = "SELECT t FROM Tutorial t WHERE t.id = :id"),
    @NamedQuery(name = "Tutorial.findByTut", query = "SELECT t FROM Tutorial t WHERE t.tut = :tut")})
public class Tutorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TUT")
    private String tut;

    public Tutorial() {
    }

    public Tutorial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTut() {
        return tut;
    }

    public void setTut(String tut) {
        this.tut = tut;
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
        if (!(object instanceof Tutorial)) {
            return false;
        }
        Tutorial other = (Tutorial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DragonData.Tutorial[ id=" + id + " ]";
    }
    
}
