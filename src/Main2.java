import PokePong.Controller.PokeController;
import PokePong.Model.Model;
import processing.core.PApplet;
import PokePong.view.View;

/**
 * Die Main2-Klasse ist der Einstiegspunkt für das Spiel. Sie erstellt das Modell, die Ansicht und den Controller des Spiels und verbindet sie miteinander.
 */
public class Main2 {
    /**
     * Die Hauptmethode des Spiels. Hier wird das Spiel initialisiert und gestartet.
     * @param args Die Befehlszeilenargumente
     */
    public static void main(String[] args) {
        // Die Breite und Höhe des Spiels
        final int GAME_WIDTH = 900;
        final int GAME_HEIGTH = 600 ;
        // Erstellen des Modells, der Ansicht und des Controllers
        var model = new Model(GAME_WIDTH,GAME_HEIGTH);
        var view = new View(GAME_WIDTH , GAME_HEIGTH) ;
        var controller  = new PokeController();

/**
 * Verbinden des Modells, der Ansicht und des Controllers
 */
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);

        // Starten des Spiels
        PApplet.runSketch(new String[]{"View_player"}, view);

    }

}
