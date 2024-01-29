package com.psi.satrello.user.repository;
import com.psi.satrello.user.entity.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query("SELECT st.name FROM State st WHERE st.stateId = :state_id")
    public String getNameByStateId(@Param("state_id") Integer stateId);

}
