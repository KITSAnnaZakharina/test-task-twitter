package com.twitter.tests.statuses;

import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import com.twitter.tests.TwitterTestBase;

import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Tests to verify statuses/user_timeline API
 * https://dev.twitter.com/rest/reference/get/statuses/user_timeline
 * 
 * @author AnnaShevchenko
 *
 */
public class TestUserTimeline extends TwitterTestBase {

	// To verify status for Test User with correct credentials
	@Test
	public void testSuccUserStatusCorrectCredentials() throws TwitterException {
		int expStatusCount = 1;
		String expStatus = "My first tweet ;)";
		List<Status> statuses = getTwitter().getUserTimeline();
		Assert.assertEquals(statuses.size(), expStatusCount);
		Assert.assertEquals(statuses.get(0).getText(), expStatus);
	}

	// To verify status for non-existing page
	@Test
	public void testErrNonExistingPage() throws TwitterException {
		int expErrorCode = 34;
		String expErrorMessage = "Sorry, that page does not exist.";
		try {
			getTwitter().getUserTimeline("sdfdyewte4tserysud56");
		} catch (TwitterException e) {
			Assert.assertEquals(e.getErrorCode(), expErrorCode);
			Assert.assertEquals(e.getErrorMessage(), expErrorMessage);
		}
	}
}
