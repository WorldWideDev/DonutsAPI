package com.worldwidedev.donuts.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="donuts")
public class Donut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=1,max=255)
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public Donut() {
	}
	
	public Donut(Long id, @Size(min = 1, max = 255) String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Donut d = (Donut)o;
		return Objects.equals(this.id, d.id) &&
				Objects.equals(this.name, d.name) &&
				Objects.equals(this.description, d.description);
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.description);
	}
	@Override
	public String toString() {
		return "Donut{"+
				"id="+this.id+
				", name='"+this.name+'\''+
				", description='"+this.description+'\''+
				'}';
	}
	
}
