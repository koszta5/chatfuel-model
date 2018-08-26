package cz.edu.mendelu.nlp.bidialogagent.chatfuel.builder;

import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelFileAttachment;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelGallery;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelImage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelMessage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelReply;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelText;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatfuelButtonMessage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.GalleryImage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.GalleryPayload;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.SimplePayload;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.Button;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.messages.ChatFuelAttachmentMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO - disallow creation of invalid messages - throw exceptions
public class ChatFuelReplyBuilder {

	private List<ChatFuelMessage> messagesToSend = new ArrayList<ChatFuelMessage>();
	private List<String> redirects = new ArrayList<String>();
	private Map<String, String> attributes = new HashMap<>();
	private ChatFuelGallery gallery;

	public ChatFuelReplyBuilder withText(String... textsToSend) {
		for (String text : textsToSend) {
			ChatFuelText textObj = new ChatFuelText();
			textObj.setText(text);
			messagesToSend.add(textObj);
		}
		return this;
	}

	public ChatFuelReplyBuilder withFile(String urlToFile) {
		ChatFuelFileAttachment chFile = new ChatFuelFileAttachment();
		chFile.setPayload(new SimplePayload(urlToFile));
		messagesToSend.add(new ChatFuelAttachmentMessage(chFile));
		return this;
	}

	public ChatFuelReplyBuilder withImage(String urlToFile) {
		ChatFuelImage chImg = new ChatFuelImage();
		chImg.setPayload(new SimplePayload(urlToFile));
		messagesToSend.add(new ChatFuelAttachmentMessage(chImg));
		return this;
	}

	public ChatFuelReplyBuilder withGalleryImage(GalleryImage... image) {
		if (gallery == null) {
			gallery = new ChatFuelGallery();
			gallery.setPayload(new GalleryPayload());
			messagesToSend.add(new ChatFuelAttachmentMessage(gallery));
		}
		for (GalleryImage img : image) {
			gallery.addImage(img);
		}

		return this;
	}

	public ChatFuelReplyBuilder withButtons(String descTitle, List<Button> buttons) {
		ChatfuelButtonMessage btnMessage = new ChatfuelButtonMessage();
		btnMessage.setText(descTitle);
		buttons.stream()
			   .forEach(btnMessage::addButton);
		messagesToSend.add(btnMessage);
		return this;
	}

	public ChatFuelReplyBuilder withRedirect(String... blockNames) {
		for (String block : blockNames) {
			redirects.add(block);
		}
		return this;
	}

	public ChatFuelReplyBuilder withUserAttribute(String attributeName, String attributeValue) {
		this.attributes.put(attributeName, attributeValue);
		return this;
	}

	public ChatFuelReply build() {
		ChatFuelReply reply = new ChatFuelReply();
		reply.setAttributeMap(attributes);
		reply.setMessages(messagesToSend);
		reply.setRedirectToBlocks(redirects);
		return reply;
	}

}
