package com.example.visitorstatistics.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.example.visitorstatistics.component.AwsComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class AwsConfig {

    private final Environment environment;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-access-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    public AwsComponent amazonS3Client() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSStaticCredentialsProvider staticCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
        return AwsComponent
                .builder()
                .bucketName(bucket)
                .environment(environment)
                .accessKey(accessKey)
                .secretKey(secretKey)
                .amazonS3(
                        AmazonS3ClientBuilder
                                .standard()
                                .withRegion(region)
                                .enablePathStyleAccess()
                                .withCredentials(staticCredentialsProvider)
                                .build())
                .build();
    }
}
