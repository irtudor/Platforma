package models;

import java.util.Objects;

public class Series {
    private String title;
    private String season;
    private String episode;
    private String year;
    private String description;
    private String review;
    private double rate;
    private int nrOfRatings;

    public Series(){

    }

    public Series(String title, String season, String episode, String year, String description, String review){
        this.title = title;
        this.season = season;
        this.episode = episode;
        this.year = year;
        this.description = description;
        this.review = review;
        this.rate = -1;
        this.nrOfRatings = 0;
    }

    @Override
    public String toString() {
        return "Series{" +
                "title='" + title + '\'' +
                ", season='" + season + '\'' +
                ", episode='" + episode + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                ", review='" + review + '\'' +
                ", rate='" + rate + '\'' +
                ", nrOfRatings='" + nrOfRatings + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return Objects.equals(title, series.title) &&
                Objects.equals(season, series.season) &&
                Objects.equals(episode, series.episode) &&
                Objects.equals(year, series.year) &&
                Objects.equals(description, series.description) &&
                Objects.equals(review, series.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, season, episode, year, description, review);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getSeason(){
        return season;
    }

    public void setSeason(String season){
        this.season = season;
    }

    public String getEpisode(){
        return episode;
    }

    public void setEpisode(String episode){
        this.episode = episode;
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

    public double getRate(){ return rate; }

    public void setRate(double rate){
        this.rate = rate;
    }

    public int getNrOfRatings(){
        return nrOfRatings;
    }

    public void setNrOfRatings(int nrOfRatings){
        this.nrOfRatings = nrOfRatings;
    }
}
