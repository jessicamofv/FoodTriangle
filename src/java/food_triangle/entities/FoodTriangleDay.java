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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FOODTRIANGLEDAY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodTriangleDay.findAll", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId"),
    @NamedQuery(name = "FoodTriangleDay.findById", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.id = :id"),
    @NamedQuery(name = "FoodTriangleDay.findByDay", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.day = :day"),
    @NamedQuery(name = "FoodTriangleDay.findByFruitsAmount", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.fruitsAmount = :fruitsAmount"),
    @NamedQuery(name = "FoodTriangleDay.findByVegetablesAmount", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.vegetablesAmount = :vegetablesAmount"),
    @NamedQuery(name = "FoodTriangleDay.findByGrainsAmount", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.grainsAmount = :grainsAmount"),
    @NamedQuery(name = "FoodTriangleDay.findByProteinAmount", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.proteinAmount = :proteinAmount"),
    @NamedQuery(name = "FoodTriangleDay.findByDairyAmount", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.dairyAmount = :dairyAmount"),
    @NamedQuery(name = "FoodTriangleDay.findByOilsAmount", query = "SELECT f FROM FoodTriangleDay f WHERE f.userId.id = :userId AND f.oilsAmount = :oilsAmount")})
public class FoodTriangleDay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DAY")
    private String day;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FRUITSAMOUNT")
    private int fruitsAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VEGETABLESAMOUNT")
    private int vegetablesAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRAINSAMOUNT")
    private int grainsAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROTEINAMOUNT")
    private int proteinAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DAIRYAMOUNT")
    private int dairyAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OILSAMOUNT")
    private int oilsAmount;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FoodTriangleUser userId;

    public FoodTriangleDay() {
    }

    public FoodTriangleDay(Integer id) {
        this.id = id;
    }

    public FoodTriangleDay(Integer id, String day, int fruitsAmount, int vegetablesAmount, int grainsAmount, int proteinAmount, int dairyAmount, int oilsAmount) {
        this.id = id;
        this.day = day;
        this.fruitsAmount = fruitsAmount;
        this.vegetablesAmount = vegetablesAmount;
        this.grainsAmount = grainsAmount;
        this.proteinAmount = proteinAmount;
        this.dairyAmount = dairyAmount;
        this.oilsAmount = oilsAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getFruitsAmount() {
        return fruitsAmount;
    }

    public void setFruitsAmount(int fruitsAmount) {
        this.fruitsAmount = fruitsAmount;
    }

    public int getVegetablesAmount() {
        return vegetablesAmount;
    }

    public void setVegetablesAmount(int vegetablesAmount) {
        this.vegetablesAmount = vegetablesAmount;
    }

    public int getGrainsAmount() {
        return grainsAmount;
    }

    public void setGrainsAmount(int grainsAmount) {
        this.grainsAmount = grainsAmount;
    }

    public int getProteinAmount() {
        return proteinAmount;
    }

    public void setProteinAmount(int proteinAmount) {
        this.proteinAmount = proteinAmount;
    }

    public int getDairyAmount() {
        return dairyAmount;
    }

    public void setDairyAmount(int dairyAmount) {
        this.dairyAmount = dairyAmount;
    }

    public int getOilsAmount() {
        return oilsAmount;
    }

    public void setOilsAmount(int oilsAmount) {
        this.oilsAmount = oilsAmount;
    }

    public FoodTriangleUser getUserId() {
        return userId;
    }

    public void setUserId(FoodTriangleUser userId) {
        this.userId = userId;
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
        if (!(object instanceof FoodTriangleDay)) {
            return false;
        }
        FoodTriangleDay other = (FoodTriangleDay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "food_triangle.entities.FoodTriangleDay[ id=" + id + " ]";
    }
    
}
