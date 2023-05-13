package com.idstar.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass

@Getter
@Setter
public class BaseObject {

	@Column(name = "created_date")
	public Date createdDate = new Date();

	@JsonIgnore
	@Column(name = "created_by")
	public String createdBy;

	@Column(name = "deleted_date")
	public Date deletedDate;

	@JsonIgnore
	@Column(name = "deleted_by")
	public String deletedBy;

	@Column(name = "updated_date")
	public Date updatedDate = new Date();;

	@JsonIgnore
	@Column(name = "updated_by")
	public String updatedBy;

}
