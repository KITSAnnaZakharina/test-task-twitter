package com.twitter.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twitter.configuration.TwitterTestsConfiguration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Twitter test base class. All tests should extend this.
 *
 * @author AnnaShevchenko
 */
public class TwitterTestBase {
	private static final Logger logger = LoggerFactory.getLogger(TwitterTestBase.class);
	private static final TwitterTestsConfiguration config = new TwitterTestsConfiguration();
	private static TwitterFactory twitterFactory;

	public TwitterTestBase() {
		setupAuth(getDefaultConfig());
	}

	/** 
	 * Set up default configuration from config property file
	 * @return {ConfigurationBuilder} default configuration
	 */
	private ConfigurationBuilder getDefaultConfig() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(config.getTwitterConfig().getOauthConsumerKey())
				.setOAuthConsumerSecret(config.getTwitterConfig().getOauthConsumerSecret())
				.setOAuthAccessToken(config.getTwitterConfig().getOauthAccessToken())
				.setOAuthAccessTokenSecret(config.getTwitterConfig().getOauthAcessTokenSecret())
				.setPassword(config.getTwitterConfig().getTwitterPassword())
				.setUser(config.getTwitterConfig().getTwitterUser());
		return cb;
	}

	/**
	 * Set up authorization
	 * @param cb {ConfigurationBuilder} onfiguration
	 */
	private void setupAuth(ConfigurationBuilder cb) {
		twitterFactory = new TwitterFactory(cb.build());
		logger.info("Setup configuration: user[" + config.getTwitterConfig().getTwitterUser() + "] and password["
				+ config.getTwitterConfig().getTwitterPassword() + "]");
	}

	/**
	 * Get instance of twitter factory
	 * @return {Twitter} twitter instance
	 */
	public Twitter getTwitter() {
		return twitterFactory.getInstance();
	}

}
