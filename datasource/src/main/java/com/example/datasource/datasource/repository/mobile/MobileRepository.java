package com.example.datasource.datasource.repository.mobile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.datasource.datasource.model.mobile.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
