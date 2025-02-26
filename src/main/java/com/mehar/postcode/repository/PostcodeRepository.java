package com.mehar.postcode.repository;

import com.mehar.postcode.model.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PostcodeRepository extends JpaRepository<Postcode, Long> {
    Optional<Postcode> findByPostcode(String postcode);
}
