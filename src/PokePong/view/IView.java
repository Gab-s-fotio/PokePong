package PokePong.view;

/**
 * Das IView Interface definiert die Methoden, die von einer View-Klasse implementiert werden müssen.
 * Es stellt sicher, dass alle View-Klassen bestimmte Methoden implementieren, die für die Darstellung des Spiels erforderlich sind.
 */
public interface IView {
    /**
     * Zeichnet den Startbildschirm des Spiels.
     */
    void drawGameStart();

    /**
     * Zeichnet den Game_Over-Bildschirm, wenn das Spiel vorbei ist.
     */
    void drawGameOver();

    /**
     * Zeichnet den ersten Spieler an der gegebenen Position und Größe.
     * @param x Die x-Position des Spielers
     * @param y Die y-Position des Spielers
     * @param size Die Größe des Spielers
     */
    void drawPlayer1 (float x, float y ,float size);

    /**
     * Zeichnet den zweiten Spieler an der gegebenen Position und Größe.
     * @param x Die x-Position des Spielers
     * @param y Die y-Position des Spielers
     * @param size Die Größe des Spielers
     */
    void drawPlayer2 (float x, float y ,float size);

    /**
     * Zeichnet den Ball an der gegebenen Position und Größe und dreht ihn um den gegebenen Winkel.
     * @param x Die x-Position des Balls
     * @param y Die y-Position des Balls
     * @param angle Der Winkel, um den der Ball gedreht wird
     * @param size Die Größe des Balls
     */
    void drawBall (float x , float y , float angle , float size);

    /**
     * Zeichnet den Schläger an der gegebenen Position und Größe.
     * @param x Die x-Position des Schlägers
     * @param y Die y-Position des Schlägers
     * @param width Die Breite des Schlägers
     * @param height Die Höhe des Schlägers
     */
    void drawPaddle (float x , float y ,float width, float height);

    /**
     * Gibt die aktuelle Bildrate des Spiels zurück.
     * @return Die aktuelle Bildrate des Spiels
     */
    float getFrameRate ();

    /**
     * Zeichnet den zweiten Schläger an der gegebenen Position und Größe.
     * @param x Die x-Position des Schlägers
     * @param y Die y-Position des Schlägers
     * @param width Die Breite des Schlägers
     * @param height Die Höhe des Schlägers
     */
    void drawPaddle2(float x , float y , float width , float height);

    /**
     * Gibt die Höhe des Fensters zurück.
     * @return Die Höhe des Fensters
     */
    int getHeight();

}
