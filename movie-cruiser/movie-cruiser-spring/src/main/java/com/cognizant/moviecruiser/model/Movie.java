package com.cognizant.moviecruiser.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@Column(name = "movie_id")
	private int id;

	@Column(name = "movie_title")
	private String title;

	public Movie() {

	}

	public Movie(int id, String title, float boxOffice, boolean active, Date dateOfLaunch, String category,
			String teaser) {
		setId(id);
		setTitle(title);
		setBoxOffice(boxOffice);
		setActive(active);
		setDateOfLaunch(dateOfLaunch);
		setCategory(category);
		setTeaser(teaser);
	}

	@Column(name = "movie_box_office")
	private float boxOffice;

	@Column(name = "movie_active")
	private boolean active;

	@Column(name = "movie_dateOfLaunch")
	private Date dateOfLaunch;

	@Column(name = "movie_genre")
	private String category;

	@Column(name = "movie_teaser")
	private String teaser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(float boxOffice) {
		this.boxOffice = boxOffice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", boxOffice=" + boxOffice + ", active=" + active
				+ ", dateOfLaunch=" + dateOfLaunch + ", category=" + category + ", teaser=" + teaser + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Movie other = (Movie) obj;
		return id == other.id;
	}

}
