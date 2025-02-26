package com.hcc.repositories;

import com.hcc.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository(value = "authorities")
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Optional<Authority> getById(String id);
    Optional<Authority> getByUserId(String id);
//    Optional<Authority> saveAuthority(Authority authority);
//    Optional<Authority> createAuthority(Authority authority);
    //void deleteAuthority(Authority authority);
}
