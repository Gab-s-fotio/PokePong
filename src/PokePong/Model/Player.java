package PokePong.Model;

/**
 *Klasse repräsentiert einen Spieler in einem Pong-Spiel. Hier ist eine kurze Beschreibung jeder Methode
 */
public class Player {

    public float size;
    /**
     *Diese private Variable speichert die Größe des Spielers.
     */
    XYTupel position;

    /**
     *Dies ist der Konstruktor der Klasse. Er initialisiert die Position und Größe des Spielers
     * @param x des Players
     * @param y des Players
     * @param size des Players
     */
    public Player(double x, double y, float size) {
        this.position = new XYTupel((float)x, (float)y);
        this.size = size;
    }

    /**
     *Diese Methode überprüft, ob der Spieler den Ball trifft
     * @param ball als Pokemon
     * @return die bedingungen zur collision des Balls
     */
    public boolean hits(Ball ball) {
        // Note: This only works in 90% of all cases. Unfortunately it does not work in edge cases (literally).
        //       Sometimes this can cause funny behaviors, because it uses a rectangular bounding box for the ball.
        return ball.collidesX(position.x) &&
                position.y - size/2.0 <= ball.position.y + ball.getSize()/2.0 &&
                position.y + size/2.0 >= ball.position.y - ball.getSize()/2.0;
    }

    /**
     *Diese Methode gibt die Größe des Spielers zurück.
     * @return der size des Spielers
     */
    public float getSize() {
        return size;
    }

    /**
     *Diese Methode gibt die Position des Spielers zurück.
     * @return die Position
     */
    public XYTupel getPosition(){
        return position ;
    }

    /**
     *Diese Methode setzt die Y-Position des Spielers.-6
     * @param posY des Spieles
     */
    public void setPosY(float posY){
        position.y=posY;
    }
}
