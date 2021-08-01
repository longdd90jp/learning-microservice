package com.mathtrainer.backed.calculator.domain;

import com.mathtrainer.backed.common.domain.CommonDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseDocument extends CommonDocument {

    @Id
    private String id;
}
