package kodlamaio.hrms.api.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementsDto {

	private String employeName;
	
	private String positionName;
	
	private int vacancy;
	
	private Date creationDate;
	
	private LocalDate deadline;
	
	
	
}
