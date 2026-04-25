package br.com.catalogo.interfaces.rest.controller;

import br.com.catalogo.application.dto.ProdutoRequest;
import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.application.usecase.AtualizarPrecoProdutoUseCase;
import br.com.catalogo.application.usecase.BuscarProdutoPorIdUseCase;
import br.com.catalogo.application.usecase.CriarProdutoUseCase;
import br.com.catalogo.application.usecase.InativarProdutoUseCase;
import br.com.catalogo.application.usecase.ListarProdutosUseCase;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;
    
    private final BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase;
    
    private final AtualizarPrecoProdutoUseCase atualizarPrecoProdutoUseCase;
    
    private final InativarProdutoUseCase inativarProdutoUseCase;
    
    private final ListarProdutosUseCase listarProdutosUseCase;


    public ProdutoController(CriarProdutoUseCase criarProdutoUseCase, 
    	   BuscarProdutoPorIdUseCase buscarProdutoPorIdUseCase,
    	   AtualizarPrecoProdutoUseCase atualizarPrecoProdutoUseCase,
    	   InativarProdutoUseCase inativarProdutoUseCase,
    	   ListarProdutosUseCase listarProdutosUseCase) {
			this.criarProdutoUseCase = criarProdutoUseCase;
			this.buscarProdutoPorIdUseCase = buscarProdutoPorIdUseCase;
			this.atualizarPrecoProdutoUseCase = atualizarPrecoProdutoUseCase;
			this.inativarProdutoUseCase = inativarProdutoUseCase;
			this.listarProdutosUseCase = listarProdutosUseCase;
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
    
    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listar(
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(listarProdutosUseCase.executar(pageable));
    }
    
    @PatchMapping("/{id}/preco")
    public ResponseEntity<ProdutoResponse> atualizarPreco(
            @PathVariable UUID id, 
            @RequestParam BigDecimal valor, 
            @RequestParam(defaultValue = "BRL") String moeda) {
        
        ProdutoResponse response = atualizarPrecoProdutoUseCase.executar(id, valor, moeda);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable UUID id) {
        inativarProdutoUseCase.executar(id);
    }

}
