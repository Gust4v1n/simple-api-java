package first_project.demo.controller;

import first_project.demo.controller.dto.estatisticaDto;
import first_project.demo.controller.dto.pedidoDto;
import first_project.demo.service.estatisticaService;
import first_project.demo.service.pedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido/estatistica")
@Slf4j
public class estatisticaController {
    @Autowired
    private estatisticaService estatisticaService;
    @Autowired
    private pedidoService pedidoService;
    private pedidoDto pedidoDto;
    @GetMapping
    public estatisticaDto estatistica(pedidoDto dto){
        //gambiarra sinistra
        log.info("estatistica exibida");
        List<pedidoDto> pedidos = pedidoService.verProdutos(dto);
        return estatisticaService.exibirEstatistica(pedidos);
    }
}
