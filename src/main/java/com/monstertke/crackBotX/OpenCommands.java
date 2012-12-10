package com.monstertke.crackBotX;

import java.io.FileNotFoundException;
import java.util.Date;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class OpenCommands extends ListenerAdapter
{
	PircBotX bot = null;
	ConfigManager conf = null;
	LoggerFactory log = null;
	
	public OpenCommands(PircBotX botInstance, ConfigManager configuration, LoggerFactory logger)
	{
		bot = botInstance;
		conf = configuration;
		log = logger;
	}

	public void onMessage(MessageEvent event) throws Exception
	{
		String messageString = event.getMessage();
		String user = event.getUser().getNick();
		Date time = new Date();
		switch(messageString.toLowerCase())
		{
			case "!derp":
				event.respond("says derp");
				log.writeLog(user + " sent the \"derp\" command on " + time);
				break;
			case "!time":
				event.respond("Current bot server time is: " + time);
				log.writeLog(user + " sent the \"time\" command on " + time);
				break;
			case "!owner":
				event.respond("The Owner of this bot is MonsterTKE");
				log.writeLog(user + " sent the \"time\" command on " + time);
				break;
			case "!help":
				event.getBot().sendNotice(event.getUser(), "Commands are !help, !derp, !time, !owner, !twitter");
				log.writeLog(user + " sent the \"help\" command on " + new Date());
				break;
			case "!twitter":
				event.getBot().sendNotice(event.getUser(), "somethin somethin");
				break;
			default:
				//ToDO
				break;
		}
	} 

}
