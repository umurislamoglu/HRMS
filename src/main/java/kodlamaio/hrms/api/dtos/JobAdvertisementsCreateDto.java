package kodlamaio.hrms.api.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementsCreateDto {
	
	private int employerId;
	
	private int jobPositionId;
	
	private String positionDefinition;
	
	private String city;
	
	private int salaryMin;
	
	private int salaryMax;
	
	private int vacancy;
	
	private LocalDate deadline;
	
	@JsonIgnore
	private boolean isActive = true;
	
	
}
