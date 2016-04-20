package ch.swisssmp.chatlogger;

import java.io.BufferedWriter;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;








import org.bukkit.entity.Player;
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


		Player player = event.getPlayer();

		String message = event.getMessage();



		//		PrintWriter writer;
		try(FileWriter fw = new FileWriter("ChatLog.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
				{
			if (!message.toLowerCase().contains("steve")){
				out.println(/*player.getName() + ": " + */ message);
				plugin.clm.increaseNumberOfLinesByOne();
			}
			else{

				int n = plugin.clm.getNumberOfLines();
				int currentLineNumber = plugin.clm.getRandomNumber(n);
				plugin.clm.setLine(currentLineNumber);
				//				message = plugin.clm.getLine();

				new BukkitRunnable() {

					@Override
					public void run() {

						String SayBack;
						try {
							SayBack = " " + currentLineNumber + "," + plugin.clm.getLineNumber()+ "," + plugin.clm.getLine();
							player.sendMessage(SayBack);
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
