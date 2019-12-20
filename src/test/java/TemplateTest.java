import learnreg.Template;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateTest {

	@Test
	public void testIsValidTel() {
		Template t = new Template("Hello, ${name}! You are learning ${lang}!");
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Bob");
		data.put("lang", "Java");
		assertEquals("Hello, Bob! You are learning Java!", t.render(data));
	}
}
