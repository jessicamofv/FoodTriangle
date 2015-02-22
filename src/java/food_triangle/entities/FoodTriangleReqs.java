/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_triangle.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "FOODTRIANGLEREQS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodTriangleReqs.findAll", query = "SELECT f FROM FoodTriangleReqs f"),
    @NamedQuery(name = "FoodTriangleReqs.findById", query = "SELECT f FROM FoodTriangleReqs f WHERE f.id = :id"),
    @NamedQuery(name = "FoodTriangleReqs.findBySex", query = "SELECT f FROM FoodTriangleReqs f WHERE f.sex = :sex"),
    @NamedQuery(name = "FoodTriangleReqs.findByMinAge", query = "SELECT f FROM FoodTriangleReqs f WHERE f.minAge = :minAge"),
    @NamedQuery(name = "FoodTriangleReqs.findByMaxAge", query = "SELECT f FROM FoodTriangleReqs f WHERE f.maxAge = :maxAge"),
    @NamedQuery(name = "FoodTriangleReqs.findByFruitsReq", query = "SELECT f FROM FoodTriangleReqs f WHERE f.fruitsReq = :fruitsReq"),
    @NamedQuery(name = "FoodTriangleReqs.findByVegetablesReq", query = "SELECT f FROM FoodTriangleReqs f WHERE f.vegetablesReq = :vegetablesReq"),
    @NamedQuery(name = "FoodTriangleReqs.findByGrainsReq", query = "SELECT f FROM FoodTriangleReqs f WHERE f.grainsReq = :grainsReq"),
    @NamedQuery(name = "FoodTriangleReqs.findByProteinReq", query = "SELECT f FROM FoodTriangleReqs f WHERE f.proteinReq = :proteinReq"),
    @NamedQuery(name = "FoodTriangleReqs.findByDairyReq", query = "SELECT f FROM FoodTriangleReqs f WHERE f.dairyReq = :dairyReq"),
    @NamedQuery(name = "FoodTriangleReqs.findByOilsReq", query = "SELECT f FROM FoodTriangleReqs f WHERE f.oilsReq = :oilsReq")})
public class FoodTriangleReqs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SEX")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINAGE")
    private int minAge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MAXAGE")
    private int maxAge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRUITSREQ")
    private int fruitsReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEGETABLESREQ")
    private int vegetablesReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRAINSREQ")
    private int grainsReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROTEINREQ")
    private int proteinReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAIRYREQ")
    private int dairyReq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OILSREQ")
    private int oilsReq;

    public FoodTriangleReqs() {
    }

    public FoodTriangleReqs(Integer id) {
        this.id = id;
    }

    public FoodTriangleReqs(Integer id, String sex, int minAge, int maxAge, int fruitsReq, int vegetablesReq, int grainsReq, int proteinReq, int dairyReq, int oilsReq) {
        this.id = id;
        this.sex = sex;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.fruitsReq = fruitsReq;
        this.vegetablesReq = vegetablesReq;
        this.grainsReq = grainsReq;
        this.proteinReq = proteinReq;
        this.dairyReq = dairyReq;
        this.oilsReq = oilsReq;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getFruitsReq() {
        return fruitsReq;
    }

    public void setFruitsReq(int fruitsReq) {
        this.fruitsReq = fruitsReq;
    }

    public int getVegetablesReq() {
        return vegetablesReq;
    }

    public void setVegetablesReq(int vegetablesReq) {
        this.vegetablesReq = vegetablesReq;
    }

    public int getGrainsReq() {
        return grainsReq;
    }

    public void setGrainsReq(int grainsReq) {
        this.grainsReq = grainsReq;
    }

    public int getProteinReq() {
        return proteinReq;
    }

    public void setProteinReq(int proteinReq) {
        this.proteinReq = proteinReq;
    }

    public int getDairyReq() {
        return dairyReq;
    }

    public void setDairyReq(int dairyReq) {
        this.dairyReq = dairyReq;
    }

    public int getOilsReq() {
        return oilsReq;
    }

    public void setOilsReq(int oilsReq) {
        this.oilsReq = oilsReq;
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
        if (!(object instanceof FoodTriangleReqs)) {
            return false;
        }
        FoodTriangleReqs other = (FoodTriangleReqs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "food_triangle.entities.FoodTriangleReqs[ id=" + id + " ]";
    }
    
}