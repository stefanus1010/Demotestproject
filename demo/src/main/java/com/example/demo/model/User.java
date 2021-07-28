package com.example.demo.model;

import java.time.ZonedDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iduser;

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "email")
	private String email;
	
	@CreatedDate
	@Column(name="created_at")
	private ZonedDateTime createdAt;
	
	@LastModifiedDate
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
}
