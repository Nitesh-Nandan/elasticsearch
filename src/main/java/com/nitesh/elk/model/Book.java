package com.nitesh.elk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "testelk", type = "books")
public class Book {

    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	@Id
    private String id;

    private String title;

    private String author;

    private String publication;
    
    private float price;
    
    private String coutry;

    public Book() {
    }
    
    

	public Book(String title, String author, String publication, float price, String coutry) {
		super();
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.price = price;
		this.coutry = coutry;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCoutry() {
		return coutry;
	}

	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publication=" + publication
				+ ", price=" + price + ", coutry=" + coutry + "]";
	}

   
}