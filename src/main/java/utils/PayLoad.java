package utils;

import apiCore.JiraApiConstants;

/**
 * @author Christob Arputharaj
 *
 */
public class PayLoad {
	
	public static String getLoginPayLoad(String userName, String password) {
		return "{\r\n"
				+ "    \"username\": \"" +userName +"\",\r\n"
				+ "    \"password\": \"" +password +"\"\r\n"
				+ "}";
	}
	
	public static String getCreateIssuePayLoad(String summary, String assignee, String reporter) {
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"id\": \"" +JiraApiConstants.PROJECT_ID +"\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"" +summary +"\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"id\": \"" +JiraApiConstants.ISSUETYPE_TASK +"\"\r\n"
				+ "        },\r\n"
				+ "        \"assignee\": {\r\n"
				+ "            \"name\": \"" +assignee +"\"\r\n"
				+ "        },\r\n"
				+ "        \"reporter\": {\r\n"
				+ "            \"name\": \"" +reporter +"\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
	}
	
	public static String getEditIssuePayload(String description) {
		return "{\r\n"
				+ "      \"fields\": {\r\n"
				+ "        \"description\": \"" +description +"\"\r\n"
				+ "            }\r\n"
				+ "    \r\n"
				+ "}";
	}
	
	public static String getCommentPayload(String comment) {
		return "{\r\n"
				+ "    \"body\": \"" +comment +"\"\r\n"
				+ "}";
	}

}
