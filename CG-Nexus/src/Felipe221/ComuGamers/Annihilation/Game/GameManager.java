package Felipe221.ComuGamers.Annihilation.Game;

import java.util.HashMap;

public class GameManager {
	public static HashMap<String, GameState> status = new HashMap<String, GameState>();
	public static HashMap<String, GamePhase> phase = new HashMap<String, GamePhase>();
	
	public static enum GameState {
		ESPERANDO, INICIANDO, EN_JUEGO, RESETEANDO;
	}
	
	public static enum GamePhase{
		NULL, I, II, III, IV, V;
	}
	
	public static GamePhase getPhase() {
		return phase.get("a1");
	}
	
	public static void setPhase(GamePhase p) {
		phase.put("a1", p);
	}
	
	public static GameState getState() {
		return status.get("a1");
	}
	
	public static void setState(GameState p) {
		status.put("a1", p);
	}
}
