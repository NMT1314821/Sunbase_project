package com.springjwt.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails
{
	private LocalDateTime timestamp;
	private String message;
	private String errorCode;
	private String path;

}
