import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Escreva uma descrição da classe Card aqui.
 * 
 * @author (Felipe) 
 * @version ()
 */
public class Card extends Actor
{
    private String cardImage;  // o nome do arquivo da imagem do cartão
    private String cardImageOver;  // o nome do arquivo da parte de trás do cartão
    private boolean faceUp; // controla se o cartão está virado para cima ou não
    
    
    
    
    public Card(String im)
    {
        cardImage = im;
        cardImageOver = "b.png";
        faceUp = false;
    }
    
    
    public String getCardImage()
    {
        return cardImage;
    }
    
    
    public void turnOver()
    {
        setImage(cardImageOver);
        faceUp = false;
    }
    
    
    public void showFace()
    {
        setImage(cardImage);
        faceUp = true;
        
    }
    
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (!faceUp)
            {
                showFace();
                MemoryWorld w = (MemoryWorld) (getWorld());
                w.recordCardShowing(this); // diz ao mundo que a carta está virada para cima.
            }
        }
    }
}
    