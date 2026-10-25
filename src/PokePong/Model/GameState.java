
package PokePong.Model;

/**
 * Das GameState-Enum repräsentiert die verschiedenen Zustände, in denen sich das Spiel befinden kann.
 */
public enum GameState {
    /**
     * Das Spiel ist im Startzustand.
     * Dies ist der Zustand, bevor das Spiel beginnt.
     */
     START,

    /**
     * Das Spiel läuft gerade.
     * Dies ist der Zustand, wenn das Spiel aktiv ist.
     */
    PLAYING,

    /**
     *Das Spiel ist vorbei.
     * Dies ist der Zustand, nachdem das Spiel beendet wurde.
     */
    GAME_OVER

}
