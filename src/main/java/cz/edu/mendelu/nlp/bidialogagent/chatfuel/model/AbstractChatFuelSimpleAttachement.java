package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

public class AbstractChatFuelSimpleAttachement implements Attachment {
	protected String type;
	protected Payload payload;

	public String getType() {
		return type;
	}


	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}
}
