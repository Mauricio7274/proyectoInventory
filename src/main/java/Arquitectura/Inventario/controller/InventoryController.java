package Arquitectura.Inventario.controller;

import Arquitectura.Inventario.model.dto.InventoryDto;
import Arquitectura.Inventario.model.entity.Inventory;
import Arquitectura.Inventario.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Arquitectura.Inventario.model.payload.MensajeResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
    @Autowired
    private IInventoryService iInventoryService;

    @GetMapping("productos")
    public ResponseEntity<?> showAll() {
        List<Inventory> getList = iInventoryService.listAll();
        if (getList == null) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registros")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(getList)
                .build()
                , HttpStatus.OK);
    }

    @PostMapping("producto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody InventoryDto inventoryDto) {
        Inventory inventorySave = null;
        try {
            inventorySave = iInventoryService.save(inventoryDto);

            return new ResponseEntity(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(InventoryDto.builder()
                            .id(inventorySave.getId())
                            .nombre(inventorySave.getNombre())
                            .cantidad(inventorySave.getCantidad())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);


        }
    }

    @PutMapping("producto/{id}")
    public ResponseEntity update(@RequestBody InventoryDto inventoryDto, @PathVariable Integer id) {
        Inventory inventoryUpdate = null;
        try {
            if (iInventoryService.existById(id)) {
                inventoryDto.setId(id);
                inventoryUpdate = iInventoryService.save(inventoryDto);


                return new ResponseEntity(MensajeResponse.builder()
                        .mensaje("Guardado correctamente")
                        .object(InventoryDto.builder()
                                .id(inventoryUpdate.getId())
                                .nombre(inventoryUpdate.getNombre())
                                .cantidad(inventoryUpdate.getCantidad())

                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("el registro que intenta actualizar no se encuentra en la base de datos")
                        .object(null)
                        .build()
                        , HttpStatus.NOT_FOUND);
            }


        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);

        }
    }

    @DeleteMapping("producto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Inventory inventoryDelete = iInventoryService.findById(id);
            iInventoryService.delete(inventoryDelete);
            return new ResponseEntity<>(inventoryDelete, HttpStatus.NO_CONTENT);

        } catch (DataAccessException exDt) {

            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @GetMapping("producto/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {

        Inventory producto = iInventoryService.findById(id);
        if (producto == null) {


                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("el registro que intenta buscar no existe")
                        .object(null)
                        .build()
                        , HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("")
                    .object(InventoryDto.builder()

                            .id(producto.getId())
                            .nombre(producto.getNombre())
                            .cantidad(producto.getCantidad())

                            .build())
                    .build()
                    , HttpStatus.OK);
        }
    }

