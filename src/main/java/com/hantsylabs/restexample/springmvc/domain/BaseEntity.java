package com.hantsylabs.restexample.springmvc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * Base Entity
 * 
 * @author Elton.Mesquita
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
	protected Long id;
	
	/* Optimistic concurrency control (OCC)	 */
	@Version	
	protected Integer version;	
	
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;	    
   
	
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		BaseEntity that = (BaseEntity) obj;

		return this.id.equals(that.getId());
	}
	
	
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
	
	/**
	 * @return {@link Integer} versão do registro
	 */
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * @param version
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the id
	 */
	
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@PrePersist
    public void prePersist() {
        this.createdDate = new Date();
    }
	
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
