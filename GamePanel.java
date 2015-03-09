import greenfoot.*;
import java.util.List;
import java.util.Random;
import java.awt.Color;
/**
 * Write a description of class GamePanel here.
 * 
 * @author Peyton Duncan 
 * @version (a version number or a date)
 */
public class GamePanel extends World
{
    private Random rand = new Random();
    private int[][] tileValues = new int[4][4];
    // public static int additionTimer = 0;
    public static int tilemovesCompletedAfter = 0;
    public static int tilemovesCompletedBefore = 0;
    private int startingPlace = 0;
    private int continuityCheck = 2;
    public static int score = 0;
    private ScoreCounter scoreCount;
    /**
     * Constructor for objects of class GamePanel.
     * 
     */
    public GamePanel()
    {    
        super(500, 722, 1); 
        setBoard();
        loadBoard();
        //if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")){addTwoTile();}

    }

    public void act(){
        //computeScore();

        //Tile.count = 0;
        //System.out.println("Tilemoves completed After:" +tilemovesCompletedAfter+ "\tTiles: " + numofTilesDisplayed());
        //System.out.println("TileMove:" + Tile.tileMove);
        List<Tile> tiles = getObjects(Tile.class);
        String keypress = Greenfoot.getKey();
        //Tile.count=0;
        for(Tile t:tiles){
            t.keyPressed = keypress;
        }
        //boolean placed = true;
        System.out.println("Count: " + Tile.count +"\tTiles Displayed: " + numofTilesDisplayed()+"\tCheck: "+continuityCheck);
        if(Tile.count == numofTilesDisplayed()){addTwoTile();//additionTimer=0;
            Tile.count=0;
            System.out.println("added one");
        }
        if(numofTilesDisplayed()!=continuityCheck){Tile.count = 0;continuityCheck=numofTilesDisplayed();}
        scoreCount.updateText(score);
    }

    public void addTwoTile(){
        boolean addedOne = false;
        if(isFull()){
            displayLoseScreen();
        }
        while(!addedOne){
            outerloop: for(int i = 0;i<tileValues.length;i++){
                for(int j = 0;j<tileValues[i].length;j++){
                    if(getObjectsAt(67+(i*121),292+(j*122),Tile.class).isEmpty()&&rand.nextInt(20)==1){
                        addObject(new Tile(2),67+(i*121),292+(j*122));
                        addedOne = true;
                        break outerloop;
                    }
                }
            }}

    }

    private boolean isFull(){
        return numberOfObjects()-1==16;
    }

    private void setBoard(){
        scoreCount = new ScoreCounter(score+"",48);
        addObject(scoreCount,150,200);
        int numoftwos = 0;
        for(int i = 0; i<tileValues.length;i++){
            for(int j = 0; j<tileValues[i].length;j++){
                tileValues[i][j]=0;
            }
        }
        while(numoftwos<2){
            int rand1 = rand.nextInt(4);
            int rand2 = rand.nextInt(4);
            if(tileValues[rand1][rand2]==0){
                tileValues[rand1][rand2]=2;numoftwos++;}
        }
    }

    private void loadBoard(){
        for(int i = 0; i<tileValues.length;i++){
            for(int j = 0; j<tileValues.length;j++){
                if(tileValues[i][j]!=0){addObject(new Tile(tileValues[i][j]),67+(i*121),292+(j*122));}
            }
        }
    }

    private int numofTilesDisplayed(){
        return numberOfObjects()-1;
    }

    private void displayLoseScreen(){
        //System.out.println("you lost");
        
        GameOverScreen gameOver = new GameOverScreen(1100);
        addObject(gameOver,250,361);
        addObject(new ScoreCounter(score+"",72),240,560);
        removeObjects(getObjects(Tile.class));
        Greenfoot.stop();
    }

}
