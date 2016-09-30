package com.twitter.configuration;
/**
 * Configuration parameters
 *
 * @author AnnaShevchenko
 *
 */
public class TwitterConfiguration {
	String twitterUrl;
	String twitterUser;
	String twitterPassword;
	String oauthConsumerKey;
	String oauthConsumerSecret;
	String oauthAccessToken;
	String oauthAcessTokenSecret;

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getTwitterUser() {
		return twitterUser;
	}

	public void setTwitterUser(String twitterUser) {
		this.twitterUser = twitterUser;
	}

	public String getTwitterPassword() {
		return twitterPassword;
	}

	public void setTwitterPassword(String twitterPassword) {
		this.twitterPassword = twitterPassword;
	}

	public String getOauthConsumerKey() {
		return oauthConsumerKey;
	}

	public void setOauthConsumerKey(String oauthConsumerKey) {
		this.oauthConsumerKey = oauthConsumerKey;
	}

	public String getOauthConsumerSecret() {
		return oauthConsumerSecret;
	}

	public void setOauthConsumerSecret(String oauthConsumerSecret) {
		this.oauthConsumerSecret = oauthConsumerSecret;
	}

	public String getOauthAccessToken() {
		return oauthAccessToken;
	}

	public void setOauthAccessToken(String oauthAccessToken) {
		this.oauthAccessToken = oauthAccessToken;
	}

	public String getOauthAcessTokenSecret() {
		return oauthAcessTokenSecret;
	}

	public void setOauthAcessTokenSecret(String oauthAcessTokenSecret) {
		this.oauthAcessTokenSecret = oauthAcessTokenSecret;
	}

}
