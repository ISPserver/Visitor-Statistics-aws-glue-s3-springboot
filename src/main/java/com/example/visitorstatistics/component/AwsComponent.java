package com.example.visitorstatistics.component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

@Slf4j
@Builder
public class AwsComponent {

    private Environment environment;
    private String bucketName;
    private AmazonS3 amazonS3;
    private String accessKey;
    private String secretKey;

    public void saveToFile(String path, String content) {
        log.info("save file path : {}", path);
        try {
            amazonS3.putObject(bucketName, path, content);
        } catch (AmazonS3Exception e) {
            log.error("save file error : path[{}], message[{}]", path, e.getMessage());
            throw e;
        }

    }
}
