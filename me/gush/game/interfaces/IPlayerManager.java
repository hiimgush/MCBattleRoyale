package me.gush.game.interfaces;

import java.util.UUID;

public interface IPlayerManager {
	
	public IPlayerData getPlayerData(String name);//preferred
	
	public IPlayerData getPlayerData(UUID uuid);
	
	public void removePlayerData(UUID uuid);
	
	public void removePlayerData(String name);
	
}
