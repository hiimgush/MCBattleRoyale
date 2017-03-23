package me.gush.battleroyale.landmark;

import java.io.File;

import org.apache.commons.lang.Validate;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import me.gush.game.interfaces.Core;
import me.gush.game.interfaces.ILandmark;
import me.gush.game.interfaces.LandmarkManager;

public class BRLandmarkManager extends LandmarkManager{
	public BRLandmarkManager(){
		LandmarkManager.instance = this;
	}

	@Override
	public void loadLandmarks(File file) {
		
		Validate.notNull(file,"File path for yaml configuration does not exist for Landmarks");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		Validate.notNull(config,"Yaml Configuration path for landmarks does not exist!");
		if(!config.isConfigurationSection("Landmarks")){
			Core.getInstance().log("Landmark manager will not enable as there is no config section 'Landmarks'");
			return;
		}
		ConfigurationSection section = config.getConfigurationSection("Landmarks");
		section.getKeys(false).forEach(subsection ->{
			ILandmark thisLandmark = new BRLandmark();
			thisLandmark.load(section.getConfigurationSection(subsection));
			if(thisLandmark.isEnabled()){
				addLandmark(thisLandmark);
				Core.getInstance().log("Loaded landmark " + thisLandmark.getName() 
				+ ((thisLandmark.hasLandmarks())? " with " + thisLandmark.getLandmarkCount() + " sublandmarks.":"."));
			}
		});
	}

}
