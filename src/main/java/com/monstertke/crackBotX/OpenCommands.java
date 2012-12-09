package com.monstertke.crackBotX;

import java.util.Date;

import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

@SuppressWarnings("rawtypes")
public class OpenCommands extends ListenerAdapter
{
	PircBotX bot = null;
	public OpenCommands(PircBotX botInstance)
	{
		bot = botInstance;
	}

	public void onMessage(MessageEvent event) throws Exception
	{
		if (event.getMessage().equalsIgnoreCase("!derp"))
		{

			event.respond("says derp");
			System.out.println(event.getUser().getNick()
					+ " sent the \"derp\" command on " + new Date());
		}

		if (event.getMessage().equalsIgnoreCase("!time"))
		{
 
			Date time = new Date();

			event.respond("Current time is: " + time);
			System.out.println(event.getUser().getNick()
					+ " sent the \"time\" command on " + time);
		}
		
		if (event.getMessage().equalsIgnoreCase("!owner"))
		{

			Date time = new Date();

			event.respond("The Owner of this bot is MonsterTKE");
			System.out.println(event.getUser().getNick()
					+ " sent the \"owner\" command on " + time);
		}
		
		if (event.getMessage().equalsIgnoreCase("!help"))
		{

			Date time = new Date();
			
			event.getBot().sendNotice(event.getUser(), "Commands are !help, !derp, !time, !owner, !twitter");
			
			System.out.println(event.getUser().getNick()
					+ " sent the \"help\" command on " + time);
		}

		if (event.getMessage().equalsIgnoreCase("!twitter"))
		{

			event.getBot().sendNotice(event.getUser(), "somethin somethin");
		}
	} 

}
