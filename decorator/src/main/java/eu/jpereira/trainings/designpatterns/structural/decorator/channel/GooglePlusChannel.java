package eu.jpereira.trainings.designpatterns.structural.decorator.channel;

public class GooglePlusChannel implements SocialChannel {

	public static final String NAME = "googleplus";

	@Override
	public void deliverMessage(String string) {
		System.out.println("GooglePlus: " + string);

	}

}
