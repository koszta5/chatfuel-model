package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

public class SimplePayload implements Payload {
	private String url;

	public SimplePayload(String url) {
		this.url = url;
	}
}
