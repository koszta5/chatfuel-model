package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.messages;

import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.Attachment;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelMessage;

public class ChatFuelAttachmentMessage implements ChatFuelMessage  {

	private Attachment attachment;

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public ChatFuelAttachmentMessage(Attachment attachment) {
		this.attachment = attachment;
	}
}
