package br.com.namedida.core.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/minio")
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.HEAD, RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
public class MinioController {
//    private final MinioService service;

//    private final MinioClient minioClient;
//
//    @Autowired
//    public MinioController(MinioService service, MinioClient minioClient) {
//        this.service = service;
//        this.minioClient = minioClient;
//    }
//
//    @PostMapping("/upload")
//    public void upload(@RequestPart("documento") String metadata,  @RequestPart(value = "file", required=false) MultipartFile file) {
//        service.uploadFile(minioClient, metadata, file);
//    }

//    @GetMapping("/download/")
//    public UserAuthenticated download(){
//        return service.downloadFile();
//    }
}