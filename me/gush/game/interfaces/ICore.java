package me.gush.game.interfaces;

/*
 * This will be the core for
 * Battle Royale
 * Anything and everything will
 * probably be passed through here
 * Consider this the central point of all of the games code
 * 
 * We will be using 1.9 Spigot
 */

public interface ICore {
	
	public ITeamManager getTeamManager();//For keeping track of teams
	
	public IPlayerManager getPlayerManager();//For keeping track of players
	
	public ILootManager getLootManager();//For loading of loot, where to put the loot
	
	public IGameManager getGameManager();//For the general game functionality, countdown in the lobby, countdown of the game
	
	public IMessageManager getMessageManager();
	
	public ILandmarkManager getLandmarkManager();
	
	public String getConsoleTag();
	
	public void log(String desc);
	
}
