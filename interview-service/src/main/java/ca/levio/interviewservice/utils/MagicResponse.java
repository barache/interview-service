package ca.levio.interviewservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public final class MagicResponse<T> {

    private final Optional<T> t;
   private MagicResponse(T t) {
        this.t = Optional.ofNullable(t);
    }

    public static <T> MagicResponse of(T t) {
        return new MagicResponse(t);
    }

    public ResponseEntity<T> ifPresentOrElse(HttpStatus exists, HttpStatus notExists) {
        if (t.isEmpty()) {
            return new ResponseEntity<>(notExists);
        }
        return new ResponseEntity<>(t.get(), exists);
    }

}