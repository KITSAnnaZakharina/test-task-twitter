package com.twitter.tests.directmessages;

import org.junit.Test;
import org.testng.Assert;

import com.twitter.tests.TwitterTestBase;

import twitter4j.TwitterException;

/**
 * Tests to verify APIs for direct_messages APIs
 * https://dev.twitter.com/rest/reference/get/direct_messages
 * https://dev.twitter.com/rest/reference/post/direct_messages/new
 * 
 * @author AnnaShevchenko
 *
 */
public class TestDirectMessages extends TwitterTestBase {

	// To verify access my direct messages
	@Test
	public void testErrGetMyDirectMessage() throws TwitterException {
		int expErrorCode = 93;
		String expErrorMessage = "This application is not allowed to access or delete your direct messages.";
		try {
			getTwitter().getDirectMessages();
		} catch (TwitterException e) {
			Assert.assertEquals(e.getErrorCode(), expErrorCode);
			Assert.assertEquals(e.getErrorMessage(), expErrorMessage);
		}
	}

	// To verify sending messages to myself
	@Test
	public void testSuccSendMessage() throws TwitterException {
		String expMessage = "My message";
		String myName = getTwitter().getScreenName();
		getTwitter().sendDirectMessage(myName, expMessage);
	}

}
