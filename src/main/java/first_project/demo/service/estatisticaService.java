package first_project.demo.service;

import first_project.demo.controller.dto.estatisticaDto;
import first_project.demo.controller.dto.pedidoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class estatisticaService {
    public estatisticaDto exibirEstatistica(List<pedidoDto> pedidos){

        DoubleSummaryStatistics stats = pedidos.stream().mapToDouble(p -> p.valor()).summaryStatistics();

        return new estatisticaDto(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax()
        );
    }
}