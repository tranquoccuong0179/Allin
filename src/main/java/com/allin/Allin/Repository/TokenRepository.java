package com.allin.Allin.Repository;

import com.allin.Allin.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("""
    select t from Token t
    inner join User u on t.user.userId = u.userId
    where u.userId = :id and (t.expired = false or t.revoked = false )
""")
    List<Token> findAllValidTokensByUser(@Param("id") Long id);

    Optional<Token> findByToken(String token);
}
