package com.ejercicioUno.ejercicioUno.service;

import java.util.List;

public interface IProductoService {
    Producto save(Producto producto);
    Producto findById(String id);
    Producto findByAuthToken(String token);
    List<Producto> findForFilter(String categoria);
}
