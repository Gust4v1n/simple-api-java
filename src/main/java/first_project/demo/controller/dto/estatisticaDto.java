package first_project.demo.controller.dto;

public record estatisticaDto(Long count, Double sum, Double avg, Double min, Double max) {
    public estatisticaDto{
        if(min.isInfinite() || max.isInfinite()){
            min = 0.0;
            max = 0.0;
        }
    }
}
