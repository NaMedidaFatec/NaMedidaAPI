package br.com.namedida.core.service;

import br.com.namedida.domain.form.MinioForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Component
public class MinioService {

    public void uploadFile(MinioClient minioClient,  String metadata, MultipartFile file) {
        try {
            MinioForm form = new ObjectMapper().readValue(metadata, MinioForm.class);
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(form.getBucket()).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(form.getBucket()).build());
            }
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(form.getBucket()).object(form.getObjectName()).stream(
                                    file.getInputStream(), file.getInputStream().available(), -1)
                            .contentType(file.getContentType())
                            .build());
        } catch (Exception e) {
            throw new RuntimeException("Error occurred: " + e.getMessage());
        }
    }
}
