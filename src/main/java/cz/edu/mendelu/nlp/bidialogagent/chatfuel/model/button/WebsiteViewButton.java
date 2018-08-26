package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

public class WebsiteViewButton extends Button {
	public WebsiteViewButton() {
		this.type = "web_url";
	}
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
