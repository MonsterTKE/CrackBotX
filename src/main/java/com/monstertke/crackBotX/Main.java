package com.monstertke.crackBotX;

import static java.lang.System.out;

public class Main
{

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		
		ConfigManager conf = new ConfigManager();
		conf.writeFileDefault();

		ConnectionFactory conn = new ConnectionFactory(conf);

		try
		{
		conn.connectNow();
		}
		catch(Exception e)
		{
			out.println("");
			out.println("Exception in \"Main\", it could be one of the following...");
			out.println("Please edit your config file, or if this is the first time CrackBotX is being run,");
			out.println("CrackBotX has just created the files it needs to run, please try again.");
		}
		
	}

}
