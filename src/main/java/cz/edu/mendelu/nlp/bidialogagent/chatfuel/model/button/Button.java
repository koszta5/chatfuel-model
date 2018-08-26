package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

public abstract class Button {
	protected String type;
	protected String title;

	public String getType() {
		return type;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
