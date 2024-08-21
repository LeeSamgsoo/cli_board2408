package org.example.article;

public class Board {
    private int number;
    private String title;
    private String content;

    Board(int number, String title, String content) {
        this.number = number;
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
