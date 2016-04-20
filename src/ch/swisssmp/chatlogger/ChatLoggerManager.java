package ch.swisssmp.chatlogger;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;

public class ChatLoggerManager {
	
	private int nLines=0;
	private LineNumberReader lnr;
	private ChatLogger plugin;
	private Random rng = new Random();
	
//	public static ChatLoggerManager clm = new ChatLoggerManager();
	
	public ChatLoggerManager(ChatLogger chatlogger){
		
		setPlugin(chatlogger);
		try (FileReader fr = new FileReader("ChatLog.txt")){	
			
			lnr = new LineNumberReader(fr);
			String line = lnr.readLine();
			
			while (line != null){
				
				nLines++;
				line = lnr.readLine();
				
			}
			
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
			System.out.println("No Chatlog File found.\n Make sure your file is named \"ChatLog.txt\"");
		}
		
		
		
	}
	
//	public ChatLoggerManager(){
//		
//	}
	
	public LineNumberReader getReader(){
		return lnr;
	}
	
//	public static ChatLoggerManager getManager(){
//		return clm;
//	}
	
	public int getNumberOfLines(){		
		return nLines;		
	}
	
	public void setLine(int n){
		lnr.setLineNumber(n);
	}
	
	public String getLine() throws IOException{
		return lnr.readLine();
	}

	public void increaseNumberOfLinesByOne(){
		nLines++;
	}

	public ChatLogger getPlugin() {
		return plugin;
	}

	private void setPlugin(ChatLogger plugin) {
		this.plugin = plugin;
	}
	
	public int getRandomNumber(int nLines){		
		return rng.nextInt(nLines);		
	}

	public int getLineNumber() {
		return lnr.getLineNumber();
	}
	
	

}