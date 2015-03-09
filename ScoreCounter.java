import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class ScoreCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCounter extends Actor
{
    private int width,height;
    private String score;
    private int size;
    public ScoreCounter(String s,int si){
        score = s;
        size = si;
        updateImage();
    }
    /**
     * Act - do whatever the ScoreCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
    public void updateText(int i){
        score = i+"";
        updateImage();
    }
    public void updateImage(){
        GreenfootImage image = new GreenfootImage(score,size,Color.YELLOW,null);
        setImage(image);
        
    }
}
