package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;

public class ChainCensorDecoratorTest extends AbstractSocialChanneldDecoratorTest{
	
	@Test
	public void testChainCensor() {
		SocialChannel channel = new TestSpySocialChannel();
		
		SocialChannel messageTruncatorChannel = new MessageTruncator(10, channel);
		SocialChannel wordCensorChannel = new WordCensor("123", messageTruncatorChannel);
		SocialChannel urlAppenderChannel = new URLAppender("mywebsite.com", wordCensorChannel);
		
		urlAppenderChannel.deliverMessage("123 test test");
		// Spy channel. Should get the one created before
		TestSpySocialChannel spy = (TestSpySocialChannel)channel;
		assertEquals("### tes...", spy.lastMessagePublished());
	}
	
	@Test
	public void otherTestChainCensor() {
		SocialChannel channel = new TestSpySocialChannel();
		
		SocialChannel urlAppenderChannel = new URLAppender("mywebsite.com", channel);
		SocialChannel wordCensorChannel = new WordCensor("123", urlAppenderChannel);
		SocialChannel messageTruncatorChannel = new MessageTruncator(10, wordCensorChannel);
		
		messageTruncatorChannel.deliverMessage("123 test test");
		// Spy channel. Should get the one created before
		TestSpySocialChannel spy = (TestSpySocialChannel)channel;
		assertEquals("### tes... mywebsite.com", spy.lastMessagePublished());
	}
}
