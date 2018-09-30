import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Deck of cards
 * 
 * @author (Anthony Zepperi) 
 * @version (1.4)
 */
public class Deck extends Actor
{
    // Strings used to form filenames for the card images.
    private static final String[] DENOMINATIONS = {"bear","bunny","cat","devil","dice","dog","joker","tree"};
  
    
    
    private List<Card> cards; // holds playing cards
    
    
    
    
    public Deck()
    {
        cards = new ArrayList<Card>();
        for (int d = 0; d < DENOMINATIONS.length; d++)
        {
            
                String cardImage = DENOMINATIONS[d] + ".png";
                Card c = new Card(cardImage);
                cards.add(c);
         
        }
    }
    
    
    
    
    public Card deal()
    {
        int randCard = Greenfoot.getRandomNumber(cards.size());
        Card c = cards.remove(randCard);
        //System.out.print(c.getCardImage());
        
        return c;
        
    }
    
    
    
    public void act()
    {
        //do nothing
    }
    
    
}
