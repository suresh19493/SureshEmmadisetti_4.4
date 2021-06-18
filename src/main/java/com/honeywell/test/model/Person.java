package com.honeywell.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
	private String personId;
	private String name;
	private String phonenumber;
	private Double lattitude;
	private Double langitude;
}
