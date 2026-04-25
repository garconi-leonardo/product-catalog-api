package br.com.catalogo.infrastructure.persistence.adapter;

import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.repository.ProdutoRepository;
import br.com.catalogo.infrastructure.persistence.entity.ProdutoEntity;
import br.com.catalogo.infrastructure.persistence.mapper.ProdutoPersistenceMapper;
import br.com.catalogo.infrastructure.persistence.repository.JpaProdutoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProdutoPersistenceAdapter implements ProdutoRepository {

    private final JpaProdutoRepository jpaRepository;
    private final ProdutoPersistenceMapper mapper;

    public ProdutoPersistenceAdapter(JpaProdutoRepository jpaRepository, ProdutoPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity entidade = mapper.paraEntidade(produto);
        ProdutoEntity salva = jpaRepository.save(entidade);
        return mapper.paraDominio(salva);
    }

    @Override
    public Optional<Produto> buscarPorId(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::paraDominio);
    }
    
    @Override
    public Page<Produto> listarTodos(Pageable pageable) {
        //Busca a página de entidades do banco
        return jpaRepository.findAll(pageable)
                //Converte cada ProdutoEntity para Produto usando o mapper
                .map(mapper::paraDominio);
    }

    @Override
    public void deletar(UUID id) {
        jpaRepository.deleteById(id);
    }
}
