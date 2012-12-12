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
	public String getPassword(String length) throws IOException
	{
		int passwordLength = 0;
		try
		{
			passwordLength = Integer.parseInt(length);
		}
		catch(NumberFormatException e)
		{
			return "Sorry the password length must be a digit from 6 - 24";
		}
		if (passwordLength >= 6 && passwordLength <= 24)
		{
			URL pw = new URL(
					"https://www.random.org/passwords/?num=1&len="+ passwordLength + "&format=plain&rnd=new");
			BufferedReader in = new BufferedReader(new InputStreamReader(pw
					.openStream()));
			String inputLine;
			inputLine = in.readLine();
			in.close();
			if (inputLine != null)
			{
				return inputLine + " <- Here is a " + passwordLength +" digit password from random.org!";
			}
			else
			{
				return "Sorry, something went wrong, please try again";
			}
		}
		else
		{
			return "Range is 6 - 24";
		}
	}
}
