package learnreg;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author liaoxuefeng
 */
public class Template {

	final String template;
	final Pattern pattern = Pattern.compile("\\$\\{(\\w+)}");

	public Template(String template) {
		this.template = template;
	}

	public String render(Map<String, Object> data) {
		Matcher m = pattern.matcher(template);
		// TODO:
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, (String) data.get(m.group(1)));
		}
		m.appendTail(sb);
		return sb.toString();
	}

}
