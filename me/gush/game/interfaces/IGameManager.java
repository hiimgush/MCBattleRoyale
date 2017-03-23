package me.gush.game.interfaces;

public interface IGameManager {

	public GameStatus getStatus();
	public int getLobbyCountdown();
	public int getStartingCountdown();
	public int getMinPlayersToStart();
	
	
}
