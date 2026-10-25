
package PokePong.Model;

import PokePong.Model.GameState;
import PokePong.Model.Player;

/**
 * Die PongData-Klasse enthält den aktuellen Zustand des Spiels, einschließlich der Spieler und des Balls.
 */
public class PongData {
    /**
     *Der aktuelle Zustand des Spiels
     */
    public GameState state;
    /**
     *Der erste Spieler
     */
    Player player1;
    /**
     * Der zweite Spieler
     */
    Player player2;
    /**
     * instansierte objekt aus der Klasse ball
     */
    public Ball ball;

    /**
     * Diese Methode gibt den aktuellen Zustand des Spiels zurück.
     * @return Der aktuelle Zustand des Spiels
     */
    public GameState getState (){
        return state ;
    }

    /**
     * Diese Methode setzt den aktuellen Zustand des Spiels.
     * @param state Der neue Zustand des Spiels
     */
    public void setState (GameState state){
        this.state = state ;
}

    /**
     * Diese Methode gibt den ersten Spieler zurück.
     * @return Der erste Spieler
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Diese Methode gibt den zweiten Spieler zurück.
     * @return Der zweite Spieler
     */
    public Player getPlayer2() {
        return player2;
    }
}
