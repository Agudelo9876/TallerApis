package com.ejercicioUno.ejercicioUno.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServicio {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ProductoServicio(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Producto Save(Producto producto){
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


}