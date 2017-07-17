package br.com.rcazambuja.review.model;

import java.time.LocalDate;

public class Review {
    private Long reviewId;
    private String isbn;
    private String title;
    private String comment;
    private int rating;
    private LocalDate date;
    
    public Review() {
        super();
    }

    public Review(Long reviewId, String isbn, String title, String comment, int rating, LocalDate date) {
        super();
        this.reviewId = reviewId;
        this.isbn = isbn;
        this.title = title;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getDate() {
        return date;
    }    
}
