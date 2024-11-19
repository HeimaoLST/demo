package dev.heimao.demo.entity;

public class Comment {

    private Integer id;
    private String content;
    private Integer likeCount;
    private Integer authorId;

    public boolean isFromAdmin() {
        return fromAdmin;
    }

    public void setFromAdmin(boolean fromAdmin) {
        this.fromAdmin = fromAdmin;
    }

    private boolean fromAdmin;

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
