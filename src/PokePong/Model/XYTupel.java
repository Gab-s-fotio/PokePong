package PokePong.Model;

/**
 * Die XYTupel-Klasse repräsentiert ein Tupel von x- und y-Koordinaten.
 */
public class XYTupel {
    /**
     *Die x-Koordinate
     */
    float x = 0;
    /**
     *Die y-Koordinate
     */
    float y = 0;

    //XYTupel() {}

    /**
     * Dieser Konstruktor erstellt ein XYTupel mit den gegebenen x- und y-Koordinaten.
     * @param x Die x-Koordinate
     * @param y Die y-Koordinate
     */
   public  XYTupel(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Diese Methode gibt die x-Koordinate zurück.
     * @return Die x-Koordinate
     */
    public float getX (){
        return x ;
    }

    /**
     * Diese Methode gibt die y-Koordinate zurück.
     * @return Die y-Koordinate
     */
    public float getY (){
        return y ;
    }
}
