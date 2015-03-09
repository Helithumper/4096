import greenfoot.*;import java.util.List;
/**
 * Write a description of class Tile here.
 * 
 * @author Peyton Duncan
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    public int value = 2;
    private int additionTimer = 3;
    public static int count = 0;
    public String keyPressed = "";
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tile(int value){this.value = value;setImage(new GreenfootImage(value+"Tile.png"));}
    public Tile(int x,int y){setLocation(x,y);}
    public void act() 
    {
        //System.out.println("X: " + getX()+ "Y: " + getY());
        
        //if(additionTimer>2){
        //while(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("down")){
        if(keyPressed =="left"){
            //while(getWorld().getObjectsAt(getX(),getY()+122,Tile.class).isEmpty()&&getY()<430){
            for(int i = 0;i<3;i++){
                List<Tile> tileList = getWorld().getObjectsAt(getX()-121,getY(),Tile.class);
                if(tileList.isEmpty()==false){
                    if(tileList.get(0).value==value){
                        getWorld().removeObject(tileList.get(0));
                        value = tileList.get(0).value*2;
                        GamePanel.score += value;
                        setLocation(getX()-121,getY());
                        if(value==2048){
                            winScreen();}
                        repaint();
                        count--;
                    }
                }
                if(tileList.isEmpty()&&getX()>67){
                    setLocation(getX()-121,getY());
                    //GamePanel.additionTimer = 1;
                }
                //GamePanel.addTwoTile();
            }
            count++;
        }
        else if(keyPressed=="right"){
            //while(getWorld().getObjectsAt(getX(),getY()+122,Tile.class).isEmpty()&&getY()<430){
            for(int i = 0;i<3;i++){
                List<Tile> tileList = getWorld().getObjectsAt(getX()+121,getY(),Tile.class);
                if(tileList.isEmpty()==false){
                    if(tileList.get(0).value==value){
                        getWorld().removeObject(tileList.get(0));
                        value = tileList.get(0).value*2;
                        GamePanel.score += value;
                        setLocation(getX()+121,getY());
                        if(value==2048){
                            winScreen();}
                        repaint();
                        count--;
                    }
                }
                if(tileList.isEmpty()&&getX()<430){
                    setLocation(getX()+121,getY());//GamePanel.additionTimer = 1;
                }
            }
            count++;
        }
        else if(keyPressed =="up"){
            // while(getWorld().getObjectsAt(getX(),getY()+122,Tile.class).isEmpty()&&getY()<430){
            for(int i = 0;i<3;i++){
                List<Tile> tileList = getWorld().getObjectsAt(getX(),getY()-122,Tile.class);
                if(tileList.isEmpty()==false){
                    if(tileList.get(0).value==value){
                        getWorld().removeObject(tileList.get(0));
                        value = tileList.get(0).value*2;
                        GamePanel.score += value;
                        setLocation(getX(),getY()-122);
                        if(value==2048){
                            winScreen();}
                        repaint();
                        count--;
                    }

                }
                if(tileList.isEmpty()&&getY()>295){
                    setLocation(getX(),getY()-122);
                    //.additionTimer = 1;
                }
            }
            count++;
        }
        else if(keyPressed =="down"){
            //while(getWorld().getObjectsAt(getX(),getY()+122,Tile.class).isEmpty()&&getY()<430){
            for(int i = 0;i<3;i++){
                List<Tile> tileList = getWorld().getObjectsAt(getX(),getY()+122,Tile.class);
                if(tileList.isEmpty()==false){
                    if(tileList.get(0).value==value){
                        getWorld().removeObject(tileList.get(0));
                        value = tileList.get(0).value*2;
                        
                        setLocation(getX(),getY()+122);
                        if(value==2048){
                            winScreen();}
                        repaint();
                        count--;
                    }
                }
                if(tileList.isEmpty()&&getY()<655){
                    setLocation(getX(),getY()+122);
                    // GamePanel.additionTimer = 1;
                }
            }
            count++;

    
            // }
            //additionTimer=0;
        }
        keyPressed = "";
    }    

    public int getTileValue(){
        return value;}

    private void repaint(){
        setImage(new GreenfootImage(value+"Tile.png"));
    }

    private void winScreen(){
        Greenfoot.stop();
    }
}
