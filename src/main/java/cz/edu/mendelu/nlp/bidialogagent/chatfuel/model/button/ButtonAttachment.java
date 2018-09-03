package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.AbstractChatFuelSimpleAttachement;

public class ButtonAttachment extends AbstractChatFuelSimpleAttachement {
	public ButtonAttachment() {
		this.type = "template";
		this.payload = new ButtonPayload();
	}



}
