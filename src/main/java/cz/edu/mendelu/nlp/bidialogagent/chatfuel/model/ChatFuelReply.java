package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatFuelReply {
	@JsonProperty("set_attributes")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> attributeMap = new HashMap<String, String>();
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ChatFuelMessage> messages;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonProperty("redirect_to_blocks")
	private List<String> redirectToBlocks = new ArrayList<>();

	public Map<String, String> getAttributeMap() {
		return attributeMap;
	}

	public void setAttributeMap(Map<String, String> attributeMap) {
		this.attributeMap = attributeMap;
	}

	public List<ChatFuelMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ChatFuelMessage> messages) {
		this.messages = messages;
	}

	public List<String> getRedirectToBlocks() {
		return redirectToBlocks;
	}

	public void setRedirectToBlocks(List<String> redirectToBlocks) {
		this.redirectToBlocks = redirectToBlocks;
	}
}
