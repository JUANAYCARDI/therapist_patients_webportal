package com.psi.satrello.user.repository;

import com.psi.satrello.user.entity.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findAllByPatientId(String personalId);

    @Query("SELECT new Activity(act.name, act.description, act.startDate) FROM Activity act WHERE act.patientId = :patient_id")
    List<Optional<Activity>> findAllByPersonalId(@Param("patient_id")String patientId);

    @Query("SELECT m FROM Mecanic m")
    List<Mecanic> findAllMecanics();

    @Query("SELECT c FROM Category c")
    List<Category> findAllCategory();

    @Query("SELECT s FROM SubCategory s")
    List<SubCategory> findAllSubCategory();

    @Query("SELECT st FROM Situation st")
    List<Situation> findAllSituation();

}
