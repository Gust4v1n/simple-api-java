package first_project.demo.controller;

import first_project.demo.controller.dto.pedidoDto;
import first_project.demo.service.pedidoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@Slf4j
public class pedidoController {
    @Autowired
    private pedidoService pedidoService;
    @GetMapping
    public List<pedidoDto> exibirProdutos(pedidoDto dto){
        log.info("Exibindo produtos");
        return pedidoService.verProdutos(dto);
    }

    @GetMapping("/{nome}")
    public List<pedidoDto> exibirProdutosExpecificoController(@PathVariable String nome,  pedidoDto dto){
        log.info("Exibindo o produto " + nome);
        return pedidoService.exibirProdutoExpecificoService(nome ,dto);
    }

    @DeleteMapping
    public List<pedidoDto> deletarProdutos(pedidoDto dto){
        log.info("produto deletado");
        return pedidoService.deletarProdutos(dto);
    }

    @PostMapping
    public pedidoDto adicionarProdutosController(@RequestBody pedidoDto dto){
        log.info("produto adicionado");
        return pedidoService.adicionarProdutosService(dto);
    }
}
