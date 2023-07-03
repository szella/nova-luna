package br.com.szella.novaluna.repository;

import br.com.szella.novaluna.entity.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
}
