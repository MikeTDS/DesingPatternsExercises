package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator {
	
	private String toCensor;
	
	public WordCensor(String toCensor) {
		this.toCensor=toCensor;
	}
	public WordCensor(String toCensor, SocialChannel channel) {
		this.toCensor=toCensor;
		this.delegate=channel;
	}

	@Override
	public void deliverMessage(String message) {
		String toDeliver = message.replaceAll(toCensor, "###");	
		delegate.deliverMessage(toDeliver);
	}
	
}
