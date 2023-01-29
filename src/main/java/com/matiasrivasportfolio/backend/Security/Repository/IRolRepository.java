
package com.matiasrivasportfolio.backend.Security.Repository;

import com.matiasrivasportfolio.backend.Security.Entity.Rol;
import com.matiasrivasportfolio.backend.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
