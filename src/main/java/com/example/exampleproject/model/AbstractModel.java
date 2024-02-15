package com.example.exampleproject.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class AbstractModel {
    @ManyToOne
    @JoinColumn(name = "created_by")
    @CreatedBy
    private User createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    @LastModifiedBy
    private User updatedBy;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Timestamp updatedAt;
}
