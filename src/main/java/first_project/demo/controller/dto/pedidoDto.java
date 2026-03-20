package first_project.demo.controller.dto;

import java.time.OffsetDateTime;

public record pedidoDto(String descricao, Double valor, OffsetDateTime dataHora) {
    public pedidoDto{
        if(dataHora == null){
            dataHora = OffsetDateTime.now();
        }
    }
}
