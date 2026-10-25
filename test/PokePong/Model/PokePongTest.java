package PokePong.Model;

import PokePong.Model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Die PokePongTest-Klasse enthält eine Reihe
 * von JUnit-Tests, um die Funktionalität des Spiels zu überprüfen.
 */
public class PokePongTest {

public Model model ;
public Player player;
public Ball ball;
    /**
     * Diese Methode wird vor jedem Test ausgeführt und initialisiert das Modell.
     */
 @BeforeEach
void setup (){
     model = new Model(900, 600);
 }
    /**
     * Diese Methode wird nach jedem Test ausgeführt und
     * kann verwendet werden, um Ressourcen freizugeben
     * oder den Zustand für den nächsten Test zurückzusetzen.
     */
 @AfterEach
void tearDown() {}
    /**
     * Dieser Test überprüft, ob ein neues Spiel korrekt initialisiert wird.
     */
 @Test
 void startNewGame_Initialisierung_Ball_Player (){
     model.startNewGame();
     assertNotNull(model.getData().getPlayer1());
     assertNotNull(model.getData().getPlayer2());
     assertNotNull(model.getData().ball);
     assertNotEquals(0,model.getData().ball.getAcceleration());
 }
    /**
     * Dieser Test überprüft, ob Kollisionen korrekt behandelt werden.
     */
 @Test
void handleCollisions_Zeig_collission() {
     model.startNewGame();
     model.getData().ball.position = new XYTupel(120,0);
     float ballAccelerationy = model.getData().ball.getAcceleration().getY();
     model.handleCollisions();
     assertEquals(ballAccelerationy*(-1.0),model.getData().ball.getAcceleration().getY());

     model.getData().ball.position = new XYTupel(120,model.height);
      ballAccelerationy = model.getData().ball.getAcceleration().getY();
     model.handleCollisions();
     assertEquals(ballAccelerationy*-1.,model.getData().ball.getAcceleration().getY());


     model.getData().ball.position = model.getPlayer1().getPosition();
     float ballAccelerationx = model.getData().ball.getAcceleration().getX();
     model.handleCollisions();
     assertEquals(ballAccelerationx*-1 , model.getData().ball.getAcceleration().getX());

     model.getData().ball.position = model.getData().getPlayer2().getPosition();
     ballAccelerationx = model.getData().ball.getAcceleration().getX();
     model.handleCollisions();
     assertEquals(ballAccelerationx*-1 ,model.getData().ball.getAcceleration().getX());

     model.getData().ball.position = new XYTupel(0,100);
     model.handleCollisions();
     assertEquals(GameState.GAME_OVER,model.getData().getState());

     model.getData().ball.position = new XYTupel(model.width,100);
     model.handleCollisions();
     assertEquals(GameState.GAME_OVER,model.getData().getState());
 }
    /**
     * Dieser Test überprüft, ob Spieler korrekt erstellt werden.
     */
 @Test
    void player_soll_returnValue(){

     Player player1  = new Player(30.0,122.0,40);
     Player player2 = new Player(120,300.,40);
     assertNotNull(player1);
     assertNotNull(player2);
 }
    /**
     * Dieser Test überprüft, ob die Beschleunigung des Balls korrekt randomisiert wird.
     */
@Test
    void ramdommizeAcceleration (){
   Ball ball = new Ball(0,0,50);
     ball.randomizeAcceleration();
     assertTrue((ball.getAcceleration().getX()==1 || ball.getAcceleration().getX()==-1) && (ball.getAcceleration().getY()<=1 || ball.getAcceleration().getY()>=-1));
}

@Test
    void checkcollisionX (){
     var ball = new Ball(50, 70 ,5);
     assertFalse(ball.collidesX(70));
     assertTrue(ball.collidesX(50));
}
    /**
     * Dieser Test überprüft, ob Kollisionen mit der y-Achse korrekt erkannt werden.
     */
@Test
    void checkcollisionY(){
     var ball = new Ball(80,0,100);
     assertFalse(ball.collidesY(80));

    assertTrue(ball.collidesY(0));

}
    /**
     * Dieser Test überprüft, ob die Position des Balls korrekt aktualisiert wird.
     */
@Test
    void check_UpdateBallPosition(){

    model.startNewGame();
    model.getData().ball.position =new XYTupel(40,60);
   float ballx =model.getData().ball.position.getX();
   float bally = model.getData().ball.position.getY();
   model.getData().ball.updateBallPosition(14);
        // Überprüfen Sie, ob die Position des Balls korrekt aktualisiert wurde
        assertNotEquals(ballx, model.getData().ball.position.getX());
        assertNotEquals(bally, model.getData().ball.position.getY());


}

}
