package dev.heimao.demo.entity;

import java.util.Date;

public class Comment {

    private Integer id;
    private String content;
    private Integer likeCount;
    private Integer authorId;

    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    private String createDate;




    public boolean isFromAdmin() {
        return isAdmin;
    }

    public void setFromAdmin(boolean fromAdmin) {
        this.isAdmin = fromAdmin;
    }

    private boolean isAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
