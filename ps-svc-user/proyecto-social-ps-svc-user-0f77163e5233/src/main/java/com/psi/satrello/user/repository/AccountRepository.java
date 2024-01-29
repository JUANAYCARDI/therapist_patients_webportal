package com.psi.satrello.user.repository;
import com.psi.satrello.user.entity.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// Repository with the required query that retrieves all the patients information to a given therapist
@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT acc FROM Account acc WHERE acc.personalId = :personal_id")
    List<Account> findAllByPersonalId(@Param("personal_id")String personalId);

    Optional<Account> findByPersonalId(String personalId);

    @Query("SELECT acc.name FROM Account acc WHERE acc.personalId = :personal_id")
    Optional<String> findNameByPersonalId(@Param("personal_id") String personalId);
    
}
