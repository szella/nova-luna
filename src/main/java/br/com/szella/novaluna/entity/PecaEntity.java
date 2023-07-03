package br.com.szella.novaluna.entity;

import br.com.szella.novaluna.enums.CorPecaEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Peca")
@Table(name = "peca")
public class PecaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer passos;

    @Enumerated(EnumType.STRING)
    private CorPecaEnum cor;

    @OneToMany(mappedBy = "peca")
    private List<DesafioEntity> desafios;

    @ManyToOne(cascade = CascadeType.ALL)
    private TabuleiroEntity tabuleiro;
  }
