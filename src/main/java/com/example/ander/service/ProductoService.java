package com.example.ander.service;

import com.example.ander.domain.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();
    List<Producto> FindByName(String nombre);

    void delete (long id);
    void insert(Producto producto);

    boolean buscarByIdBoolean(long id);
    boolean buscarByNameBoolean(String nombre);
}
