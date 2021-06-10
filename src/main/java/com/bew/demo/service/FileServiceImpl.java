package com.bew.demo.service;

//import org.springframework.http.MediaType;
import javax.transaction.Transactional;
//import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.dao.FileImageRepository;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.FileImage;
import org.springframework.util.StringUtils;



@Service
@Transactional

public class FileServiceImpl implements FileImageService{
	@Autowired
	FileImageRepository fileImageRepository;
	
	@Override
    public void store(MultipartFile file, Long idDictamen) throws EmptyResultException    {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try  {FileImage dbFile = new FileImage( fileName, file.getContentType(), file.getBytes(),  idDictamen);
		fileImageRepository.save(dbFile);

		  }
		catch(Exception e) {
			e.printStackTrace();
			}
}



	@Override
	public ResponseEntity<ByteArrayResource> load(Long idFile) throws EmptyResultException {
		FileImage file = fileImageRepository.findById(idFile).orElseThrow(() -> new   EmptyResultException("File not found with id " + idFile));
	

        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));
        
        
    
    }



}
