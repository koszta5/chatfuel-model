package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.Button;

import java.util.ArrayList;
import java.util.List;

public class GalleryImage {

	private String title;
	@JsonProperty("image_url")
	private String imageUrl;
	private String subtitle;

	private List<Button> buttons = new ArrayList<Button>();

	public void addButton(Button btn){
		this.buttons.add(btn);
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
}
