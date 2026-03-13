package com.example.model;

/**
 * 电影实体类，作为贯穿本实验的核心数据模型。
 */
public class Movie {

    private Long id;
    private String title;
    private String director;
    private int releaseYear;

    public Movie() {}

    public Movie(Long id, String title, String director, int releaseYear) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    // Getter / Setter（可使用 IntelliJ IDEA 的 Generate 功能自动生成）
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    @Override
    public String toString() {
        return "Movie{id=" + id + ", title='" + title + "', director='" + director
                + "', releaseYear=" + releaseYear + "}";
    }
}