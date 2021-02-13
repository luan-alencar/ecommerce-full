package com.luan.ecommerce.ecommerce.recurso;

import com.luan.ecommerce.ecommerce.dominio.Produto;
import com.luan.ecommerce.ecommerce.servico.ProdutoServico;
import com.luan.ecommerce.ecommerce.servico.ProdutorServico;
import com.luan.ecommerce.ecommerce.servico.dto.ProdutoDTO;
import com.luan.ecommerce.ecommerce.servico.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/produtos")
public class ProdutoRecurso {

    private final ProdutoServico produtoServico;
    private final ProdutoMapper produtoMapper;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar() {
        return ResponseEntity.ok(produtoServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Integer idProduto) {
        return ResponseEntity.ok(produtoServico.buscarPorId(idProduto));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoServico.salvar(produto));
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> editar(Produto produto) {
        return ResponseEntity.ok(produtoServico.editar(produto));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer idProduto) {
        produtoServico.remover(idProduto);
    }
}