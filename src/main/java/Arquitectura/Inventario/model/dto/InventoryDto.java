package Arquitectura.Inventario.model.dto;

import lombok.*;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InventoryDto implements Serializable {
    private Integer id;

    private String nombre;


    private Integer cantidad;






}
