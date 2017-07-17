package br.com.rcazambuja.review.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class InMemoryReviewsRepositoryImpl implements ReviewsRepository {
    private Map<Long, Review> reviews;
    Random randomGenerator = new Random();
    long counter = 1;
    
    public InMemoryReviewsRepositoryImpl() {
        reviews = defaultReviews();
    }
    
    @Override
    public Review getByReviewId(Long reviewId) {  
        return reviews.get(reviewId);
    }
    
    @Override
    public List<Review> getByIsbn(String isbn) {        
        return Collections.unmodifiableList(
                reviews.values()
                    .stream()
                    .filter(x -> isbn.equals(x.getIsbn()))
                    .sorted(new Comparator<Review>() {
                        @Override
                        public int compare(Review o1, Review o2) {                            
                            return o2.getDate().compareTo(o1.getDate());
                        }
                    })
                    .collect(Collectors.toList()));
    }

    @Override
    public Review saveOrUpdate(Review review) {
        reviews.put(review.getReviewId(), review);
        return review;
    }

    @Override
    public void delete(Review review) {
        reviews.remove(review.getReviewId());
    }
    
    private Map<Long, Review> defaultReviews() {
        List<Review> reviews = new ArrayList<>();
        String[] isbns = {"978-0134494166", "978-0321356680", "978-1786461483", "978-0321774514", "978-1491929124","978-1491950357"};
                
        for(String isbn : isbns) {
            int itens = randomGenerator.nextInt(8)+3;
            for(int i=1; i<itens; i++) {
                reviews.add(new Review(
                        Long.valueOf(counter++), isbn, "Review "+i, "Comment "+i, randomGenerator.nextInt(3)+2, randomDate()));
            }        
        }
        return reviews.stream().collect(
                Collectors.toMap(x -> x.getReviewId(), x -> x));
    }  
    
    private LocalDate randomDate() {
        return LocalDate.of(
                randomGenerator.nextInt(17)+2000,
                randomGenerator.nextInt(11)+1, 
                randomGenerator.nextInt(27)+1);
    }       
}
