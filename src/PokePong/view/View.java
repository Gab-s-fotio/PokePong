package PokePong.view;

import PokePong.Controller.IController;
import processing.core.PApplet;
import processing.core.PImage ;
import PokePong.Model.GameState;
import processing.event.KeyEvent;
/**
 * Die View-Klasse ist verantwortlich für die Darstellung des Spiels. Sie implementiert das IView-Interface.
 * Sie lädt Bilder, zeichnet Spieler, Schläger und den Ball und aktualisiert das Spiel basierend auf den Eingaben des Controllers.
 */
public class View extends PApplet implements IView {
    private IController controller;
    private PImage startScreen;
    private PImage gameOverScreen;
    private PImage player1Image;
    private PImage player2Image;
    private PImage ballImage;

    /**
     * Setzt den Controller für die View.
     * @param controller Der Controller, der die Spiellogik steuert
     */
    public void setController(IController controller){
        this.controller = controller;
        }

    /**
     * Konstruktor für die View-Klasse. Setzt die Größe des Fensters.
     * @param width Die Breite des Fensters
     * @param height Die Höhe des Fensters
     */
    public View ( int width , int height){
        setSize( width , height);
    }

    /**
     * Diese Methode wird beim Start des Programms aufgerufen und dient zur Initialisierung des Spiels.
     */
    public void setup(){

    }

    /**
     * Diese Methode zeichnet den Startbildschirm des Spiels.
     */
    public void drawGameStart (){
        startScreen = loadImage("StartScreen.jpg");
        imageMode(CORNER);
        image (startScreen , 0 , 0,width,height);

    }

    /**
     * Diese Methode zeichnet den Game Over-Bildschirm, wenn das Spiel vorbei ist.
     */
    public void drawGameOver (){
        gameOverScreen = loadImage("GameOverScreen.jpg");
        imageMode(CORNER);
        image(gameOverScreen, 0, 0, width, height);
    }

    /**
     * Diese Methode zeichnet den ersten Spieler an der gegebenen Position und Größe.
     * @param x Die x-Position des Spielers
     * @param y Die y-Position des Spielers
     * @param size Die Größe des Spielers
     */
    public void drawPlayer1 (float x , float y , float size) {
        player1Image = loadImage("025.png");
        background(255);
        imageMode(CENTER);
        image(player1Image, x, y, size, size);

    }

    /**
     * Diese Methode zeichnet den zweiten Spieler an der gegebenen Position und Größe.
     * @param x Die x-Position des Spielers
     * @param y Die y-Position des Spielers
     * @param size Die Größe des Spielers
     */
    public void drawPlayer2 (float x, float y ,float size ){
        player2Image = loadImage("133.png");
        image( player2Image , x, y , size ,size);

    }

    /**
     * Diese Methode zeichnet den Schläger an der gegebenen Position und Größe.
     * @param x Die x-Position des Schlägers
     * @param y Die y-Position des Schlägers
     * @param width Die Breite des Schlägers
     * @param height Die Höhe des Schlägers
     */
    public void drawPaddle (float x, float y, float width, float height){
        fill(0);
        rect( x , y , width, height );

    }

    /**
     * Diese Methode zeichnet den zweiten Schläger an der gegebenen Position und Größe.
     * @param x Die x-Position des Schlägers
     * @param y Die y-Position des Schlägers
     * @param width Die Breite des Schlägers
     * @param height Die Höhe des Schlägers
     */
    public void drawPaddle2 ( float x , float y , float width , float height){

        rect (x, y , width, height);
    }

    /**
     * Diese Methode lädt das Bild für den Ball.
     */
    public void drawBall (){
    ballImage = loadImage("100.png");
    }

    /**
     * Diese Methode zeichnet den Ball an der gegebenen Position und Größe und dreht ihn um den gegebenen Winkel.
     * @param x Die x-Position des Balls
     * @param y Die y-Position des Balls
     * @param angle Der Winkel, um den der Ball gedreht wird
     * @param size Die Größe des Balls
     */
    public void drawBall ( float x , float y , float angle , float size){
        ballImage = loadImage("100.png");
    translate(x, y);
    rotate(angle);
    image(ballImage, 0 ,0, size, size);

}

    /**
     * Diese Methode gibt die aktuelle Bildrate des Spiels zurück.
     * @return Die aktuelle Bildrate des Spiels
     */
    public float getFrameRate () {
        return  frameRate ;
}

    /**
     * Diese Methode wird aufgerufen, wenn eine Taste gedrückt wird. Sie aktualisiert das Spiel basierend auf der gedrückten Taste und ihrem KeyCode.
     */
    @Override
    public void keyPressed() {
        controller.update(key,keyCode);


    }

    /**
     * Diese Methode gibt die Höhe des Fensters zurück.
     * @return Die Höhe des Fensters
     */
    public int getHeight(){
        return height;
    }


    /**
     * Diese Methode wird in jedem Frame des Spiels aufgerufen und ist verantwortlich für das Zeichnen des Spiels auf dem Bildschirm.
     */
    @Override
    public void draw(){
        //drawGameOver();
        background(255);
        controller.draw();
    }
}
