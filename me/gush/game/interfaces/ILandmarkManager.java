package me.gush.game.interfaces;

import java.io.File;
import java.util.Collection;
import java.util.Set;

import org.bukkit.Location;

public interface ILandmarkManager extends Enableable{
	
	public ILandmark getLandmark(String name);
	public void addLandmark(ILandmark landmark);
	public Collection<ILandmark> getLandmarkCollection();
	public ILandmark getLandmark(Location location);
	public void loadLandmarks(File file);
}
