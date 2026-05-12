package br.com.veiga.spring_boot_essentials.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProdutoDTO {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

}
