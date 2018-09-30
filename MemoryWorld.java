import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Area for the cards to be
 * 
 * @author (Anthony Zepperi) 
 * @version (1.9)
 */
public class MemoryWorld extends World
{
    private GreenfootImage bg; //background image
    private Card[] board;  // holds cards for the game
    private Deck deck; // the deck from which the cards are dealt.
    private int numOver; //total number of cards face-up.
    private int numShowing; // number of cards showing for the current play
    private Card[] cardsShowing; // holds the cards showing for the current play
    private Label label1;
    private static final int BOARD_SIZE = 16; // Number of cards on the Memory Board
    private static final Color bgColor = Color.LIGHT_GRAY; //Board color 
    public MemoryWorld()
    {
       // Create a new world with 400 x 500 cells with a cell size of 1x1 pixels.
       super(400, 500, 1);
       label1 =  new Label("Memory!");
       //fills background of board
       bg = getBackground();
       bg.setColor(bgColor);
       bg.fill();
       
       //keeps track of cards on board
       board = new Card[BOARD_SIZE];
       
       //keeps track of Cards for current play
       cardsShowing = new Card[2];
       
       numOver = 0; // total number of cards face-up.
       numShowing = 0; // number of cards showing for the current play
       deck = new Deck();
       
       fillArray();
       setup();
       
    }
    
    public void fillArray()
    {
        for(int i = 0; i < BOARD_SIZE/2; i++)
        {
            Card randomCard = deck.deal();
            Card cardCopy = new Card(randomCard.getCardImage());
            board[getRandomPosition()] = randomCard;
            board[getRandomPosition()] = cardCopy;
            //System.out.print.In();
            
        }
    }
    
    
    
    
    
    
    public void setup()
    {
        final int SQUARE_SIZE = 4;  //number of rows and columns
        int x = 80;
        int y = 80;
        int index = 0;
        for(int row = 0; row < SQUARE_SIZE;row++)
        {
            x = 80;
            for(int col = 0; col < SQUARE_SIZE; col++)
            {
                board[index].turnOver();   //comment if you want cards to be face-up
                //board[index].showFace(); //uncomment if you want cards to show
                addObject(board[index], x, y);
                index++;
                x +=80;
            }
            y += 110;
        }
        
        // a normal label = by default, the background is transparent
        
        label1.setFont(new Font("SansSerif",24));
        label1.setHeight(30);
        label1.setWidth(200); //some random guess
        label1.setAlignment(Label.CENTER);
        addObject(label1, 120, 470 );
        
        
    }
    
    
    
    
    
    public int getRandomPosition()
    {
        int randPlace = Greenfoot.getRandomNumber(BOARD_SIZE);
        while (board[randPlace] != null)
        {
            randPlace = Greenfoot.getRandomNumber(BOARD_SIZE);
        }
        //System.out.print(randPLace + " ");
        return randPlace;
    }
    
    
    
    
    public void recordCardShowing(Card c)
    {
        cardsShowing[numShowing] = c;
        numShowing++;
    }
    
    
    
    
    
    public boolean checkMatch()
    {
        return cardsShowing[0].getCardImage().equals(cardsShowing[1].getCardImage());
    }
    
    
    
    
    
    
    
    
    public void act()
    {
        if (numShowing == 2)
        {
            Greenfoot.delay(50);
            if (checkMatch())
            {
                bg.setColor(Color.RED);
                bg.fill();
                Greenfoot.playSound("cowbell.wav");
                Greenfoot.delay(10);
                bg.setColor(bgColor);
                bg.fill();
                numOver +=2;
                
            }
            else
            {
                Greenfoot.playSound("no.wav");
                cardsShowing[0].turnOver();
                cardsShowing[1].turnOver();
            }
            cardsShowing[0]=null;
            cardsShowing[1]=null;;
            numShowing = 0;
        }
        
        //check win
        if(numOver == BOARD_SIZE)
        {
            //System.out.printIn("WIN");
            Greenfoot.playSound("tada.wav");
            bg.setColor(Color.RED);
            bg.fill();
            label1.setText("You Win!");
            Greenfoot.stop();
        }
        
        
        
    }
}
