package com.scaler.bookmyshow.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class BaseModel {
    @Id
    private long id;
    private Date createdDate;
    private Date lastModifiedAt;
}
