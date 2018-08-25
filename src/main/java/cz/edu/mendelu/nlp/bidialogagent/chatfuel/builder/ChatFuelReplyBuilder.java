package cz.edu.mendelu.nlp.bidialogagent.chatfuel.builder;

import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelFile;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelImage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelMessage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.ChatFuelText;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.SimplePayload;

import java.util.ArrayList;
import java.util.List;
//TODO - disallow creation of invalid messages - throw exceptions
public class ChatFuelReplyBuilder {

	private List<ChatFuelMessage> messagesToSend = new ArrayList<ChatFuelMessage>();

	public ChatFuelReplyBuilder withText(String ... textsToSend){
		for (String text : textsToSend){
			ChatFuelText textObj = new ChatFuelText();
			textObj.setText(text);
			messagesToSend.add(textObj);
		}
		return this;
	}

	public ChatFuelReplyBuilder withFile(String urlToFile){
		ChatFuelFile chFile = new ChatFuelFile();
		chFile.setPayload(new SimplePayload(urlToFile));
		return this;
	}

	public ChatFuelReplyBuilder withImage(String urlToFile){
		ChatFuelImage chFile = new ChatFuelImage();
		chFile.setPayload(new SimplePayload(urlToFile));
		return this;
	}


}
