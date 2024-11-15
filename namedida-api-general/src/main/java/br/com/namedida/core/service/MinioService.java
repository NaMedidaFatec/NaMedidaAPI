package br.com.namedida.core.service;

import br.com.namedida.core.service.security.util.MinioUtil;
import br.com.namedida.domain.form.MinioForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.minio.*;
import lombok.SneakyThrows;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Component
public class MinioService {
    private MinioClient minioClient;
    private final MinioUtil minioUtil;

    public MinioService(MinioUtil minioUtil, MinioUtil minioUtil1) {
        this.minioUtil = minioUtil1;
        minioClient = minioUtil.generateMinioClient();
    }

    public void uploadFile(String metadata, MultipartFile file) {
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
            throw new RuntimeException("Ocorreu o seguinte erro: " + e.getMessage());
        }
    }

    @SneakyThrows
    public byte[] downloadFile(MinioForm form) {
        String filePath = "./tmp/" + form.getBucket() + "/" + form.getObjectName();
        Path destinationPath = Paths.get(filePath);
        if (Files.exists(destinationPath)) {
            Files.delete(destinationPath);
        }

        DownloadObjectArgs downloadArgs = DownloadObjectArgs.builder()
                .bucket(form.getBucket())
                .object(form.getObjectName())
                .filename(filePath)
                .build();

        minioClient.downloadObject(downloadArgs);
        return  readBytesFromFile(filePath);
    }

    private byte[] readBytesFromFile(String filePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

}
