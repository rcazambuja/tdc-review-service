package br.com.rcazambuja.review.model;

import java.util.List;

public interface ReviewsRepository {    
    List<Review> getByIsbn(String isbn);
    Review getByReviewId(Long reviewId);
    Review saveOrUpdate(Review review);
    void delete(Review review);
}
