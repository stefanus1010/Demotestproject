package com.example.demo.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pivotrole_user")
public class PivotRoleandUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPivot_roleuser;
	
	@ManyToOne
	@JoinColumn(name = "idrole")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;

	@CreatedDate
	@Column(name="created_at")
	private ZonedDateTime CreatedAt;
	
	@LastModifiedDate
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;
}
