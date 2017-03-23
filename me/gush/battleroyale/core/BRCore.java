package me.gush.battleroyale.core;

import me.gush.game.interfaces.Core;

public class BRCore extends Core{
	
	@Override
	public void onEnable(){	
		getServer().setWhitelist(true);
		checkDependencies();
	}

	private void checkDependencies() {
		if(this.getServer().getPluginManager().getPlugin("WorldGuard")==null){
			log("WG not enabled, disabling this plugin.");
		}
		
	}

	@Override
	public String getConsoleTag() {
		// TODO Auto-generated method stub
		return "[Battle Royale]";
	}

}
