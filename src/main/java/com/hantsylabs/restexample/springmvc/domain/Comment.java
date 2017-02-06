package com.hantsylabs.restexample.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "comments")
@JsonIgnoreProperties("post")
public class Comment extends BaseEntity {

//    private static final long serialVersionUID = 1L;
//
//    @Id()
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
  
	private static final long serialVersionUID = -6864595688027077414L;

	@Column(name = "content")
    private String content;

    @JoinColumn(name = "post_id")
    @ManyToOne(optional = false)
    private Post post;

//    @Column(name = "created_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    @PrePersist
//    public void prePersist() {
//        this.createdDate = new Date();
//    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", content=" + content + ", post=" + post.getId() + ", createdDate=" + createdDate + '}';
    }

}
