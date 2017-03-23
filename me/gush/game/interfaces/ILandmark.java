package me.gush.game.interfaces;

import java.util.Collection;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public interface ILandmark extends Enableable{
	
	public void addSubLandmark(ILandmark landMark);
	public Collection<ILandmark> getAllSubLandmarks();
	public ILandmark getLandmark(String name);
	public ILandmark getLandmark(Location location);
	public ProtectedRegion getRegion();
	public String getName();
	public String getFancyName();
	public String getDescription();
	public boolean isInLandmark(Location location);
	public ILoot getLootType();
	public int getMinLoot();
	public int getMaxLoot();
	public int getAmountLoot();
	public void load(ConfigurationSection section);
	public boolean hasLandmarks();
	public int getLandmarkCount();
	public boolean hasLoot();
}
