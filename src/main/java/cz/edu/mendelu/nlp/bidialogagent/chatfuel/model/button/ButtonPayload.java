package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ButtonPayload implements cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.Payload {
	@JsonProperty("template_type")
	private final String templateType = "button";

	private String text;
	private List<Button> buttons = new ArrayList<>();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
}
