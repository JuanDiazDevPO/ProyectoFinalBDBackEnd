package co.edu.unbosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.model.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    
}