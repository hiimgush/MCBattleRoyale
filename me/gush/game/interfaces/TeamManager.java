package me.gush.game.interfaces;

public abstract class TeamManager implements ITeamManager{
	
	private static TeamManager instance;
	
	public static TeamManager getInstance(){
		return instance;
	}
	
}
