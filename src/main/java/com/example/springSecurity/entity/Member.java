package com.example.springSecurity.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor		//lombok의 역할
@Builder
public class Member {
	private int mid;
	private String name;
	private LocalDate regDate;
	private String email;
}