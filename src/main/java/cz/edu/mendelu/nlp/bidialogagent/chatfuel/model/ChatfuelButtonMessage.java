package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.Button;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.ButtonAttachment;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.ButtonPayload;

public class ChatfuelButtonMessage implements ChatFuelMessage {

	private ButtonAttachment attachment = new ButtonAttachment();

	public ButtonAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(ButtonAttachment attachment) {
		this.attachment = attachment;
	}

	public void setText(String text){
		((ButtonPayload) this.attachment.getPayload()).setText(text);
	}
	public void addButton(Button btn){
		((ButtonPayload) this.attachment.getPayload()).getButtons().add(btn);
	}


}
