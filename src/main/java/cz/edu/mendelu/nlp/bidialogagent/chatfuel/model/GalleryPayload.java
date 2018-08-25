package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GalleryPayload implements Payload {
	@JsonProperty("template_type")
	private final  String templateType = "generic";

	@JsonProperty("image_aspect_ratio")
	private final  String aspectRatio = "square";
	@JsonProperty("elements")
	private List<GalleryImage> images = new ArrayList<GalleryImage>();

	public List<GalleryImage> getImages() {
		return images;
	}

	public void setImages(List<GalleryImage> images) {
		this.images = images;
	}

	public void addImage(GalleryImage image){
		this.images.add(image);
	}
}
