package com.twitter.tests.statuses;

import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import com.twitter.tests.TwitterTestBase;

import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Tests to verify statuses/update API
 * https://dev.twitter.com/rest/reference/post/statuses/update
 * 
 * @author AnnaShevchenko
 *
 */
public class TestUpdate extends TwitterTestBase {
	private int statusCount;
	private List<Status> statuses;

	// To verify tweet post
	@Test
	public void testSuccStatusUpdate() throws TwitterException {
		statusCount = getTwitter().getUserTimeline().size();
		String expStatus = "My second tweet ;)";
		long newStatusId = getTwitter().updateStatus(expStatus).getId();
		statuses = getTwitter().getUserTimeline();
		Assert.assertEquals(statuses.size(), statusCount + 1);
		Assert.assertEquals(statuses.get(0).getText(), expStatus);
		getTwitter().destroyStatus(newStatusId);
		Assert.assertEquals(getTwitter().getUserTimeline().size(), statusCount);
	}

	// To verify duplicate status
	@Test
	public void testErrDuplicateStatus() throws TwitterException {
		String statusMessage = "Duplicate status";
		int expErrorCode = 187;
		String expErrorMessage = "Status is a duplicate.";
		long statusId = getTwitter().updateStatus(statusMessage).getId();
		try {
			getTwitter().updateStatus(statusMessage);
		} catch (TwitterException e) {
			Assert.assertEquals(e.getErrorCode(), expErrorCode);
			Assert.assertEquals(e.getErrorMessage(), expErrorMessage);
			getTwitter().destroyStatus(statusId);
		}
	}
}
