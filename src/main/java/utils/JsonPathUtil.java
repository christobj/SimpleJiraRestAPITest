package utils;
import io.restassured.path.json.JsonPath;

/**
 * @author Christob Arputharaj
 *
 */
public class JsonPathUtil {
	
	public static String JsonPathCommon(String response, String key) {
		JsonPath path = new JsonPath(response);
		return path.get(key);
	}

}
