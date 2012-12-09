package com.monstertke.crackBotX;

import static java.lang.System.out;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigManager
{

	private File file = new File("CrackBotX/config.yml");
	private Map<?, ?> cVal;

	public ConfigManager()
	{
		try
		{
			cVal = this.loadStream(file);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			out.println("Please Edit the file CrackBotX/config.yml");
			out.println("That was just created in the directory you ran the jar from.");
			out.println("Finally re-run the application.");
		}

	}

	public void writeFileDefault() throws IOException
	{
		File dir = new File("CrackBotX");

		if (!dir.isDirectory())
		{
			dir.mkdir();
		}

		if (!file.isFile())
		{
			try
			{
				BufferedWriter output = new BufferedWriter(new FileWriter(file));
				output.write("IrcServer: \'irc.esper.net\'");
				output.newLine();
				output.write("IrcBotName: \'CrackBotX\'");
				output.newLine();
				output.write("AltBotName: \'CrackBotX_alt\'");
				output.newLine();
				output.write("Nickserv_auth: \'false\'");
				output.newLine();
				output.write("NickServPassword: \'Password\'");
				output.newLine();
				output.write("IrcPort: \'6667\'");
				output.newLine();
				output.write("IrcChannel: \'#CrackBotX\'");
				output.newLine();
				output.write("IrcBotMaster: \'IrcNick\'");
				output.close();

				out.println("Creating file: ");
				out.print(file);
			}
			catch (IOException e)
			{
				out.println("Exception ");
				out.print(e);
			}
		}
		else
		{
			this.loadStream(file);
		}
	}

	private Map<?, ?> loadStream(File file) throws FileNotFoundException
	{
		InputStream input = new FileInputStream(file);
		Yaml yaml = new Yaml();
		Object data = yaml.load(input);
		Map<?, ?> map = (Map<?, ?>) data;
		// out.println(map);
		return map;
	}

	public String getServer()
	{
		String serverName = cVal.get("IrcServer").toString();
		return serverName;
	}

	public int getPort()
	{
		int portNumber = Integer.parseInt(cVal.get("IrcPort").toString());
		return portNumber;
	}

	public String getBotName()
	{
		String botName = cVal.get("IrcBotName").toString();;
		return botName;
	}
	public String getAltName()
	{
		String botName = cVal.get("AltBotName").toString();;
		return botName;
	}
	
	public String getNickPassword()
	{
		String botName = cVal.get("NickServPassword").toString();;
		return botName;
	}
	
	public String getNickAuth()
	{
		String botName = cVal.get("Nickserv_auth").toString();;
		return botName;
	}

	public String getChannel()
	{
		String channelName = cVal.get("IrcChannel").toString();
		return channelName;
	}

	public String getMasterName()
	{
		String masterName = cVal.get("IrcBotMaster").toString();
		return masterName;
	}
}
