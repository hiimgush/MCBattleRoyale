package me.gush.battleroyale.landmark;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import me.gush.game.interfaces.Core;
import me.gush.game.interfaces.ILandmark;
import me.gush.game.interfaces.ILoot;
import me.gush.game.interfaces.Landmark;

public class BRLandmark extends Landmark{
	@Override
	public void load(ConfigurationSection section) {
		
		if(section.isConfigurationSection("region")){
			Core.getInstance().log("Landmark " + section.getName() + " no region defined!");
			return;
		}
		ConfigurationSection regionSection = section.getConfigurationSection("region");
		String regionName = regionSection.getString("name");
		String worldName = regionSection.getString("world");
		if(regionName == null){
			Core.getInstance().log("Could not load landmark " + section.getName() + " as regionName is null in config");
			return;
		}
		if(worldName == null){
			Core.getInstance().log("Could not load landmark " + section.getName() + " as worldName is null in config");
			return;
		}
		World world = Bukkit.getWorld(worldName);
		if(world == null){
			Core.getInstance().log("Could not load landmark " + section.getName() + " as world" + worldName + " does not exist.");
			return;
		}
		ProtectedRegion pRegion = WorldGuardPlugin.inst().getGlobalRegionManager().get(world).getRegion(regionName);
		if(pRegion == null){
			Core.getInstance().log("Could not load landmark " + section.getName() + " as region" + regionName + " does not exist.");
			return;
		}
		super.setRegion(pRegion);
		super.setDescription(ChatColor.translateAlternateColorCodes('&',(section.getString("description","No information for this area"))));
		super.setPrefix(ChatColor.translateAlternateColorCodes('&', (section.getString("prefix",""))));
		super.enabled = true;
		if(section.isConfigurationSection("loot")){
			ConfigurationSection lootSection = section.getConfigurationSection("loot");
			String lootName = lootSection.getString("type");
			if(lootName != null){
				ILoot loot = Core.getInstance().getLootManager().getLoot(lootName);
				if(loot!= null){
					int min = lootSection.getInt("min",0);
					int max = lootSection.getInt("max",0);
					this.setLootType(loot);
					this.setMinLoot(min);
					this.setMaxLoot(max);
				}
				
			}
			
		}
		if(section.isConfigurationSection("Landmarks")){
			section.getConfigurationSection("Landmarks").getKeys(false).forEach(subSection ->{
				ILandmark landMark = new BRLandmark();
				landMark.load(section.getConfigurationSection("Landmarks."+subSection));
				if(!landMark.isEnabled())super.enabled = false;
				else super.addSubLandmark(landMark);
					
			});
		}
		
		
	}

	

}
