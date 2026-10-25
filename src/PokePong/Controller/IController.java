package PokePong.Controller;

import PokePong.Model.PongData;
import processing.event.KeyEvent;
/**
 *Die Interfaces definiert die Methoden, die von einem Controller in einem Poke**Pong-Spiel implementiert werden müssen
 */
public interface IController {
  /**
   *Diese Methode wird verwendet, um die Position des Balles im Spiel zu aktualisieren
   */
  void   updateBallPosition ();

    /**
     *  Diese Methode wird verwendet, um die aktuellen Spielinformationen zu erhalten
     */
  PongData getData();

  /**
   *Diese Methode wird verwendet, um das Spiel zu zeichnen oder neu zu zeichnen.
   */
  void draw();

  /**
   *Diese Methode wird verwendet,
   * um das Spiel basierend auf der vom Benutzer eingegebenen Tasteneingabe zu aktualisieren
   * @param key als Taste
   * @param keyCode als Indikator bon einer Taste
   */
  void update(char key , int keyCode);
}
