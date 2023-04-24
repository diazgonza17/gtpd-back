
package com.yoprogramo.portfolioBack.repository;

import com.yoprogramo.portfolioBack.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRSkill extends JpaRepository<Skill, Integer> {
    public Optional<Skill> findByNombreSki(String nombreSki);
    public boolean existsByNombreSki(String nombreSki);
}

