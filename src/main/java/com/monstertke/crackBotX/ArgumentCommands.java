package com.monstertke.crackBotX;

import java.util.Date;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
@SuppressWarnings("rawtypes")
public class ArgumentCommands extends ListenerAdapter
{
	PircBotX		bot		= null;
	ConfigManager	conf	= null;
	LoggerFactory	log		= null;

	public ArgumentCommands(PircBotX botInstance, ConfigManager configuration,
			LoggerFactory logger)
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

		if (messageString.toLowerCase().startsWith("!help"))
		{
			String[] msg = messageString.split(" ");

			if (msg.length == 2)
			{
				switch (msg[1].toLowerCase())
				{
					case "password" :
						event.getBot()
								.sendNotice(
										user,
										"The !password command calls the random.org api to provide a \"N\" digit password.");
						event.getBot()
								.sendNotice(
										user,
										"The Usage is !password (number) from 6 - 24");
						log.writeLog(user
								+ " sent the \"help password\" command on "
								+ time);
						break;
					case "owner" :
						event.getBot()
								.sendNotice(user,
										"The !owner command tells you who the owner of the bot is... durr.");
						log.writeLog(user
								+ " sent the \"help owner\" command on " + time);
						break;
					case "twitter" :
						event.getBot()
								.sendNotice(user,
										"The !twitter command does nothing at the moment.");
						log.writeLog(user
								+ " sent the \"help twitter\" command on "
								+ time);
						break;
					case "time" :
						event.getBot()
								.sendNotice(user,
										"The !time command gives you the current bot server time.");
						log.writeLog(user
								+ " sent the \"help time\" command on " + time);
						break;
					case "derp" :
						event.getBot().sendNotice(user, "Sorry the derp command doesnt do anything yet.");
						log.writeLog(user
								+ " sent the \"help derp\" command on " + time);
						break;
					default :
						event.getBot().sendNotice(user,
								"Usage is !help (command)");
						log.writeLog(user
								+ " Didnt enter a proper argument for help at "
								+ time);
				}
			}
		}
		else if (messageString.toLowerCase().startsWith("!password"))
		{
			String[] msg2 = messageString.split(" ");
			if (msg2.length == 2)
			{
				UrlGetter pass = new UrlGetter();
				event.getBot().sendNotice(event.getUser(),
						pass.getPassword(msg2[1]));
				log.writeLog(user + " sent the \"password\" command on " + time);
			}
			else
			{
				event.getBot().sendNotice(event.getUser(),
						"Usage is !password (length) range is 6 - 24");
			}
		}

	}
}
