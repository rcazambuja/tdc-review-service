package br.com.rcazambuja.review;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rcazambuja.review.model.ReviewsRepository;
import br.com.rcazambuja.review.model.InMemoryReviewsRepositoryImpl;

@Configuration
public class ApplicationConfig {
    @Bean
    public ReviewsRepository booksRepository(){
        return new InMemoryReviewsRepositoryImpl();
    }
}
