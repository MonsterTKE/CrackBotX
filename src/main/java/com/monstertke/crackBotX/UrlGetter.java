package com.monstertke.crackBotX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlGetter
{

	public UrlGetter()
	{
		// TODO Auto-generated constructor stub
	}
	public String getPassword() throws IOException
	{
		URL pw = new URL(
				"https://www.random.org/passwords/?num=1&len=20&format=plain&rnd=new");
		BufferedReader in = new BufferedReader(new InputStreamReader(pw
				.openStream()));
		String inputLine;
		inputLine = in.readLine();
		in.close();
		if (inputLine != null)
		{
			return inputLine + " <- Here is a 20 digit PW from random.org!";
		}
		else
		{
			return "Sorry, something went wrong, please try again";
		}
	}
}
