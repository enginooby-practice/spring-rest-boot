package com.cpulover.rest.entity;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	@Past //only allow time in the past
	private Date birthDate;
}
