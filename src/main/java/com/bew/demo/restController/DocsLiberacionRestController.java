package com.bew.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.DocsLiberacionService;

@RestController
@RequestMapping("/docLiberacion")
@CrossOrigin("*")

public class DocsLiberacionRestController {
	
	@Autowired
	DocsLiberacionService docsLiberacionService;
	
    @PostMapping(path = "/upload/{idDoc}", produces="application/json")
    public String FileUpload(@RequestParam("file") MultipartFile file, @PathVariable String idDoc)  throws EmptyResultException {
    	
    	docsLiberacionService.store(file,idDoc);
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	System.out.println(fileName + " <-- Luis esta borracho y lo hizo llorar el Damenso");
    	
    	return fileName;
    }
    
    @GetMapping("/getFile/{idFile}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> serveFile(@PathVariable Long idFile) throws EmptyResultException {

        return  docsLiberacionService.load(idFile);
    }
    
    @GetMapping("/getDoc/{idDoc}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> serveDoc(@PathVariable String idDoc) throws EmptyResultException {

        return  docsLiberacionService.findDoc(idDoc);
    }
    
    @DeleteMapping(path = "/deleteDoc/{idDoc}")
	public ResponseEntity<?> delete(@PathVariable String idDoc){
	docsLiberacionService.deleteDoc(idDoc);
	return ResponseEntity.ok().build();
	}
}
