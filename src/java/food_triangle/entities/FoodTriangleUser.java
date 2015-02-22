/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_triangle.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "FOODTRIANGLEUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodTriangleUser.findAll", query = "SELECT f FROM FoodTriangleUser f"),
    @NamedQuery(name = "FoodTriangleUser.findById", query = "SELECT f FROM FoodTriangleUser f WHERE f.id = :id"),
    @NamedQuery(name = "FoodTriangleUser.findByFirstName", query = "SELECT f FROM FoodTriangleUser f WHERE f.firstName = :firstName"),
    @NamedQuery(name = "FoodTriangleUser.findByLastName", query = "SELECT f FROM FoodTriangleUser f WHERE f.lastName = :lastName"),
    @NamedQuery(name = "FoodTriangleUser.findBySex", query = "SELECT f FROM FoodTriangleUser f WHERE f.sex = :sex"),
    @NamedQuery(name = "FoodTriangleUser.findByBirthdate", query = "SELECT f FROM FoodTriangleUser f WHERE f.birthdate = :birthdate"),
    @NamedQuery(name = "FoodTriangleUser.findByAge", query = "SELECT f FROM FoodTriangleUser f WHERE f.age = :age"),
    @NamedQuery(name = "FoodTriangleUser.findByUsername", query = "SELECT f FROM FoodTriangleUser f WHERE f.username = :username"),
    @NamedQuery(name = "FoodTriangleUser.findByPassword", query = "SELECT f FROM FoodTriangleUser f WHERE f.password = :password")})
public class FoodTriangleUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LASTNAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "SEX")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "BIRTHDATE")
    private String birthdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE")
    private int age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<FoodTriangleDay> foodTriangleDayCollection;

    public FoodTriangleUser() {
    }

    public FoodTriangleUser(Integer id) {
        this.id = id;
    }

    public FoodTriangleUser(Integer id, String firstName, String lastName, String sex, String birthdate, int age, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<FoodTriangleDay> getFoodTriangleDayCollection() {
        return foodTriangleDayCollection;
    }

    public void setFoodTriangleDayCollection(Collection<FoodTriangleDay> foodTriangleDayCollection) {
        this.foodTriangleDayCollection = foodTriangleDayCollection;
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
        if (!(object instanceof FoodTriangleUser)) {
            return false;
        }
        FoodTriangleUser other = (FoodTriangleUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "food_triangle.entities.FoodTriangleUser[ id=" + id + " ]";
    }
    
}