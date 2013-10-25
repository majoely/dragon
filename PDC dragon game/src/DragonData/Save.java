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
@Table(name = "SAVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Save.findAll", query = "SELECT s FROM Save s"),
    @NamedQuery(name = "Save.findById", query = "SELECT s FROM Save s WHERE s.id = :id"),
    @NamedQuery(name = "Save.findByPname", query = "SELECT s FROM Save s WHERE s.pname = :pname"),
    @NamedQuery(name = "Save.findByDname", query = "SELECT s FROM Save s WHERE s.dname = :dname"),
    @NamedQuery(name = "Save.findByExp", query = "SELECT s FROM Save s WHERE s.exp = :exp"),
    @NamedQuery(name = "Save.findByLevel", query = "SELECT s FROM Save s WHERE s.level = :level"),
    @NamedQuery(name = "Save.findByMhealth", query = "SELECT s FROM Save s WHERE s.mhealth = :mhealth"),
    @NamedQuery(name = "Save.findByHealth", query = "SELECT s FROM Save s WHERE s.health = :health"),
    @NamedQuery(name = "Save.findByAttack", query = "SELECT s FROM Save s WHERE s.attack = :attack"),
    @NamedQuery(name = "Save.findByDefense", query = "SELECT s FROM Save s WHERE s.defense = :defense"),
    @NamedQuery(name = "Save.findByHunger", query = "SELECT s FROM Save s WHERE s.hunger = :hunger"),
    @NamedQuery(name = "Save.findByQuest", query = "SELECT s FROM Save s WHERE s.quest = :quest"),
    @NamedQuery(name = "Save.findByGold", query = "SELECT s FROM Save s WHERE s.gold = :gold"),
    @NamedQuery(name = "Save.findByItems", query = "SELECT s FROM Save s WHERE s.items = :items")})
public class Save implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PNAME")
    private String pname;
    @Column(name = "DNAME")
    private String dname;
    @Column(name = "EXP")
    private Integer exp;
    @Column(name = "LEVEL")
    private Integer level;
    @Column(name = "MHEALTH")
    private Integer mhealth;
    @Column(name = "HEALTH")
    private Integer health;
    @Column(name = "ATTACK")
    private Integer attack;
    @Column(name = "DEFENSE")
    private Integer defense;
    @Column(name = "HUNGER")
    private Integer hunger;
    @Column(name = "QUEST")
    private Integer quest;
    @Column(name = "GOLD")
    private Integer gold;
    @Column(name = "ITEMS")
    private String items;

    public Save() {
    }

    public Save(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMhealth() {
        return mhealth;
    }

    public void setMhealth(Integer mhealth) {
        this.mhealth = mhealth;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getHunger() {
        return hunger;
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
    }

    public Integer getQuest() {
        return quest;
    }

    public void setQuest(Integer quest) {
        this.quest = quest;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
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
        if (!(object instanceof Save)) {
            return false;
        }
        Save other = (Save) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DragonData.Save[ id=" + id + " ]";
    }
    
}
