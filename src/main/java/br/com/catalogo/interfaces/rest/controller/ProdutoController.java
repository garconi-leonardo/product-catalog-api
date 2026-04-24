package br.com.catalogo.interfaces.rest.controller;

import br.com.catalogo.application.dto.ProdutoRequest;
import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.application.usecase.CriarProdutoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;

    public ProdutoController(CriarProdutoUseCase criarProdutoUseCase) {
        this.criarProdutoUseCase = criarProdutoUseCase;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequest request) {
        ProdutoResponse response = criarProdutoUseCase.executar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
