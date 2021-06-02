package kodlamaio.hrms.core.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.el.parser.ParseException;

import kodlamaio.hrms.api.dtos.ResumesCreateDto;
import kodlamaio.hrms.api.dtos.ResumesDto;
import kodlamaio.hrms.entities.concretes.Resumes;

@Component
public class ResumeMapper {
	
	private ModelMapper modelMapper;

	@Autowired
	public ResumeMapper(ModelMapper modelMapper) {

		this.modelMapper = modelMapper;
	}

	public List<ResumesDto> convertToDto(List<Resumes> resumes) {

		List<ResumesDto> resumesDtos = new ArrayList<ResumesDto>();

		for (Resumes resume : resumes) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			ResumesDto resumesDto = modelMapper.map(resume, ResumesDto.class);

			resumesDtos.add(resumesDto);
		}
		return resumesDtos;
	}

	public List<Resumes> convertToEntity(List<ResumesDto> resumesDto)
			throws ParseException {
		List<Resumes> resumes = new ArrayList<Resumes>();

		for (ResumesDto resumesDt : resumesDto) {
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
			Resumes resume = modelMapper.map(resumesDt, Resumes.class);
			

			resumes.add(resume);

		}
		return resumes;
	}
	
	public ResumesCreateDto convertToCreateDto(Resumes resumes) {
		ResumesCreateDto resumesCreateDto = modelMapper.map(resumes,
				ResumesCreateDto.class);
		return resumesCreateDto;
	}

	public Resumes convertToCreateEntity(ResumesCreateDto resumesCreateDto)
			throws ParseException {
		Resumes resume = modelMapper.map(resumesCreateDto, Resumes.class);

		return resume;
	}
}
