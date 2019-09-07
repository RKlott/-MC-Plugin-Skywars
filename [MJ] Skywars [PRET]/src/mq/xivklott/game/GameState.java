package mq.xivklott.game;

public enum GameState {
	
	LOBBY(true), PREGAME(false), GAME(false), FINISH(false);
	
	private boolean canJoin;
	private static GameState current;
	
	GameState(boolean b){
		
		canJoin = b;
		
	}
	
	public boolean canJoin() {
		return canJoin;
	}
	
	public static void setState(GameState state) {
		current = state;
	}
	
	public static boolean isState(GameState state) {
		return current == state;
	}
	
	public static GameState getState() {
		return current;
	}
	
	
}
