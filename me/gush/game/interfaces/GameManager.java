package me.gush.game.interfaces;

public abstract class GameManager implements IGameManager{
private static GameManager instance;
	
	public static GameManager getInstance(){
		return instance;
	}
	protected abstract void start();
}
