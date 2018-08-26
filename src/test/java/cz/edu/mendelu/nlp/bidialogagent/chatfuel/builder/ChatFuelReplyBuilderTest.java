package cz.edu.mendelu.nlp.bidialogagent.chatfuel.builder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.GalleryImage;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.Button;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.ButtonFactory;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.ButtonType;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.JsonApiButton;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.RedirectBlockButton;
import cz.edu.mendelu.nlp.bidialogagent.chatfuel.model.button.WebsiteViewButton;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChatFuelReplyBuilderTest {

	private ObjectMapper json = new ObjectMapper();

	@Test
	public void withText() throws JsonProcessingException {
		String text1 = "message1";
		String text2 = "message2";

		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder().withText(text1, text2);
		String equalTo = "{\n" + " \"messages\": [\n" + "   {\"text\": \""+text1+"\"},\n" + "   {\"text\": \""+text2+"\"}\n"
				+ " ]\n" + "}";
		Assertions.assertThat(json.writeValueAsString(builder.build()))
				  .isEqualToIgnoringWhitespace(equalTo);

	}

	@Test
	public void withFile() throws JsonProcessingException {
		String fileUrl = "http://localhost/myFile";
		String expectedFile = "{\n" + "  \"messages\": [\n" + "    {\n" + "      \"attachment\": {\n" + "        \"type\": \"file\",\n"
				+ "        \"payload\": {\n" + "          \"url\": \""+fileUrl+"\"\n" + "        }\n" + "      }\n"
				+ "    }\n" + "  ]\n" + "}";
		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder().withFile(fileUrl);
		Assertions.assertThat(json.writeValueAsString(builder.build())
		).isEqualToIgnoringWhitespace(expectedFile);
	}

	@Test
	public void withImage() throws JsonProcessingException {
		String imgUrl = "https://rockets.chatfuel.com/assets/welcome.png";
		String expectedImg = "{\n" + "  \"messages\": [\n" + "    {\n" + "      \"attachment\": {\n" + "        \"type\": \"image\",\n"
				+ "        \"payload\": {\n" + "          \"url\": \""+imgUrl+"\"\n" + "        }\n" + "      }\n"
				+ "    }\n" + "  ]\n" + "}";
		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder().withImage(imgUrl);
		Assertions.assertThat(json.writeValueAsString(builder.build())
		).isEqualToIgnoringWhitespace(expectedImg);
	}

	@Test
	public void withGalleryImage() throws JsonProcessingException{
		String[] images = {"https://rockets.chatfuel.com/assets/shirt.jpg", "https://rockets.chatfuel.com/assets/skirt.jpg"};
		String[] titles = {"Chatfuel Rockets Jersey", "Chatfuel Rockets Jersey2"};
		String[] subTitles = {"Size: M", "Size: L"};
		String[] buttonUrls = {"https://rockets.chatfuel.com/store", "http://google.com"};
		String[] buttonTitles = {"View Item", "View Item2"};
		ButtonFactory btnFactory = new ButtonFactory();
		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder();
		for (int i=0; i< images.length; i++){
			GalleryImage image = new GalleryImage();
			image.setImageUrl(images[i]);
			image.setSubtitle(subTitles[i]);
			image.setTitle(titles[i]);
			WebsiteViewButton btn = (WebsiteViewButton) btnFactory.getInstace(ButtonType.WEBSITE);
			btn.setUrl(buttonUrls[i]);
			btn.setTitle(buttonTitles[i]);
			image.addButton(btn);
			builder.withGalleryImage(image);
		}
		String expectedGallery = "{\"messages\":[{\"attachment\":{\"type\":\"template\",\"payload\":{\"template_type\":\"generic\",\"image_aspect_ratio\":\"square\",\"elements\":[{\"title\":\"Chatfuel Rockets Jersey\",\"subtitle\":\"Size: M\",\"buttons\":[{\"type\":\"web_url\",\"title\":\"View Item\",\"url\":\"https://rockets.chatfuel.com/store\"}],\"image_url\":\"https://rockets.chatfuel.com/assets/shirt.jpg\"},{\"title\":\"Chatfuel Rockets Jersey2\",\"subtitle\":\"Size: L\",\"buttons\":[{\"type\":\"web_url\",\"title\":\"View Item2\",\"url\":\"http://google.com\"}],\"image_url\":\"https://rockets.chatfuel.com/assets/skirt.jpg\"}]}}}]}\n";
		Assertions.assertThat(json.writeValueAsString(builder.build())
		).isEqualToIgnoringWhitespace(expectedGallery);
	}

	@Test
	public void withButtons() throws JsonProcessingException{
		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder();
		ButtonFactory factory = new ButtonFactory();
		List<Button> buttons = new ArrayList<>();
		RedirectBlockButton redirect = new RedirectBlockButton();
		redirect.setTitle("Show Block");
		redirect.addBlock("name of block");
		buttons.add(redirect);
		WebsiteViewButton viewButton = new WebsiteViewButton();
		viewButton.setUrl("https://rockets.chatfuel.com");
		viewButton.setTitle("Visit Website");
		buttons.add(viewButton);

		JsonApiButton apiButton = new JsonApiButton();
		apiButton.setUrl("https://rockets.chatfuel.com/api/welcome");
		apiButton.setTitle("Postback");
		buttons.add(apiButton);
		builder.withButtons("Hello!", buttons);
		String btnMessage = "{\"messages\":[{\"attachment\":{\"type\":\"template\",\"payload\":{\"text\":\"Hello!\",\"buttons\":[{\"type\":\"show_block\",\"title\":\"Show Block\",\"block_names\":[\"name of block\"]},{\"type\":\"web_url\",\"title\":\"Visit Website\",\"url\":\"https://rockets.chatfuel.com\"},{\"type\":\"json_plugin_url\",\"title\":\"Postback\",\"url\":\"https://rockets.chatfuel.com/api/welcome\"}],\"template_type\":\"button\"}}}]}\n";
		Assertions.assertThat(json.writeValueAsString(builder.build()))
				  .isEqualToIgnoringWhitespace(btnMessage);
	}

	@Test
	public void withRedirect() throws JsonProcessingException{
		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder();
		builder.withRedirect("Welcome message", "Default answer");
		String message = "{\n" + "  \"redirect_to_blocks\": [\"Welcome message\", \"Default answer\"]\n" + "}";
		Assertions.assertThat(json.writeValueAsString(builder.build()))
				  .isEqualToIgnoringWhitespace(message);
	}

	@Test
	public void withUserAttribute() throws JsonProcessingException {
		ChatFuelReplyBuilder builder = new ChatFuelReplyBuilder();
		builder.withUserAttribute("some attribute", "some value");
		builder.withUserAttribute("another attribute", "another value");
		String message = "{\n" + "  \"set_attributes\":\n" + "    {\n" + "      \"another attribute\": \"another value\",\n"
				+ "      \"some attribute\": \"some value\"\n" + "    }}";
		Assertions.assertThat(json.writeValueAsString(builder.build()))
				  .isEqualToIgnoringWhitespace(message);
	}
}