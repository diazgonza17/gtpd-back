
package com.yoprogramo.portfolioBack.repository;

import com.yoprogramo.portfolioBack.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRProyecto extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombrePro(String nombrePro);
    public boolean existsByNombrePro(String nombrePro);
}
