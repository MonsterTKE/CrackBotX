package com.monstertke.crackBotX;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LoggerFactory
{
	static PrintWriter file;
	
	public LoggerFactory() throws FileNotFoundException
	{
		file = new PrintWriter("CrackBotX/log.txt");
		
	}
	
	public void writeLog(String message)
	{
		file.println(message);
		file.flush();
	}
	
	public void closeLog()
	{
		file.close();
	}
}
