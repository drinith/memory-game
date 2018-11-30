import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mesa das cartas
 * Projeto alterado para a disciplina de Game CEFET-RJ
 * 
 *   
 * @author (Felipe Mello) 
 * @version (1.9)
 */
public class MemoryWorld extends World
{
    private Time time;
    private GreenfootImage bg; //background image
    private Card[] board;  // holds cards for the game
    private Deck deck; // the deck from which the cards are dealt.
    private int numOver; //total number of cards face-up.
    private int numShowing; // number of cards showing for the current play
    private Card[] cardsShowing; // holds the cards showing for the current play
    private Label label1;
    private static final int BOARD_SIZE = 16; // Number of cards on the Memory Board
    private static final Color bgColor = Color.DARK_GRAY; //Board color 
    public MemoryWorld()
    {
       // Crie um novo mundo com 400 x 500 células com um tamanho de célula de 1x1 pixels.
       super(640, 640, 1);
       label1 =  new Label("Jogo da Memória!");
       label1.setWidth(500);
       time = new Time();
       // preenche o fundo do tabuleiro
       bg = getBackground();
       bg.setColor(bgColor);
       bg.fill();
       
                   
       
       //mantém o controle de cartões na board
       board = new Card[BOARD_SIZE];
       
       // acompanha as Cartas para jogo atual
       cardsShowing = new Card[2];
       
       numOver = 0; // número total de cartões virados para cima.
       numShowing = 0; // número de cartas exibidas para o jogo atual
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
        final int SQUARE_SIZE = 4;  // número de linhas e colunas
        int x = 80;
        int y = 80;
        int index = 0;
        for(int row = 0; row < SQUARE_SIZE;row++)
        {
            x = 80;
            for(int col = 0; col < SQUARE_SIZE; col++)
            {
                board[index].turnOver();   // comente se você quiser que os cards fiquem virados para cima
                //board[index].showFace(); // descomente se você quiser cartões para mostrar
                addObject(board[index], x, y);
                index++;
                x +=160;
            }
            y += 140;
        }
        
        // um rótulo normal = por padrão, o plano de fundo é transparente
        
        //Label texto do jogo
        
        label1.setFont(new Font("SansSerif",24));
        label1.setHeight(30);
        label1.setWidth(600); // lagura do texto
        label1.setAlignment(Label.CENTER);
        addObject(label1, 100, 600 ); //texto com seu posicionamento
        addObject(time, 500, 15 );
 
               
        
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
    
    
    
    
    //Função que encontra a combinação
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
                bg.setColor(Color.GREEN);
                bg.fill();
                Greenfoot.playSound("ponto.wav");
                Greenfoot.delay(10);
                bg.setColor(bgColor);
                bg.fill();
                numOver +=2;
                
            }
            else
            {
                Greenfoot.playSound("erro.wav");
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
            Greenfoot.playSound("win.wav");
            bg.setColor(Color.RED);
            bg.setColor(Color.YELLOW);
            bg.fill();
            label1.setText("Você ganhou! Tempo "+time.valorTempo+ "s" );
            Greenfoot.stop();
        }
        
        
        
    }
}
