package me.gush.game.interfaces;

import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

public abstract class MessageManager implements IMessageManager{
protected static MessageManager instance;
protected FileConfiguration config;	
protected Map<Message, String> messages;
	public static MessageManager getInstance(){
		return instance;
	}
	public MessageManager(){
		instance = this;
		loadConfig();
		loadStartupMessages();
	}
	protected abstract void loadStartupMessages();
	protected abstract FileConfiguration loadConfig();
}
