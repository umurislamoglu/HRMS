package kodlamaio.hrms.api.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerImageService;
import kodlamaio.hrms.core.services.CloudinaryService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekerImage;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/JobSeekerImageController")
@CrossOrigin
public class JobSeekerImageController {
	
	private JobSeekerImageService jobSeekerImageService;
	
	private CloudinaryService cloudinaryService;
	private JobSeekersDao jobSeekerDao;

	@Autowired
	public JobSeekerImageController(JobSeekerImageService jobSeekerImageService, CloudinaryService cloudinaryService,JobSeekersDao jobSeekerDao) {
		super();
		this.jobSeekerImageService = jobSeekerImageService;
		this.cloudinaryService = cloudinaryService;
		this.jobSeekerDao = jobSeekerDao;
	}
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @RequestParam int jobSeekerId ) throws IOException{
		
		BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
		if(bufferedImage == null) {
			
			return new ResponseEntity("Resim validasyonu başarısız.", HttpStatus.BAD_REQUEST);
		}			
		
		Map result = cloudinaryService.upload(multipartFile);
		JobSeekerImage image = new JobSeekerImage((String)result.get("original_filename"),(String)result.get("url"),
				(String)result.get("public_id"));
		image.setJobSeeker(jobSeekerDao.getOne(jobSeekerId));
		
		this.jobSeekerImageService.upload(image);
		
	
		return new ResponseEntity("Image saved.", HttpStatus.OK);
	}
	
}
