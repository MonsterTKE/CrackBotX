package com.monstertke.crackBotX;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.exception.NickAlreadyInUseException;

//Javadoc http://site.pircbotx.googlecode.com/hg-history/1.7/apidocs/org/pircbotx/PircBotX.html
public class ConnectionFactory
{
	private ConfigManager conf;
	private static PircBotX bot;
	private LoggerFactory logger;

	public ConnectionFactory(ConfigManager configuration)
	{
		conf = configuration;
		try
		{
			logger = new LoggerFactory();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void connectNow() throws Exception
	{
		PircBotX b = new PircBotX();
		b.setVerbose(true);
		b.setAutoNickChange(true);
		b.useShutdownHook(true);
		b.getListenerManager().addListener(new OpenCommands(bot,conf,logger));
		b.getListenerManager().addListener(new PrivateCommands(bot, conf,logger));
		b.getListenerManager().addListener(new OnJoinMessage(bot,conf,logger));
		b.setName(conf.getBotName());
		try
		{
			b.connect(conf.getServer());
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IrcException e)
		{
			this.ghostAuth(b);

		}
		
		this.nickAuth(b);
		b.joinChannel(conf.getChannel());
		bot = b;
	}

	public void nickAuth(PircBotX b)
	{
		if (conf.getNickAuth().equals("true"))
		{
			b.identify(conf.getNickPassword());
			b.sendMessage(conf.getMasterName(),
					"I just checked in with NickServ.");
		}
	}
	
	public void ghostAuth(PircBotX b)
	{
		b.sendMessage("NickServ", "ghost " + conf.getBotName() + " " + conf.getNickPassword());
	}
	
	public PircBotX returnBot()
	{
		return bot;
	}
}
