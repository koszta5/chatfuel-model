package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;


public class ChatFuelFileAttachment extends AbstractChatFuelSimpleAttachement implements Attachment {
	public ChatFuelFileAttachment(){
		this.type = "file";
	}
}
