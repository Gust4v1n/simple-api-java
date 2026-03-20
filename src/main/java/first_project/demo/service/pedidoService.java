package first_project.demo.service;

import first_project.demo.controller.dto.pedidoDto;
import first_project.demo.exeption.badRequest;
import first_project.demo.exeption.unprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class pedidoService {
    private List<pedidoDto> pedidoDtos = new ArrayList<>();

    public List<pedidoDto> verProdutos(pedidoDto dto){

        OffsetDateTime ultimos60Segundos = dto.dataHora().minusSeconds(60);
        return pedidoDtos.stream().filter(pedidoDto -> pedidoDto.dataHora().isAfter(ultimos60Segundos)).toList();
    }

    public List<pedidoDto> deletarProdutos(pedidoDto dto){
        pedidoDtos.clear();
        return pedidoDtos;
    }

    public pedidoDto adicionarProdutosService(@RequestBody pedidoDto dto){
        if(dto.valor() == null || dto.descricao() == null){
            throw  new badRequest("Valor ou Descricao nao definido");
        }

        if(dto.valor()<=0){
            throw new unprocessableEntity("Valor menor que 0, isso nao e permitido");
        }

        if(dto.dataHora().isAfter(OffsetDateTime.now())){
            throw new unprocessableEntity("Operacao no futuro, isso nao e permitido seu viajante do tempo");
        }
        pedidoDtos.add(dto);
        return dto;
    }

    public List<pedidoDto> exibirProdutoExpecificoService(@PathVariable String nome, pedidoDto dto){
        return pedidoDtos.stream().filter(pedidoDto -> pedidoDto.descricao().equals(nome)).toList();
    }
}
