package PokePong.Model;
/**
 * Die Model-Klasse repräsentiert den Zustand des Spiels. Sie enthält Informationen über die Spieler, den Ball und den aktuellen Spielzustand.
 */
public class Model {
    /**
     * PADDLE_WIDTH: Die Breite des Schlägers als final variable
     * final
     */
    final int PADDLE_WIDTH = 5;
    /**
     * BALL_SIZE: Die Größe des Balls als final variable
     * final
     */
    final int BALL_SIZE = 25;
    /**
     * BALL_SIZE: Die Größe des Spielers als final variable
     * final
     */
    final int PLAYER_SIZE = 50;
    /**
     *width , height:Die Breite und Höhe des Spielfelds
     */
    public int  width , height;
    /**
     *data: Die Daten des Spiels
     */
    private PongData data ;
    /**
     *  p1 :Der erste Spieler
     */
    public Player p1 ;
    /**
     * p2:Der zweite Spieler
     */
    public Player p2 ;
    /**
     * Konstruktor für die Model-Klasse. Initialisiert das Spielfeld und setzt den Spielzustand auf START.
     * @param width Die Breite des Spielfelds
     * @param height Die Höhe des Spielfelds
     */
    public Model ( int width , int height){
        this.width = width;
        this.height = height;

        data = new PongData();
        data.state =  GameState.START;
    }

    /**
     *die Methode StartNewGame initialisiere das Spiel mit 2 Pläyer P1 und P2 mit deren Positionen und der Ball in der Mitte
     */
    public void startNewGame() {
        p1=new Player(PLAYER_SIZE+PADDLE_WIDTH, (height-PLAYER_SIZE)/2.0 - PADDLE_WIDTH, PLAYER_SIZE);
        p2=new Player(width-PLAYER_SIZE-PADDLE_WIDTH, (height-PLAYER_SIZE)/2.0 + PADDLE_WIDTH, PLAYER_SIZE);
        data.player1 = p1;
        data.player2 = p2;

        data.ball = new Ball(width/2.0, height/2.0, BALL_SIZE);
        data.ball.randomizeAcceleration();
    }

    /**
     * Diese Methode gibt den ersten Spieler zurück.
     * @return Der erste Spieler
     */
    public Player getPlayer1 (){
        return  p1;
}

    /**
     * Diese Methode gibt den zweiten Spieler zurück.
     * @return Der zweite Spieler
     */
    public Player getPlayer2() {
        return p2;
    }

    /**
     * Diese Methode gibt die Daten des Spiels zurück.
     * @return Die Daten des Spiels
     */
    public PongData getData (){
        return data ;
    }
    /**
     * Diese Methode gibt die Breite des Schlägers zurück.
     * @return Die Breite des Schlägers
     */
    public int getPADDLE_WIDTH (){
        return PADDLE_WIDTH ;
    }
    /**
     * Diese Methode behandelt Kollisionen im Spiel. Sie ändert die Bewegungsrichtung des Balls,
     * wenn er mit den Wänden oder den Schlägern kollidiert,
     * und setzt den Spielzustand auf GAME_OVER, wenn der Ball die linke oder rechte Wand berührt.
     */
    public void handleCollisions() {
        // Reflect on y-axis on top and bottom wall
        if(data.ball.collidesY(0) || data.ball.collidesY(height)) {
            data.ball.acceleration.y *= -1;
        }
        // Reflect on x-axis when paddle hits the ball
        if (data.player1.hits(data.ball) || data.player2.hits(data.ball)) {
            data.ball.acceleration.x *= -1;
        }
        // Game over on hitting left or right wall
        if (data.ball.collidesX(0) || data.ball.collidesX(width)){
            data.state = GameState.GAME_OVER;
        }
    }
}
