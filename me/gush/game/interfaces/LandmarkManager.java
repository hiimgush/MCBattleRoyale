package me.gush.game.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;

public abstract class LandmarkManager implements ILandmarkManager{
	public static LandmarkManager instance;
	protected boolean enabled = false;
	private Map<String, ILandmark> landmarks;
	
	@Override
	public ILandmark getLandmark(String name) {
		Validate.notNull(landmarks,"Landmarks cannot be null. Use hasLandmarks()");
		synchronized(landmarks){
			return landmarks.get(name);
		}
	}
	@Override
	public void addLandmark(ILandmark landmark) {
		Validate.notNull(landmark,"Landmark added cannot be null");
		synchronized(landmarks){
			if(landmarks == null)landmarks = new ConcurrentHashMap<>();
			landmarks.put(landmark.getName(), landmark);
		}
	}
	@Override
	public Collection<ILandmark> getLandmarkCollection() {
		Validate.notNull(landmarks,"Landmarks cannot be null. Use hasLandmarks()");

		synchronized(landmarks){
			ArrayList<ILandmark> localLandmarks = new ArrayList<>(landmarks.size());
			for(ILandmark landmark : landmarks.values()){
				localLandmarks.add(landmark);
			}
			return localLandmarks;
		}
	}
	@Override
	public ILandmark getLandmark(Location location) {
		Validate.notNull(location, "Location may not be null for searching landmarks");
		Validate.notNull(landmarks, "Sub Landmarks cannot be null. Use hasSubLandmarks()");
		synchronized(landmarks){
			for(ILandmark landMark: landmarks.values()){
				if(landMark.isInLandmark(location))return landMark;
			}
		}
		return null;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
