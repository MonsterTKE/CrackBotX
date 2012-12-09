package com.monstertke.crackBotX;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;

@SuppressWarnings("rawtypes")
public class OnJoinMessage extends ListenerAdapter
{
	PircBotX bot = null;
	ConfigManager conf = null;
	LoggerFactory log = null;

	public OnJoinMessage(PircBotX botInstance, ConfigManager configuration, LoggerFactory logger)
	{
		bot = botInstance;
		conf = configuration;
		log = logger;
	}

	public void onJoin(JoinEvent event)
	{
		
		event.getBot().sendNotice(event.getUser(), "Hey there " + event.getUser().getNick()
				+ " Type !help to get a list of commands that I can execute!");
	}
}
