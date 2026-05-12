package br.com.veiga.spring_boot_essentials.controller;

import br.com.veiga.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.veiga.spring_boot_essentials.dto.ProdutoDTO;
import br.com.veiga.spring_boot_essentials.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll() {
        return produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity create(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.createProduct(produtoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity update(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDTO) {
        return produtoService.updateProduct(produtoDTO, id);
    }

}
