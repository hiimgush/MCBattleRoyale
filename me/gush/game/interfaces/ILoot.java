package me.gush.game.interfaces;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

public interface ILoot {
	
	public String getName();
	public ItemStack roll();
	public Collection<ItemStack> getItemStacks();	
	public Set<Double> getChances();
	public Map<ItemStack,Double> getOddsMap();
	
}
