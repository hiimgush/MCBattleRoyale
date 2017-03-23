package me.gush.game.interfaces;

public abstract class LootManager implements ILootManager{

private static LootManager instance;
	
	public static LootManager getInstance(){
		return instance;
	}
}
