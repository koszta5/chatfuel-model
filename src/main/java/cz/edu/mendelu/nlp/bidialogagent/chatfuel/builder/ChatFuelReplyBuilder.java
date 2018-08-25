package cz.edu.mendelu.nlp.bidialogagent.chatfuel.builder;

import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelFile;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelGallery;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelImage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelMessage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelRedirect;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelText;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.GalleryImage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.GalleryPayload;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.SimplePayload;

import java.util.ArrayList;
import java.util.List;

//TODO - disallow creation of invalid messages - throw exceptions
public class ChatFuelReplyBuilder {

	private List<ChatFuelMessage> messagesToSend = new ArrayList<ChatFuelMessage>();
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
		ChatFuelFile chFile = new ChatFuelFile();
		chFile.setPayload(new SimplePayload(urlToFile));
		return this;
	}

	public ChatFuelReplyBuilder withImage(String urlToFile) {
		ChatFuelImage chFile = new ChatFuelImage();
		chFile.setPayload(new SimplePayload(urlToFile));
		return this;
	}

	public ChatFuelReplyBuilder withGalleryImage(GalleryImage... image) {
		if (gallery == null) {
			gallery = new ChatFuelGallery();
			gallery.setPayload(new GalleryPayload());
			messagesToSend.add(gallery);
		} else {
			for (GalleryImage img : image) {
				gallery.addImage(img);
			}
		}
		return this;
	}

	public ChatFuelReplyBuilder withRedirect(String... blockNames) {
		ChatFuelRedirect redirect = new ChatFuelRedirect();
		for (String block : blockNames) {
			redirect.addRedirect(block);
		}
		messagesToSend.add(redirect);
		return this;
	}

}
