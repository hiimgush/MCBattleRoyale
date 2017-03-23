package me.gush.game.interfaces;

import java.util.Map;

public abstract class PlayerManager implements IPlayerManager{
	private static PlayerManager instance;
	protected Map<String,IPlayerData> playerMap;
	public static PlayerManager getInstance(){
		return instance;
	}
}
