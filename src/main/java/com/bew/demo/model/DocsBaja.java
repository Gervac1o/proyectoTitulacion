package com.bew.demo.model;

import lombok.Data;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "docs_baja")
public class DocsBaja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "doc_sec", sequenceName = "doc_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_sec")
	private Long fileId;
	
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String fileType;
    
    @Column(name = "id_doc")
    private String idDoc;
    
    @Lob
    private byte[] data;


    public DocsBaja() {}
    
    public DocsBaja (String fileName, String fileType, byte[] data, String idDoc) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.idDoc=idDoc;
        //this.fileId = fileId;
    }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_solicitud",insertable=false, updatable = false)
	private SolicitudBaja solicitudBaja;


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

	public String getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}


}
