/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_triangle;

import food_triangle.entities.FoodTriangleUser;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jessica
 */
public class FoodTriangleUserManager
{
    /**
     * <p>The key for the session scoped attribute holding the
     * appropriate <code>FoodTriangleUser</code> instance.</p>
     */
    public static final String USER_SESSION_KEY = "user";
    
    private FoodTriangleManager manager;
    
    public FoodTriangleUserManager(FoodTriangleManager initManager)
    {
        manager = initManager;
        reset();
    }
    
    private String username;
    private String password;
    private String passwordc;
    private String fname;
    private String lname;
    
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
    
    public String getPasswordc() {
        return passwordc;
    }
    
    public void setPasswordc(String passwordc) {
        this.passwordc = passwordc;
    }
    
    public String getFname() {
        return fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getLname() {
        return lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    
    /**
     * <p>Validates the user.  If the user doesn't exist or the password
     * is incorrect, the appropriate message is added to the current
     * <code>FacesContext</code>.  If the user successfully authenticates,
     * navigate them to the page referenced by the outcome <code>home</code>.
     * </p>
     *
     * @return <code>home</code> if the user authenticates, otherwise
     *  returns <code>null</code>
     */
    public String validateUser() {   
        FacesContext context = FacesContext.getCurrentInstance();
        FoodTriangleUser user = manager.getDBManager().getUserByUsername(username);
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Login failed!",
                                           "The password specified is not correct.");
                context.addMessage(null, message);
                return null;
            }
            
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
            /* CHANGE THIS
            manager.getAlbumManager().setCurrentUser(user); */
            return "home";
        } else {           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login failed!",
                    "Username '" + username + "' does not exist.");
            context.addMessage(null, message);
            return null;
        }
    }
    
    /**
     * <p>Creates a new <code>FoodTriangleUser</code>.  If the specified user name exists
     * or an error occurs when persisting the FoodTriangleUser instance, enqueue a message
     * detailing the problem to the <code>FacesContext</code>.  If the 
     * user is created, move the user back to the login view.</p>
     *
     * @return <code>index</code> if the user is created, otherwise
     *  returns <code>null</code>
     */
    public String createUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        FoodTriangleUser user = manager.getDBManager().getUserByUsername(username);
        if (user == null) {
            if (!isAlphaNumeric(username))
            {
                FacesMessage message = new FacesMessage("Useername may have alphanumeric characters only.  Please try again.");
                context.addMessage(null, message);
                return null;
            }
            if (!isAlphaNumeric(password))
            {
                FacesMessage message = new FacesMessage("Password may have alphanumeric characters only.  Please try again.");
                context.addMessage(null, message);
                return null;
            }
            if (!password.equals(passwordc)) {
                FacesMessage message = new FacesMessage("The specified passwords do not match.  Please try again.");
                context.addMessage(null, message);
                return null;
            }
            user = new FoodTriangleUser();
            int userId = manager.getDBManager().generateNewUserId();
            user.setId(userId);
            user.setFirstName(fname);
            user.setLastName(lname);
            user.setUsername(username);
            user.setPassword(password);
            manager.getDBManager().saveEntity(user);
            return "index";
        } else {           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                    "Username '" + username + "' already exists!  ",
                                                    "Please choose a different username.");
            context.addMessage(null, message);
            return null;
        }        
    }
    
    /**
     * <p>When invoked, it will invalidate the user's session
     * and move them to the login view.</p>
     *
     * @return <code>index</code>
     */
    public String logOut() {
        manager.reset();
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index";
        
    }
    
    private boolean isAlphaNumeric(String testText)
    {
        for (int i = 0; i < testText.length(); i++)
        {
            char c = testText.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }
    
    public void reset()
    {
        username = "";
        password = "";
        passwordc = "";
        fname = "";
        lname = "";
    }
}
