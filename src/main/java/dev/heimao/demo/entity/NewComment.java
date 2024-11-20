package dev.heimao.demo.entity;

import jakarta.validation.constraints.NotBlank;

public class NewComment {

    @NotBlank(message = "content can not be empty")
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
