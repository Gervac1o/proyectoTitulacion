package com.bew.demo.model;



import lombok.Data;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "file")

public class FileImage  {

	@Id
	@SequenceGenerator(name = "file_sec", sequenceName = "file_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_sec")
	private Long fileId;
	
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String fileType;
    
    @Lob
    private byte[] data;
    
    
    @Column(name = "id_dictamen")
    private Long idDictamen;



	public FileImage() {}
    
    public FileImage (String fileName, String fileType, byte[] data, Long idDictamen) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
       this.idDictamen=idDictamen;
        
    }

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Long getIdDictamen() {
		return idDictamen;
	}

	public void setIdDictamen(Long idDictamen) {
		this.idDictamen = idDictamen;
	}
	
}

