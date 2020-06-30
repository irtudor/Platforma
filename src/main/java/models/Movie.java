package models;

import java.util.Objects;

public class Movie {
    private String title;
    private String year;
    private String description;
    private String review;
    private int rate;

    public Movie(){

    }

    public Movie(String title, String year, String description, String review){
        this.title = title;
        this.year = year;
        this.description = description;
        this.review = review;
        this.rate = -1;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                ", review='" + review + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(review, movie.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, description, review);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getReview(){
        return review;
    }

    public void setReview(String review){
        this.review = review;
    }

    public int getRate(){
        return rate;
    }

    public void setRate(int rate){
        this.rate = rate;
    }
}
