package com.twitter.configuration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides access to all configurable parameters use to run twitter functional
 * tests
 *
 * @author AnnaShevchenko
 *
 */
public class TwitterTestsConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(TwitterTestsConfiguration.class);
	private final String defaultConfigFileInClasspath = "twitter.tests.config.properties";
	private final TwitterConfiguration twitterConfig = new TwitterConfiguration();
	private final String systemPropertyName = "twitter.tests.config";
	String configFilePath;
	Properties twitterTestsConfiguration = new Properties();

	/**
	 * Read configuration parameters from property file
	 */
	public TwitterTestsConfiguration() {
		String systemProperty = System.getProperty(systemPropertyName);
		if (systemProperty != null) {
			logger.debug("Using path to config as it is defined in system property" + systemProperty);
			configFilePath = systemProperty;
		} else {
			configFilePath = TwitterTestsConfiguration.class.getClassLoader().getResource(defaultConfigFileInClasspath)
					.getPath();
		}
		File configFile = new File(configFilePath);
		if (configFile.exists()) {
			logger.debug("Found configuration file at: " + configFilePath);
			try {
				twitterTestsConfiguration.load(FileUtils.openInputStream(configFile));
			} catch (IOException e) {
				throw new RuntimeException("Can't read file: " + configFilePath, e);
			}
		} else {
			throw new RuntimeException("Configuration file is required, but was not found at path: " + configFilePath
					+ ". Set it with env variable " + systemPropertyName);
		}

		try {
			BeanUtils.populate(twitterConfig, twitterTestsConfiguration);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException("Can't initialize configuration", e);
		}
	}

	/**
	 * @return twitter config object
	 */
	public TwitterConfiguration getTwitterConfig() {
		return twitterConfig;
	}

}
