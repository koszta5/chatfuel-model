package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RedirectBlockButton extends Button {
	public RedirectBlockButton() {
		this.type = "show_block";
	}
	public RedirectBlockButton(String block){
		this.addBlock(block);
	}

	@JsonProperty("block_names")
	private List<String> blockNames = new ArrayList<>();

	public void addBlock(String blockName){
		blockNames.add(blockName);
	}



}
