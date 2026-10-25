package PokePong.Model;

/**
 * Die Klasse Ball repräsentiert einen Ball in einem Pong-Spiel.
 * Sie enthält Daten und Logik für die Bewegung des Balls.
 */
public class Ball {
    // Größe, Geschwindigkeitsfaktor und Winkel des Balls
    /**
     *grösse des Balls
     */
    private float size;
    /**
     *Geschwindigkeitsfaktor des Balls
     */
    private int speedFactor = 150;
    /**
     *Winkel des Balls
     */
    private float angle = 0;
    // Position und Beschleunigung des Balls
    /**
     *Position des Balls
     */
    public XYTupel position;
    /**
     * Beschleunigung des Balls
     */
    XYTupel acceleration;

    /**
     * Erstellt ein neues Ball-Objekt mit der gegebenen Position und Größe.
     * @param x die x-Position des Balls
     * @param y die y-Position des Balls
     * @param size die Größe des Balls
     */
    public Ball(double x, double y, float size) {
        this.position = new XYTupel((float)x, (float)y);
        this.acceleration = new XYTupel(0, 0);
        this.size = size;
    }

    /**
     * Aktualisiert die Position des Balls basierend auf der Zeit.
     * @param timeFactor der Zeitfaktor
     */
    public void updateBallPosition(double timeFactor) {
        position.x += (float) (acceleration.x * speedFactor * timeFactor);
        position.y += (float) (acceleration.y * speedFactor * timeFactor);
        angle += 2;
    }

    /**
     * Zufällige Beschleunigung des Balls.
     */
    public void randomizeAcceleration() {
        acceleration.x = (Math.random() >= 0.5) ? 1 : -1;
        acceleration.y = (float) (2 * Math.random() - 1);
    }

    /**
     * Überprüft, ob der Ball mit der y-Achse kollidiert.
     * @param wall die Position der Wand
     * @return true, wenn der Ball kollidiert, sonst false
     */
    public boolean collidesY(float wall) {
        return (wall >= position.y - size / 2.0) && (wall <= position.y + size / 2.0);
    }

    /**
     * Überprüft, ob der Ball mit der x-Achse kollidiert.
     * @param wall die Position der Wand
     * @return true, wenn der Ball kollidiert, sonst false
     */
    public boolean collidesX(float wall) {
        return (wall >= position.x - size / 2.0) && (wall <= position.x + size / 2.0);
    }

    /**
     * Gibt die Größe des Balls zurück.
     * @return die Größe des Balls
     */
    public float getSize() {
        return size;
    }

    /**
     * Gibt den Rotationswinkel des Balls zurück.
     * @return der Rotationswinkel des Balls
     */
    public float getRotationAngle() {
        return (float)Math.toRadians(angle);
    }
    public XYTupel getAcceleration(){
        return acceleration;
    }
}

