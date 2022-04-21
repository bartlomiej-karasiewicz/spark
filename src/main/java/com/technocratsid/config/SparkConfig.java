package com.technocratsid.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

	@Value("${spark.app.name}")
	private String appName;
	@Value("${spark.master}")
	private String masterUri;
//	@Value("${spark.home}")
//	private String sparkHome;

	@Bean
	public SparkConf sparkConf() {
		SparkConf sparkConf = new SparkConf()
						.setAppName(appName)
//						.setSparkHome(sparkHome)
						.setMaster(masterUri)
						.set("spark.cores.max", "12")
						.set("spark.shuffle.service.enabled","true");

		return sparkConf;
	}

	@Bean
	public JavaSparkContext javaSparkContext() {
		return new JavaSparkContext(sparkConf());
	}

}
