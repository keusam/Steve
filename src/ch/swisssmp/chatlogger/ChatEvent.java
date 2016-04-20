package ch.swisssmp.chatlogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatEvent implements Listener{


	static ChatLogger plugin;

	public ChatEvent(ChatLogger plugin){
		ChatEvent.plugin = plugin;
	}

	
	@EventHandler
	public void onChatEvent(AsyncPlayerChatEvent event){

		String message = event.getMessage();

		try(FileWriter fw = new FileWriter("ChatLog.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
				{
			if (!message.toLowerCase().contains("steve")){
				out.println(message);
				plugin.clm.increaseNumberOfLinesByOne();
			}
			else{

				int n = plugin.clm.getNumberOfLines();
				int currentLineNumber = plugin.clm.getRandomNumber(n);			

				new BukkitRunnable() {

					@Override
					public void run() {

						String SayBack;
						try {
							SayBack =  "["+ChatColor.GRAY +"Steve"+ChatColor.WHITE +"] "  + plugin.clm.getLineNumberN(currentLineNumber);
							plugin.getServer().broadcastMessage(SayBack);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}

				}.runTaskLater(this.plugin, 20);

			}
				} catch (IOException e) {
					//exception handling left as an exercise for the reader
				}

	}


}
