package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

public class ChatFuelGallery extends  AbstractChatFuelSimpleAttachement {
	public ChatFuelGallery() {
		this.type = "template";
		this.payload = new GalleryPayload();
	}
}
