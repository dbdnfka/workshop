package com.Woo.Ram.entity;

import lombok.Getter;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Date {
    @Column
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createdDate;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate modifiedDate;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int view;
    /* 해당 엔티티를 저장하기 이전에 실행 */
    @PrePersist
    public void onPrePersist(){
    this.createdDate = LocalDate.now();
    this.modifiedDate = this.createdDate;
}

    /* 해당 엔티티를 업데이트 하기 이전에 실행*/
    @PreUpdate
    public void onPreUpdate(){
    this.modifiedDate = LocalDate.now();
}



}
