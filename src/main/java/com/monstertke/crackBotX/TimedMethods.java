package com.monstertke.crackBotX;

import java.util.Random;

import org.pircbotx.Channel;
import org.pircbotx.PircBotX;
import static java.lang.System.out;

public class TimedMethods
{
	PircBotX bot = null;
	Channel target = null;
	public TimedMethods(PircBotX b, Channel channel)
	{
		this.bot = b;
		this.target = channel;
	}
	
	public void sendMessage()
	{
		Random time = new Random();
		int rnd = time.nextInt(20000);
		boolean coin = time.nextBoolean();
		out.println(coin);
		out.println(rnd);
		if(coin)
		{
		try
		{
			Thread.sleep(rnd);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bot.sendMessage(target, this.randomTalk());
		}
	}
	
	public String randomTalk()
	{
		String[] responses = new String[25];
		responses[0] = "I wonder what time it is?";
		responses[1] = "How many cats does derp have?";
		responses[2] = "I'm hungry.";
		responses[3] = "How many toes am I supposed to have?";
		responses[4] = "I think Glitter is awesome. But not too awesome.";
		responses[5] = "Does anyone have a ham sandwich?";
		responses[6] = "Can I ask a serious question?";
		responses[7] = "I wish I remembered where I left my keys...";
		responses[8] = "What kind of person asks for a lightbulb?";
		responses[9] = "Ha. I skinned my knee once.";
		responses[10] = "If I could be any super hero it would probably be Aquaman.";
		responses[11] = "I really really like bread.";
		responses[12] = "What is a group of Unicorns called?";
		responses[13] = "Wait a minute... Im a bot?";
		responses[14] = "I dont want to.";
		responses[15] = "Now what?";
		responses[16] = "Disco duck";
		responses[17] = "Who likes Metallica?";
		responses[18] = "I had a furby once.";
		responses[19] = "Who wants to hear a joke?";
		responses[21] = "Can anyone else hear that?";
		responses[22] = "OMG A SPIDER JUST LANDED ON MY HAND!";
		responses[23] = "My handwriting is horrible.";
		responses[24] = "Someone should do something about that.";
		
		Random gen = new Random();
		int rnd = gen.nextInt(responses.length);
		return responses[rnd];
	}
}
