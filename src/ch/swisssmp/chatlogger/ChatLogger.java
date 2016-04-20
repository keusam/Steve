package ch.swisssmp.chatlogger;


import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatLogger extends JavaPlugin {

	public final ChatLoggerManager clm = new ChatLoggerManager(this);
	@Override
	public void onEnable() {



		        
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new ChatEvent(this), this);		
		
		
	}

	@Override
	public void onDisable() {

	}

}
