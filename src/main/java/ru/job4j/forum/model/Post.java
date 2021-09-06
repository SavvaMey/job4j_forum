package ru.job4j.forum.model;

import com.zaxxer.hikari.metrics.dropwizard.CodahaleMetricsTrackerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @OneToMany(mappedBy = "post", orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static Post of(String name, String description) {
        Post post = new Post();
        post.name = name;
        post.description = description;
        return post;
    }

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        return post;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }


    public void setComments(List<Comment> comments) {
        this.commentList = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", commentList=" + commentList +
                ", user=" + user +
                '}';
    }
}
