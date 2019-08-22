package com.example.ander.repository;

import com.example.ander.domain.Producto;

import java.util.List;

public interface ProductoRepository {

List<Producto> findAll();
List<Producto> FindByName(String nombre);
void delete (long id);
void insert(Producto producto);
boolean buscarByIdBoolean(long id);
boolean buscarByNameBoolean(String nombre);
}
