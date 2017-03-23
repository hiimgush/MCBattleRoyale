package me.gush.game.interfaces;

import org.bukkit.entity.Player;

public interface IPlayerData {
	
	public int getGlobalKills();//Total Kills
	
	public int getGlobalDeaths();//Total Deaths
	
	public int getKills();//Kills for current Game
	
	public Player getPlayer();
	
	public ITeam getTeam();//Should still be null if waiting for game to start
}
