package com.nitesh.elk.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mytest", type = "_doc")
public class Book {

    public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	@Id
    private String id;
	
	private Integer bid;

    private String title;

    private String author;

    private String publication;
    
    private float price;
    
    private String country;

    public Book() {
    }
    
    

	public Book(String id, Integer bid, String title, String author, String publication, float price, String country) {
		super();
		this.id = id;
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.price = price;
		this.country = country;
	}



	public Integer getBid() {
		return bid;
	}



	public void setBid(Integer bid) {
		this.bid = bid;
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

	public String getcountry() {
		return country;
	}

	public void setcountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publication=" + publication
				+ ", price=" + price + ", country=" + country + "]";
	}

   
}