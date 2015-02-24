/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_triangle;

/**
 *
 * @author Jessica
 */
public class FoodTriangleScreenManager
{
    public static final int HOME_SCREEN = 0;
    private int homeScreen = HOME_SCREEN;
    public static final int DAILY_PROGRESS_SCREEN = 1;
    private int dailyProgressScreen = DAILY_PROGRESS_SCREEN;

    private FoodTriangleManager manager;
    private int currentScreen;
    private String homeTabClass;
    private String dailyProgressTabClass;
    
    public FoodTriangleScreenManager(FoodTriangleManager initManager)
    {
        manager = initManager;
        reset();
    }
    
    public int getHomeScreen() { return homeScreen; }
    public int getDailyProgressScreen() { return dailyProgressScreen; }
    public String getHomeTabClass() { return homeTabClass; }
    public String getDailyProgressTabClass() { return dailyProgressTabClass; }
    
    public boolean isViewingHomeScreen() { return currentScreen == homeScreen; }
    public boolean isViewingDailyProgressScreen() { return currentScreen == dailyProgressScreen; }
    
    public void reset()
    {
        currentScreen = homeScreen;
        homeTabClass = "active";
        dailyProgressTabClass = "notActive";
    }
    
    public void switchToScreen(int screen)
    {
        currentScreen = screen;
        
        if (screen == homeScreen)
        {
            dailyProgressTabClass = "notActive";
            homeTabClass = "active";
        }
        else if (screen == dailyProgressScreen)
        {
            homeTabClass = "notActive";
            dailyProgressTabClass = "active";
        }
    }
}
