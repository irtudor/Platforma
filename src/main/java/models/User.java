package models;

import java.util.LinkedList;
import java.util.Objects;

public class User {
    private String username;
    private String email;
    private String card;
    private String cvv;
    private String role;
    private String password;
    private String phoneNumber;
    private Long accountCreationTime;
    private LinkedList<String> ratedVideos;

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", card='" + card + '\'' +
                ", cvv='" + cvv + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountCreationTime='" + accountCreationTime + '\'' +
                ", ratedVideos='" + ratedVideos + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(card, user.card) &&
                Objects.equals(cvv, user.cvv) &&
                Objects.equals(role, user.role) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, card, cvv, role, password, phoneNumber);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getAccountCreationTime() {
        return accountCreationTime;
    }

    public void setAccountCreationTime(long accountCreationTime) {
        this.accountCreationTime = accountCreationTime;
    }

    public LinkedList<String> getRatedVideos() {
        return ratedVideos;
    }

    public void setRatedVideos(LinkedList<String> ratedVideos) { this.ratedVideos = ratedVideos; }

    public User(String username, String password, String phoneNumber, String role, String email, String card, String cvv){
        this.username=username;
        this.card=card;
        this.cvv=cvv;
        this.email=email;
        this.role=role;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.accountCreationTime = System.currentTimeMillis();
        this.ratedVideos = new LinkedList<String>();
    }

    public boolean accountActive() {
        return System.currentTimeMillis() < accountCreationTime + 262974383; //one month
    }

    public void addRatedVideo(String title) {
        ratedVideos.add(title);
    }
}
