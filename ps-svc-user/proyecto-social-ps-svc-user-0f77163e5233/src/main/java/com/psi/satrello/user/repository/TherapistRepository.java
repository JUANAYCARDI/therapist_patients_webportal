package com.psi.satrello.user.repository;

import com.psi.satrello.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TherapistRepository extends JpaRepository<Account, UUID> {

    // Optional class used in case the query fails
    Optional<Account> findByUserId(UUID userId);
    Optional<Account> findByPersonalId(String personalId);

    @Query("SELECT new Account(acc.name, acc.avatarUrl, acc.createdDate) FROM Account acc WHERE acc.roleId = :role_id")
    List<Optional<Account>> findAllByRoleId(@Param("role_id")Integer roleId);

}
