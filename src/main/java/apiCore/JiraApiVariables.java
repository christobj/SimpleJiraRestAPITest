package apiCore;

/**
 * @author Christob Arputharaj
 *
 */
public class JiraApiVariables {
	
	private String IssueId;
	
	private String commentId;

	/**
	 * @return the issueId
	 */
	public String getIssueId() {
		return this.IssueId;
	}

	/**
	 * @param issueId the issueId to set
	 */
	public void setIssueId(String issueId) {
		this.IssueId = issueId;
	}

	/**
	 * @return the commentId
	 */
	public String getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	

}
