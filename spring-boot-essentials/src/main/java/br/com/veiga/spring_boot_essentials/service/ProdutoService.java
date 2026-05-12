package br.com.veiga.spring_boot_essentials.service;

import br.com.veiga.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.veiga.spring_boot_essentials.dto.ProdutoDTO;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

            static {
                PRODUTOS.add(ProdutoEntity.builder()
                        .id(1)
                        .nome("Notebook")
                        .preco(new BigDecimal(5000))
                        .quantidade(10)
                        .build());

                PRODUTOS.add(ProdutoEntity.builder()
                                .id(2)
                                .nome("Iphone")
                                .preco(new BigDecimal(7000))
                                .quantidade(10)
                                .build());

                PRODUTOS.add(ProdutoEntity.builder()
                                .id(3)
                                .nome("Mouse")
                                .preco(new BigDecimal(500))
                                .quantidade(10)
                                .build());
            };


    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }


    public ProdutoEntity createProduct(ProdutoDTO produtoDTO) {

        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity newProduto = ProdutoEntity.builder()
                .id(identificador)
                .nome(produtoDTO.getNome())
                .preco(produtoDTO.getPreco())
                .quantidade(produtoDTO.getQuantidade())
                .build();

        PRODUTOS.add(newProduto);

        return newProduto;
    }


    public ProdutoEntity updateProduct(ProdutoDTO produtoDTO, Integer id) {

        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());
        return produto;
    }


    public void removeProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }

}