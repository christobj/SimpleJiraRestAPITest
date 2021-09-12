package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import apiCore.JiraApiConstants;
import apiCore.JiraApiVariables;
import base.BaseAPI;

/**
 * @author Christob Arputharaj
 *
 */
public class LoginTest extends BaseAPI{
	
	@Test
	public void positiveTest() {
		login(JiraApiConstants.USERNAME, JiraApiConstants.PASSWORD);
		createNewIssue("For Test", "christobj", "christobj");
		editIssue(jiraApiVariables.getIssueId(), "Updated Description");
		addComment(jiraApiVariables.getIssueId(), "Comment");
		editComment(jiraApiVariables.getCommentId(), "Updated Comment");
		deleteComment(jiraApiVariables.getCommentId());
		addAttachment();
		deleteIssue(jiraApiVariables.getIssueId());
	}
	
}
