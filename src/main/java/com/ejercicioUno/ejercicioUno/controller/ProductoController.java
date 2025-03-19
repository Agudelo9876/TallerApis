package com.ejercicioUno.ejercicioUno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.ejercicioUno.ejercicioUno.service.IProductoService;

public class ProductoController {
    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }


}
