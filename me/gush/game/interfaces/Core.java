package me.gush.game.interfaces;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class Core extends JavaPlugin implements ICore{
	
	/*
	 * The actual game will be extending this class
	 * However all methods will be inside of ICore
	 */
	protected static Core instance;
	protected ITeamManager teamManager;
	protected IPlayerManager playerManager;
	protected IGameManager gameManager;
	protected IMessageManager messageManager;
	protected ILandmarkManager landmarkManager;
	protected ILootManager lootManager;
	public static Core getInstance(){
		return instance;
	}
	@Override
	public ITeamManager getTeamManager() {
		return teamManager;
	}
	
	@Override
	public IPlayerManager getPlayerManager() {
		// TODO Auto-generated method stub
		return playerManager;
	}

	@Override
	public ILootManager getLootManager() {
		// TODO Auto-generated method stub
		return lootManager;
	}

	@Override
	public IGameManager getGameManager() {
		// TODO Auto-generated method stub
		return gameManager;
	}
	@Override
	public void log(String desc){
		getLogger().info(getConsoleTag() + " " + desc);
	}
	@Override
	public IMessageManager getMessageManager() {
		// TODO Auto-generated method stub
		return messageManager;
	}

	@Override
	public ILandmarkManager getLandmarkManager() {
		// TODO Auto-generated method stub
		return landmarkManager;
	}
	
}
