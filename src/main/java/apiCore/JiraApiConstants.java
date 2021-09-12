package apiCore;

import io.restassured.filter.session.SessionFilter;

/**
 * @author Christob Arputharaj
 *
 */
public class JiraApiConstants {
	
	private static final String BASE_URI = "http://localhost:8080";
	
	private static final String CONTENT_TYPE_JSON = "application/json";
	
	public static final String CONTENT_TYPE = "Content-Type";
	
	public static final String CONTENT_TYPE_ATTACHMENT = "X-Atlassian-Token";
	
	public static final String CONTENT_TYPE_NO_CHECK = "no-check";
	
	private static final String LOGIN_PATH = "/rest/auth/1/session";
	
	public static final int STATUS_CODE_200 = 200;
	
	public static final int STATUS_CODE_201 = 201;
	
	public static final int STATUS_CODE_204 = 204;
	
	public static final String USERNAME = "christobj";
	
	public static final String PASSWORD = "admin";
	
	public static final String PROJECT_ID = "10100";
	
	public static final String ISSUETYPE_TASK = "10003";
	
	private static final String ISSUE_PATH = "/rest/api/2/issue";
	
	public static final String ISSUE_ID = "ISSUE_ID";
	
	public static final String COMMENT_ID = "COMMENT_ID";
	
	public static final String COMMENT = "comment";
	
	public static final String ATTACHMENT = "attachments";
	
	public static String getURI() {
		return BASE_URI;
	}
	
	public static String getContentTypeJSON() {
		return CONTENT_TYPE_JSON;
	}
	
	public static String getLoginPath() {
		return LOGIN_PATH;
	}
	
	public static String getIssuePath() {
		return ISSUE_PATH;
	}
}
