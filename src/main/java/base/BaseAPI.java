package base;

import apiCore.JiraApiConstants;
import apiCore.JiraApiVariables;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import utils.JsonPathUtil;
import utils.PayLoad;

import static io.restassured.RestAssured.*;

import java.io.File;

/**
 * @author Christob Arputharaj
 *
 */
public class BaseAPI {
	
	SessionFilter sessionFilter;
	protected JiraApiVariables jiraApiVariables;
	
	public BaseAPI() {
		RestAssured.baseURI = JiraApiConstants.getURI();
		sessionFilter = new SessionFilter();
		jiraApiVariables = new JiraApiVariables();
	}
	
	public void login(String userName, String password) {
		given().log().all().headers(JiraApiConstants.CONTENT_TYPE, JiraApiConstants.getContentTypeJSON())
			.filter(sessionFilter).body(PayLoad.getLoginPayLoad(userName, password))
			.when().post(JiraApiConstants.getLoginPath())
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_200);
	}
	
	public void createNewIssue(String summary, String assignee, String reporter) {
		String response = given().log().all().header(JiraApiConstants.CONTENT_TYPE, JiraApiConstants.getContentTypeJSON())
			.filter(sessionFilter).body(PayLoad.getCreateIssuePayLoad(summary, assignee, reporter))
			.when().post(JiraApiConstants.getIssuePath())
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_201).extract().response().asString();
		jiraApiVariables.setIssueId(JsonPathUtil.JsonPathCommon(response, "id"));
	}
	
	public void editIssue(String issueId, String description) {
		given().log().all().header(JiraApiConstants.CONTENT_TYPE, JiraApiConstants.getContentTypeJSON())
			.filter(sessionFilter).body(PayLoad.getEditIssuePayload(description)).pathParam(JiraApiConstants.ISSUE_ID, issueId)
			.when().put(JiraApiConstants.getIssuePath()+"/{"+JiraApiConstants.ISSUE_ID+"}")
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_204);
	}
	
	public void deleteIssue(String issueId) {
		given().log().all().filter(sessionFilter).pathParam(JiraApiConstants.ISSUE_ID, issueId)
			.when().delete(JiraApiConstants.getIssuePath()+"/{"+JiraApiConstants.ISSUE_ID+"}")
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_204);
	}
	
	public void addComment(String issueId, String comment) {
		String response = given().log().all().header(JiraApiConstants.CONTENT_TYPE, JiraApiConstants.getContentTypeJSON())
			.filter(sessionFilter).body(PayLoad.getCommentPayload(comment)).pathParam(JiraApiConstants.ISSUE_ID, issueId)
			.when().post(JiraApiConstants.getIssuePath()+"/{"+JiraApiConstants.ISSUE_ID +"}/"+JiraApiConstants.COMMENT)
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_201).extract().response().asString();
		jiraApiVariables.setCommentId(JsonPathUtil.JsonPathCommon(response, "id"));
	}
	
	public void editComment(String commentId, String comment) {
		given().log().all().header(JiraApiConstants.CONTENT_TYPE, JiraApiConstants.getContentTypeJSON())
			.filter(sessionFilter).body(PayLoad.getCommentPayload(comment)).pathParam(JiraApiConstants.ISSUE_ID, jiraApiVariables.getIssueId())
			.pathParam(JiraApiConstants.COMMENT_ID, commentId)
			.when().put(JiraApiConstants.getIssuePath()+"/{"+JiraApiConstants.ISSUE_ID +"}/"+JiraApiConstants.COMMENT +"/{" +JiraApiConstants.COMMENT_ID +"}")
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_200);
	}
	
	public void deleteComment(String commentId) {
		given().log().all().filter(sessionFilter).pathParam(JiraApiConstants.ISSUE_ID, jiraApiVariables.getIssueId())
			.pathParam(JiraApiConstants.COMMENT_ID, commentId)
			.when().delete(JiraApiConstants.getIssuePath()+"/{"+JiraApiConstants.ISSUE_ID +"}/"+JiraApiConstants.COMMENT +"/{" +JiraApiConstants.COMMENT_ID +"}")
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_204);
	}
	
	public void addAttachment() {
		given().log().all().filter(sessionFilter).pathParam(JiraApiConstants.ISSUE_ID, jiraApiVariables.getIssueId())
			.header(JiraApiConstants.CONTENT_TYPE_ATTACHMENT, JiraApiConstants.CONTENT_TYPE_NO_CHECK)
			.multiPart(new File("text.txt"))
			.when().post(JiraApiConstants.getIssuePath()+"/{"+JiraApiConstants.ISSUE_ID+"}/" +JiraApiConstants.ATTACHMENT)
			.then().log().all().assertThat().statusCode(JiraApiConstants.STATUS_CODE_200);
	}

}
