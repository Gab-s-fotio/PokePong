package PokePong.Controller;

import PokePong.Model.GameState;
import PokePong.Model.Model;
import PokePong.Model.PongData;
import PokePong.view.IView;
import PokePong.view.View;
import processing.event.KeyEvent;

/**
 * Die Klasse PokeController implementiert das Interface IController.
 * Sie stellt einen Controller für eine GUI-Ansicht dar und verwendet ein Model und eine IView.
 */
public class PokeController implements IController {
    /**
     * Erstellung einer public Objekt(model) vom Typ Model
     */
    private Model model ;
    /**
     * Erstellung einer public Objekt(view) vom Typ IView
     */
    private IView view;

    /**
     * Erstellt ein neues Controller-Objekt.
     */
    public PokeController (){

    }

    /**
     * Legt das Modell fest, das in diesem Controller verwendet werden soll.
     * @param model das zu verwendende Modell
     */
    public void setModel( Model model) {
        this.model = model;
    }

    /**
     * Legt die Ansicht fest, die in diesem Controller verwendet werden soll.
     * @param view die zu verwendende Ansicht
     */
    public void setView( IView view) {
        this.view = view;
    }
    /**
     * Diese Methode wird aufgerufen, um den nächsten Frame zu zeichnen.
     */
    public void NextFrame (){

    }
    /**
     * Diese Methode wird aufgerufen, um das Spiel zu zeichnen.
     * Sie greift auf die Daten im Modell zu und startet das Spiel.
     */
    public void draw() {
        //zugriff zu date in model und Start
        switch (model.getData().getState()) {
            case START -> {
                    view.drawGameStart();
            }
            case PLAYING -> {
                // Draw player 1 and paddle
                    view.drawPlayer1( model.p1.getPosition().getX()- (model.p1.getSize() / 2f) - model.getPADDLE_WIDTH(),model.p1.getPosition().getY(), model.p1.getSize() );
                    view.drawPaddle(model.p1.getPosition().getX()- model.getPADDLE_WIDTH() , model.p1.getPosition().getY() - model.p1.getSize()/ 2f ,model.getPADDLE_WIDTH(), model.p1.getSize());
                // Draw player 2 and paddle
                view.drawPlayer2(model.p2.getPosition().getX()+model.p2.getSize() / 2f + model.getPADDLE_WIDTH() , model.p2.getPosition().getY(), model.p2.getSize());
                view.drawPaddle2(model.p2.getPosition().getX() , model.p2.getPosition().getY() - model.p2.getSize() / 2f , model.getPADDLE_WIDTH(), model.p2.getSize());
                // Draw ball
                view.drawBall(model.getData().ball.position.getX() , model.getData().ball.position.getY(), model.getData().ball.getRotationAngle(),model.getData().ball.getSize());
                updateBallPosition();
                model.handleCollisions();
            }
            case GAME_OVER -> {
                view.drawGameOver();
            }
            default -> throw new IllegalStateException("Unexpected value: " + model.getData().getState());
        }
    }

    /**
     * Diese Methode wird aufgerufen, um die Position des Balls zu aktualisieren.
     */
    public  void updateBallPosition() {
        model.getData().ball.updateBallPosition(1.0 / view.getFrameRate());
    }

    /**
     * Diese Methode gibt die Daten des Spiels zurück.
     * @return
     */
    public PongData getData (){
        return model.getData();
    }

    /**
     * Diese Methode wird aufgerufen, um das Spiel basierend auf der Benutzereingabe zu aktualisieren.
     * @param key der vom Benutzer gedrückte Schlüssel
     * @param keycode der vom Benutzer gedrückte Tastencode
     */
    public void update (char key , int keycode){
        // Player 1: w = up and s = down
    switch (model.getData().getState()) {
        case START, GAME_OVER -> {
            if(key == ' ') {
                model.getData().state = GameState.PLAYING;
                model.startNewGame();
                //startNewGame();
            }
        }
        case PLAYING -> {
            // Player 1: w = up and s = down
            var p1 = model.getPlayer1();
            if(key == 'w')
                p1.setPosY(Math.max((float) (p1.getSize()/2.0), p1.getPosition().getY() - 10));
            if(key == 's')
                p1.setPosY(Math.min((float) (view.getHeight()-p1.getSize()/2.0), p1.getPosition().getY() + 10));

            // Player 2: Up-key = up and Down-key = down
            var p2 = model.getPlayer2();
            if(keycode == 38)
                p2.setPosY( Math.max((float) (p2.getSize()/2.0), p2.getPosition().getY() - 10));
            if(keycode == 40)
                p2.setPosY( Math.min((float) (view.getHeight() - p2.getSize()/2.0), p2.getPosition().getY() + 10));
        }
        default -> throw new IllegalStateException("Unexpected value: " + model.getData().state);
    }
    }
}


