package me.gush.game.interfaces;

import org.bukkit.entity.Player;

/*
 * This will be created on game start
 * However teams will be null until game starts
 * as teams shouldnt be created until the game begins
 */
public interface ITeamManager {
	
	public ITeam getTeam(Player player);
	public void removeTeam(ITeam team);
	public ITeam createNewTeam();
	public int getTeamSize();
	public void setTeamSize(int size);
	public void addTeam(ITeam team);
	public int getTeamsRemaining();
	
}
