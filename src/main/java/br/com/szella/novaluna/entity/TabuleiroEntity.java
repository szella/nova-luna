package br.com.szella.novaluna.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Tabuleiro")
@Table(name = "tabuleiro")
public class TabuleiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer posicaoLua;

    @OneToMany(mappedBy = "tabuleiro")
    private List<TabuleiroCasaEntity> casas;

    @OneToMany(mappedBy = "tabuleiro")
    private List<PecaEntity> pecas;
}
