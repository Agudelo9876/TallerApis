package com.ejercicioUno.ejercicioUno.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.ejercicioUno.ejercicioUno.models.Producto;

@Repository
public class UsuarioRepository {
    
     // Simulamos una base de datos con un Map
    private final Map<String, Producto> baseDeDatos = new HashMap<>();

    // Simulamos almacén de tokens de autorización
    private final Map<String, String> authTokens = new HashMap<>();

     // Simulamos almacén de permisos de usuario
    private final Map<String, List<String>> permisos = new HashMap<>();
    
    // Simulamos almacén de accesos de usuario
    private final Map<String, List<Map<String, Object>>> accesos = new HashMap<>();
    
    // Simulamos almacén de preferencias de usuario
    private final Map<String, Map<String, Object>> preferencias = new HashMap<>();
    
    // Simulamos histórico de estados
    private final Map<String, List<Map<String, Object>>> statusHistorial = new HashMap<>();
    
    // Simulamos documentos de usuario
    private final Map<String, List<Map<String, Object>>> documentos = new HashMap<>();

    //Guardar producto
    public Producto save(Producto producto) {
        baseDeDatos.put(producto.getId(), producto);
        // Inicializamos estructuras relacionadas
        authTokens.put("token-" + producto.getId(), producto.getId());
        permisos.put(producto.getId(), new ArrayList<>());
        accesos.put(producto.getId(), new ArrayList<>());
        preferencias.put(producto.getId(), new HashMap<>());
        statusHistorial.put(producto.getId(), new ArrayList<>());
        documentos.put(producto.getId(), new ArrayList<>());
        return producto;
    }

    // Encontrar usuario por ID
    public Producto findById(String id) {
        return baseDeDatos.get(id);
    }
    
    // Listar todos los usuarios
    public List<Producto> findAll() {
        return new ArrayList<>(baseDeDatos.values());
    }
    
    // Eliminar un usuario
    public void deleteById(String id) {
        baseDeDatos.remove(id);
        authTokens.remove("token-" + id);
        permisos.remove(id);
        accesos.remove(id);
        preferencias.remove(id);
        statusHistorial.remove(id);
        documentos.remove(id);
    }
    
    // Actualizar un usuario
    public Producto update(Producto producto) {
        if (baseDeDatos.containsKey(producto.getId())) {
            baseDeDatos.put(producto.getId(), producto);
            return producto;
        }
        return null;
    }
    
    // Buscar usuarios por filtros
    public List<Producto> findForFilter(String categoria) {
        return baseDeDatos.values().stream()
                .filter(u -> categoria == null || u.getCategoria().contains(categoria))
                .collect(Collectors.toList());
    }
    
    
    // Encontrar usuario por token de autorización
    public Producto findByAuthToken(String authToken) {
        String productoId = authTokens.get(authToken);
        if (productoId != null) {
            return baseDeDatos.get(productoId);
        }
        return null;
    }
    
    // Establecer permisos para un usuario
    public void setPermisos(String id, List<String> nuevosPermisos) {
        permisos.put(id, nuevosPermisos);
    }
    
    // Registrar un nuevo acceso
    public void registrarAcceso(String id, Map<String, Object> nuevoAcceso) {
        List<Map<String, Object>> accesosUsuario = accesos.getOrDefault(id, new ArrayList<>());
        accesosUsuario.add(0, nuevoAcceso); // Añadir al principio (más reciente)
        accesos.put(id, accesosUsuario);
    }
    }

