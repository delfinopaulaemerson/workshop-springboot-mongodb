package com.workshopmongo.curso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.workshopmongo.curso.dto.AuthorDTO;
import com.workshopmongo.curso.dto.CommentDTO;

@Document(collection = "post")
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
		
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	private List<CommentDTO> coments = new ArrayList<CommentDTO>();
	
	public Post() {
	
	}
	
	
	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}


	public List<CommentDTO> getComents() {
		return coments;
	}


	public void setComents(List<CommentDTO> coments) {
		this.coments = coments;
	}
}
