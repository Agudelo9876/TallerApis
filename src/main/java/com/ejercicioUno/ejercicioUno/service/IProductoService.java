package com.ejercicioUno.ejercicioUno.service;

import java.util.List;
import com.ejercicioUno.ejercicioUno.models.Producto;

public interface IProductoService {
    Producto save(Producto producto);
    Producto findById(String id);
    Producto findByAuthToken(String token);
    List<Producto> findForFilter(String categoria);
    Producto update(Producto producto);
    void delete(String id);
}
