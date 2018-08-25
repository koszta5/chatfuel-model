package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RedirectBlockButton extends Button {
	public RedirectBlockButton() {
		this.type = "show_block";
	}

	private String title;
	@JsonProperty("block_names")
	private List<String> blockNames;



}
