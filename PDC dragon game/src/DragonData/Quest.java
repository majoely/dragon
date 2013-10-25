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
@Table(name = "QUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quest.findAll", query = "SELECT q FROM Quest q"),
    @NamedQuery(name = "Quest.findById", query = "SELECT q FROM Quest q WHERE q.id = :id"),
    @NamedQuery(name = "Quest.findByName", query = "SELECT q FROM Quest q WHERE q.name = :name"),
    @NamedQuery(name = "Quest.findByDescript", query = "SELECT q FROM Quest q WHERE q.descript = :descript"),
    @NamedQuery(name = "Quest.findByBadguy", query = "SELECT q FROM Quest q WHERE q.badguy = :badguy")})
public class Quest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPT")
    private String descript;
    @Column(name = "BADGUY")
    private String badguy;

    public Quest() {
    }

    public Quest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getBadguy() {
        return badguy;
    }

    public void setBadguy(String badguy) {
        this.badguy = badguy;
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
        if (!(object instanceof Quest)) {
            return false;
        }
        Quest other = (Quest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DragonData.Quest[ id=" + id + " ]";
    }
    
}
