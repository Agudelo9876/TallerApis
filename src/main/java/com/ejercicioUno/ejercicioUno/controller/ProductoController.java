package com.ejercicioUno.ejercicioUno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicioUno.ejercicioUno.service.IProductoService;

@RestController
public class ProductoController {
    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }


}
