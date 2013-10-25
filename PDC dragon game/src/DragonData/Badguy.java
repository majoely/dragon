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
@Table(name = "BADGUY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Badguy.findAll", query = "SELECT b FROM Badguy b"),
    @NamedQuery(name = "Badguy.findById", query = "SELECT b FROM Badguy b WHERE b.id = :id"),
    @NamedQuery(name = "Badguy.findByName", query = "SELECT b FROM Badguy b WHERE b.name = :name"),
    @NamedQuery(name = "Badguy.findByGold", query = "SELECT b FROM Badguy b WHERE b.gold = :gold"),
    @NamedQuery(name = "Badguy.findByExp", query = "SELECT b FROM Badguy b WHERE b.exp = :exp"),
    @NamedQuery(name = "Badguy.findByItem", query = "SELECT b FROM Badguy b WHERE b.item = :item"),
    @NamedQuery(name = "Badguy.findByHealth", query = "SELECT b FROM Badguy b WHERE b.health = :health")})
public class Badguy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "GOLD")
    private Integer gold;
    @Column(name = "EXP")
    private Integer exp;
    @Column(name = "ITEM")
    private String item;
    @Column(name = "HEALTH")
    private Integer health;

    public Badguy() {
    }

    public Badguy(Integer id) {
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

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
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
        if (!(object instanceof Badguy)) {
            return false;
        }
        Badguy other = (Badguy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DragonData.Badguy[ id=" + id + " ]";
    }
    
}
