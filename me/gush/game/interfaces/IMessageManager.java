package me.gush.game.interfaces;

import java.util.Map;
import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;

public interface IMessageManager {
	
	public String getMessage(Message message);
	
	public void addMessage(Message message, String messageValue);
	
	public Map<Message,String> getMessageMap();
	
	public Set<Message> getLoadedMessages();
	
	public FileConfiguration getMessageConfig();
	
}
