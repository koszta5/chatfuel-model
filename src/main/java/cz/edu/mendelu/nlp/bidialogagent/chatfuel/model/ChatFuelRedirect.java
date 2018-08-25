package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ChatFuelRedirect implements ChatFuelMessage {
	@JsonProperty("redirect_to_blocks")
	private List<String> redirectToBlocks = new ArrayList<>();

	public void addRedirect(String blockName){
		redirectToBlocks.add(blockName);
	}
}
