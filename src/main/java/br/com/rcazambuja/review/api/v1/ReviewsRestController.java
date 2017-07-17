package br.com.rcazambuja.review.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rcazambuja.review.model.Review;
import br.com.rcazambuja.review.model.ReviewsRepository;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsRestController {
    private ReviewsRepository reviewsRepository;
    
    @Autowired
    public ReviewsRestController(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Review> list(@RequestParam(name="isbn", required=true) String isbn) {
        return reviewsRepository.getByIsbn(isbn);
    }
    
    @RequestMapping(value = "/{reviewId}", method = RequestMethod.GET)
    public Review get(@PathVariable Long reviewId) {
        Review review = reviewsRepository.getByReviewId(reviewId);
        if(review == null) {
            throw new ReviewNotFoundException();
        }
        return review;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Review create(@RequestBody Review review) {
        return reviewsRepository.saveOrUpdate(review);
    }
}
