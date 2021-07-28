package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Setter
@Getter
public class UserGetByDateDTO {
	
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    private LocalDate datestart;

	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    private LocalDate dateend;
}
