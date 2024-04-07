package com.narayan.foodlogger.repositories;

import com.narayan.foodlogger.model.PasswordResetToken;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PasswordTokenRepository extends ReactiveCrudRepository<PasswordResetToken, String> {

    Mono<PasswordResetToken> findByToken(String token);

}
