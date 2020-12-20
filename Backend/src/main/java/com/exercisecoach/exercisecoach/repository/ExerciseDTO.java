package com.exercisecoach.exercisecoach.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ExerciseDTO {
	private Integer id;
	private String contents;
	private UserDTO user;
}
