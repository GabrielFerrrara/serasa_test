package com.serasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serasa.dto.VendedorDTO;
import com.serasa.dto.VendedoresDTO;
import com.serasa.model.Vendedor;
import com.serasa.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vendedor> salvar(@RequestBody Vendedor vendedor) {
        vendedorService.salvar(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<VendedoresDTO>> listarTodos() {
        List<VendedoresDTO> vendedores = vendedorService.listarTodos();
        if (vendedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(vendedores);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> buscarPorId(@PathVariable Long id) {
        VendedorDTO vendedor = vendedorService.buscarPorId(id);
        if (vendedor != null) {
            return ResponseEntity.ok(vendedor);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}