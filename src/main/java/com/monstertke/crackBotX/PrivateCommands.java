package com.monstertke.crackBotX;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class PrivateCommands extends ListenerAdapter
{
	PircBotX		bot		= null;
	ConfigManager	conf	= null;
	LoggerFactory	log		= null;

	public PrivateCommands(PircBotX botInstance, ConfigManager configuration,
			LoggerFactory logger)
	{
		bot = botInstance;
		conf = configuration;
		log = logger;
	}

	public void onPrivateMessage(PrivateMessageEvent event) throws Exception
	{
		String botMaster = conf.getMasterName();

		if (event.getUser().getNick().equals(botMaster))
		{
			String messageString = event.getMessage();
			switch (messageString.toLowerCase())
			{
				case "!activate" :
					event.respond("Hey-O!");
					break;
				case "!help" :
					event.respond("Commands are, !activate, !shutdown, !gc and !help");
					break;
				case "!shutdown" :
					event.respond("Goodbye!");
					log.closeLog();
					event.getBot().shutdown();
					System.exit(1);
					break;
				case "!cg" :
					System.gc();
					break;
				default :
					event.respond("That wasnt a valid command, !help for help");
					break;
			}

		}
		else
		{
			event.respond("You dont own Me!!!");
		}
	}
}
