
package com.yoprogramo.portfolioBack.repository;

import com.yoprogramo.portfolioBack.model.Red;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRRed extends JpaRepository<Red, Integer> {
    public Optional<Red> findByLink(String link);
    public boolean existsByLink(String link);
}
