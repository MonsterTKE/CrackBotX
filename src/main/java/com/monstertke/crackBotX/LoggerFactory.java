package com.monstertke.crackBotX;

import java.io.IOException;

import jline.console.*;
public class LoggerFactory
{
	ConnectionFactory conn;
	
	public LoggerFactory(ConnectionFactory connection)
	{
		conn = connection;
		
	}
	
	public void printObject() throws IOException
	{
		System.out.println(conn.returnBot().toString());
		ConsoleReader r = new ConsoleReader();
	}
}
