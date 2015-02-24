/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_triangle;

import food_triangle.entities.FoodTriangleUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Jessica
 */
public class FoodTriangleDBManager
{
    public static final String USER_COUNT_QUERY = "SELECT Count(*) FROM FOODTRIANGLEUSER";
    
    private FoodTriangleManager manager;
    
    public FoodTriangleDBManager(FoodTriangleManager initManager)
    {
        manager = initManager;
        reset();
    }
    
     public FoodTriangleUser getUserByUsername(String username) 
    {
        EntityManager em = manager.getEntityManager();
        TypedQuery<FoodTriangleUser> query = em.createNamedQuery("FoodTriangleUser.findByUsername", FoodTriangleUser.class);
        
        query.setParameter("username", username);
        
        List<FoodTriangleUser> foundUsers = query.getResultList();
        
        if (foundUsers.isEmpty())
            return null;
        else
            return foundUsers.get(0);
    }
     
    public int generateNewUserId()
    {
        EntityManager em = manager.getEntityManager();
        Query countQuery = em.createNativeQuery(USER_COUNT_QUERY);
        
        int count = (Integer)countQuery.getResultList().get(0); 

        return count+1;          
    }
    
    public void saveEntity(Object entityToSave)
    {
        EntityManager em = manager.getEntityManager();
        UserTransaction utx = manager.getUserTransaction();
        try
        {
            // START THE SAVE TRANSACTION
            utx.begin();
            
            // MERGE THE OBJECT WITH THE TABLE
            em.merge(entityToSave);
            
            // COMMIT THE TRANSACTION
            utx.commit();
        }
        // ERROR OCCURRED
        catch(NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void reset()
    {
        
    }
}
