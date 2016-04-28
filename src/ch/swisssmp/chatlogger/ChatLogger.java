package ch.swisssmp.chatlogger;


import java.io.File;
import java.io.IOException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatLogger extends JavaPlugin {

	public final ChatLoggerManager clm = new ChatLoggerManager(this);
	@Override
	public void onEnable() {

		
		if (!this.getDataFolder().exists())
		{
			this.getDataFolder().mkdir();
		}
		
		this.saveDefaultConfig();
		
		
		File file = new File(this.getDataFolder() + File.separator+ "ChatLog.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}


		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ChatEvent(this), this);		


	}

	@Override
	public void onDisable() {

	}

}

