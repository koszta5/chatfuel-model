package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

public class ChatFuelText implements ChatFuelMessage {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
