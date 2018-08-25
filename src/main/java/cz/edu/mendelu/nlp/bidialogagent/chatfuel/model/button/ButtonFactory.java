package cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button;

public class ButtonFactory {

	public Button getInstace(ButtonType type) {
		switch (type) {
		case WEBSITE:
			return new WebsiteViewButton();
		case POST_TO_JSON_API:
			return new JsonApiButton();
		case REDIRECT:
			return new RedirectBlockButton();
		}
		throw new RuntimeException("Unconfigured button type");
	}
}
