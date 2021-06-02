package kodlamaio.hrms.core.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.el.parser.ParseException;

import kodlamaio.hrms.api.dtos.JobAdvertisementsCreateDto;
import kodlamaio.hrms.api.dtos.JobAdvertisementsDto;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;

@Component
public class JobAdvertisementMapper {

	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementMapper(ModelMapper modelMapper) {

		this.modelMapper = modelMapper;
	}

	public JobAdvertisementsCreateDto convertToCreateDto(JobAdvertisements jobAdvertisements) {
		JobAdvertisementsCreateDto jobAdvertisementsCreateDto = modelMapper.map(jobAdvertisements,
				JobAdvertisementsCreateDto.class);
		return jobAdvertisementsCreateDto;
	}

	public JobAdvertisements convertToCreateEntity(JobAdvertisementsCreateDto jobAdvertisementsCreateDto)
			throws ParseException {
		JobAdvertisements jobAdvertisement = modelMapper.map(jobAdvertisementsCreateDto, JobAdvertisements.class);

		return jobAdvertisement;
	}

	public List<JobAdvertisementsDto> convertToDto(List<JobAdvertisements> jobAdvertisements) {

		List<JobAdvertisementsDto> jobAdvertisementsDtos = new ArrayList<JobAdvertisementsDto>();

		for (JobAdvertisements jobAdvertisement : jobAdvertisements) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			JobAdvertisementsDto jobAdvertisementsDto = modelMapper.map(jobAdvertisement, JobAdvertisementsDto.class);

			jobAdvertisementsDtos.add(jobAdvertisementsDto);
		}
		return jobAdvertisementsDtos;
	}

	public List<JobAdvertisements> convertToEntity(List<JobAdvertisementsDto> jobAdvertisementsDto)
			throws ParseException {
		List<JobAdvertisements> jobAdvertisements = new ArrayList<JobAdvertisements>();

		for (JobAdvertisementsDto JobAdvertisementsDt : jobAdvertisementsDto) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			JobAdvertisements jobAdvertisement = modelMapper.map(JobAdvertisementsDt, JobAdvertisements.class);
			

			jobAdvertisements.add(jobAdvertisement);

		}
		return jobAdvertisements;
	}

}
