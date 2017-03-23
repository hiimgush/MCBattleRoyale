package me.gush.game.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public abstract class Landmark implements ILandmark{
	public static String defaultPrefix="";
	//by the landmark name
	private Map<String, ILandmark> subLandmarks;
	private ProtectedRegion region;
	private String name;
	private String prefix;
	private String description;
	private ILoot lootType;
	private Integer minLoot=0,maxLoot=0,amountLoot=0;
	private ReentrantLock subLandmarkLock = new ReentrantLock();
	protected boolean enabled = false;
	
	@Override
	public void addSubLandmark(ILandmark landmark){
		Validate.notNull(landmark,"cannot add null landmark");
		synchronized(subLandmarks){
			if(subLandmarks == null)subLandmarks = new ConcurrentHashMap<>();
			subLandmarks.put(landmark.getName(), landmark);
		}
	}
	public int getLandmarkCount(){
		synchronized(subLandmarks){
			return subLandmarks ==null?0:subLandmarks.size();
		}
	}
	@Override
	public Collection<ILandmark> getAllSubLandmarks() {
		Validate.notNull(subLandmarks,"Sub Landmarks cannot be null. Use hasSubLandmarks()");
		subLandmarkLock.lock();
		ArrayList<ILandmark> localLandmarks = new ArrayList<>(subLandmarks.size());
		try{
		for(ILandmark landmark : subLandmarks.values()){
			localLandmarks.add(landmark);
		}
		return localLandmarks;
		}finally{
			subLandmarkLock.unlock();
		}
	}
	
	@Override
	public ILandmark getLandmark(String name) {
		Validate.notNull(subLandmarks,"Sub Landmarks cannot be null. Use hasSubLandmarks()");
		subLandmarkLock.lock();
		try{
		return subLandmarks.get(name);
		}finally{
			subLandmarkLock.unlock();
		}
	}

	@Override
	public ILandmark getLandmark(Location location) {
		Validate.notNull(location, "Location may not be null for searching landmarks");
		Validate.notNull(subLandmarks, "Sub Landmarks cannot be null. Use hasSubLandmarks()");
		subLandmarkLock.lock();
		try{
			for(ILandmark landMark: subLandmarks.values()){
				if(landMark.isInLandmark(location))return landMark;
			}
		}finally{
			subLandmarkLock.unlock();
		}
		return null;
	}
	
	/*
	 * Not sure how thread safe this is.
	 */
	@Override
	public ProtectedRegion getRegion() {
		Validate.notNull(region);
		synchronized(region){
			return region;
		}
	}

	@Override
	public String getName() {
		Validate.notNull(name);
		synchronized(name){
			return name;
		}
	}

	@Override
	public String getFancyName(){
		Validate.notNull(name);
		synchronized(name){
			return ((prefix != null)?prefix + name: defaultPrefix + name);
		}
	}

	@Override
	public String getDescription() {
		Validate.notNull(description);
		synchronized(description){
			return description;
		}
	}

	@Override
	public boolean isInLandmark(Location location) {
		Validate.notNull(region);
		Validate.notNull(location,"Location cannot be null");
		synchronized(region){
			return region.contains(location.getBlockX(),location.getBlockY(),location.getBlockZ());
		}
	}

	@Override
	public ILoot getLootType() {
		Validate.notNull(lootType);
		synchronized(lootType){
			return lootType;
		}
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	@Override
	public boolean hasLoot(){
		return lootType != null;
	}
	@Override
	public int getMinLoot() {
		Validate.notNull(minLoot);
		synchronized(minLoot){
			return minLoot.intValue();
		}
	}

	@Override
	public int getMaxLoot() {
		Validate.notNull(maxLoot);
		synchronized(maxLoot){
			return maxLoot.intValue();
		}
	}

	public void setRegion(ProtectedRegion region) {
		synchronized(region){
		this.region = region;
		}
	}

	public void setName(String name) {
		synchronized(name){
			this.name = name;
		}
		
	}

	public void setPrefix(String prefix) {
		synchronized(prefix){
		this.prefix = prefix;
		}
	}

	public void setDescription(String description) {
		synchronized(description){
		this.description = description;
		}
	}

	public void setLootType(ILoot lootType) {
		synchronized(lootType){
		this.lootType = lootType;
		}
	}

	public void setMinLoot(Integer minLoot) {
		synchronized(minLoot){
		this.minLoot = minLoot;
		}
	}

	public void setMaxLoot(Integer maxLoot) {
		synchronized(maxLoot){
		this.maxLoot = maxLoot;
		}
	}

	public void setAmountLoot(Integer amountLoot) {
		synchronized(amountLoot){
			this.amountLoot = amountLoot;
		}
	}

	public void setSubLandmarkLock(ReentrantLock subLandmarkLock) {
		synchronized(subLandmarkLock){
		this.subLandmarkLock = subLandmarkLock;
		}
	}

	@Override
	public int getAmountLoot() {
		Validate.notNull(amountLoot);
		synchronized(amountLoot){
			return amountLoot.intValue();
		}
	}
	@Override
	public boolean hasLandmarks() {
		return subLandmarks!= null;
	}

}
