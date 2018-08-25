package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatFuelReply {
	@JsonProperty("set_attributes")
	private Map<String, String> attributeMap = new HashMap<String, String>();
	private List<ChatFuelMessage> messages;

}
