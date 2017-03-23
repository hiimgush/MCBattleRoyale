package me.gush.game.interfaces;

import java.util.Set;
import java.util.UUID;

public interface ITeam {
	
	public boolean addPlayer(IPlayerData playerData);//returns true or false if can add player to team, such as if team is full
	public void removePlayer(String name);//preferred
	public void removePlayer(UUID uuid);//not preffered
	public void removePlayer(IPlayerData playerData);
	public int getTeamSize();
	public boolean isFull();
	public boolean isEmpty();
	public Set<IPlayerData> getTeamPlayers();
	
}
