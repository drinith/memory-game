import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Time here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time extends Actor
{
    /**
     * Act - do whatever the Time wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static GreenfootImage  image;
    public static boolean contar=true;
    long startTime;
    long currentTime;
    public int durationSecs =0;
    int durationMillis;
   
    public Time (){
        
         
        act();
        startTime = System.currentTimeMillis();
    }  
    
    
    
    public void act() 
    {
     
        image = new GreenfootImage("Tempo: "+durationSecs+" s",
                                                      30,
                                                      new Color(0,0,0,200),
                                                      new Color(255,255,255,0));
        setImage(image); // Atualiza o ator com a imagem
            
               
       
        // Add your action code here.
         
     
       
           
               // Later (for example in an act() method), do:
        currentTime = System.currentTimeMillis();
        durationMillis = (int)(currentTime - startTime);
        System.out.print(durationMillis);
        // durationMillis is in milliseconds, so you
        // can convert to seconds/minutes whatever:
        durationSecs = durationMillis / 1000;
    
    }    
}
