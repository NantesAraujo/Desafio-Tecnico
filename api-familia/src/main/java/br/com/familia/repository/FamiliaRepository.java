package br.com.familia.repository;

import br.com.familia.domain.entity.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliaRepository extends JpaRepository<Familia, Long> {
}
