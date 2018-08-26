package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model;

public class SimplePayload implements Payload {
	private String url;

	public SimplePayload(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
