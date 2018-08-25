package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

public class JsonApiButton extends Button {
	public JsonApiButton() {
		this.type = "json_plugin_url";
	}
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
