package br.com.rcazambuja.review.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ReviewNotFoundException(){
        super("Review not found");
    }
}
