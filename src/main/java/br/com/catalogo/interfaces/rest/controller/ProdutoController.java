package br.com.catalogo.interfaces.rest.controller;

import br.com.catalogo.application.dto.ProdutoRequest;
import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.application.usecase.BuscarProdutoPorIdUseCase;
import br.com.catalogo.application.usecase.CriarProdutoUseCase;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;
    
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;

    public ProdutoController(CriarProdutoUseCase criarProdutoUseCase, BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase) {
			this.criarProdutoUseCase = criarProdutoUseCase;
			this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequest request) {
        ProdutoResponse response = criarProdutoUseCase.executar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable UUID id) {
        ProdutoResponse response = buscarProdutoPorIdUseCase.executar(id);
        return ResponseEntity.ok(response);
    }

}
