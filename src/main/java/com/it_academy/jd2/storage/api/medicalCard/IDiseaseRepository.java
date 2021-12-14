package com.it_academy.jd2.storage.api.medicalCard;

import com.it_academy.jd2.model.site_info.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiseaseRepository extends JpaRepository<Disease, Integer> {
}
