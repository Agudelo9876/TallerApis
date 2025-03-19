package com.ejercicioUno.ejercicioUno.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ejercicioUno.ejercicioUno.models.Producto;
import com.ejercicioUno.ejercicioUno.repositories.UsuarioRepository;

public class ProductoService implements IProductoService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ProductoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Producto save(Producto producto){
        return usuarioRepository.save(producto);
    }

    public Producto findById(String id){
        return usuarioRepository.findById(id);
    }

    public Producto findByAuthToken(String token){
        return usuarioRepository.findByAuthToken(token);
    }

    public List<Producto> findForFilter(String categoria){
        return usuarioRepository.findForFilter(categoria);
    }

    public Producto update(Producto producto){
        return usuarioRepository.update(producto);
    }

    public void delete(String id){
        usuarioRepository.deleteById(id);
    }
}