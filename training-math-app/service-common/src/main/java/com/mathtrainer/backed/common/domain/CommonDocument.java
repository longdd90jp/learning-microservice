package com.mathtrainer.backed.common.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CommonDocument {

    private String createdBy;
    private String updatedBy;

    private Date createdDate;
    private Date updatedDate;
}
