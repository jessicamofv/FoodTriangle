/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_triangle;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Jessica
 */
@ManagedBean(name="foodTriangleManager")
@SessionScoped
public class FoodTriangleManager implements Serializable
{
    private FoodTriangleUserManager userManager;
    private FoodTriangleDBManager dBManager;
    private FoodTriangleScreenManager screenManager;
    
    @PersistenceContext(unitName="FoodTrianglePU")
    EntityManager em;
    
    @Resource
    private UserTransaction userTransaction;
    
    public FoodTriangleManager()
    {
        userManager = new FoodTriangleUserManager(this);
        dBManager = new FoodTriangleDBManager(this);
        screenManager = new FoodTriangleScreenManager(this);
        reset();
    }
    
    public void reset()
    {
        userManager.reset();
        dBManager.reset();
        screenManager.reset();
    }
    
    public EntityManager getEntityManager() { return em; }
    public FoodTriangleUserManager getUserManager() { return userManager; }
    public FoodTriangleDBManager getDBManager() { return dBManager; }
    public FoodTriangleScreenManager getScreenManager() { return screenManager; }
    public UserTransaction getUserTransaction() { return userTransaction; }
    
    public void setUserManager(FoodTriangleUserManager userManager)
    {   this.userManager = userManager;     }
    public void setDBManager(FoodTriangleDBManager dBManager)
    {   this.dBManager = dBManager;     }
    public void setScreenManager(FoodTriangleScreenManager screenManager)
    {   this.screenManager = screenManager;     }
}
