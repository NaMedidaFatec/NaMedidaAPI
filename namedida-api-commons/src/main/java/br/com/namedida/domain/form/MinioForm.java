package br.com.namedida.domain.form;

import lombok.Data;


@Data
public class MinioForm {
    String bucket;
    String objectName;
    FileForm file;
}


