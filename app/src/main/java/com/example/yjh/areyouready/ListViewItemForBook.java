package com.example.yjh.areyouready;

/**
 * Created by 이상원 on 2018-05-20.
 */

public class ListViewItemForBook {
    // temp 0: 이미지 인덱스, 1: 평점, 2: 제목, 3: 저자, 4: 소개, 5: 중앙도서관 위치, 6: 청구기호
    private int bookResId;
    private int ratingResId;
    private int rating;
    private String title;
    private String author;
    private String desc;
    private String location;
    private String bookMark;

    public void setBookResId(int bookResId) {
        this.bookResId = bookResId;
    }

    public void setRatingResId(int ratingResId) {
        this.ratingResId = ratingResId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBookMark(String bookMark) {
        this.bookMark = bookMark;
    }

    // temp 0: 이미지 인덱스, 1: 평점, 2: 제목, 3: 저자, 4: 소개, 5: 중앙도서관 위치, 6: 청구기호
    public int getBookResId() {
        return bookResId;
    }

    public int getRatingResId() {
        return ratingResId;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesc() {
        return desc;
    }

    public String getLocation() {
        return location;
    }

    public String getBookMark() {
        return bookMark;
    }
}
