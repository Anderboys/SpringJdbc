package com.example.ander.service.impl;

import com.example.ander.domain.Producto;
import com.example.ander.repository.ProductoRepository;
import com.example.ander.service.ProductoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {
    private static final Log LOG = LogFactory.getLog(ProductoServiceImpl.class);

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> findAll() {
        LOG.info("en ProductoServiceImpl --> method  findAll");
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> FindByName(String nombre) {
        LOG.info("en ProductoServiceImpl --> method  FindByName");
        return productoRepository.FindByName(nombre);
    }

    @Override
    public void delete(long id) {
        productoRepository.delete(id);
    }

    @Override
    public void insert(Producto producto) {
        productoRepository.insert(producto);
    }


    @Override
    public boolean buscarByIdBoolean(long id) {
        return productoRepository.buscarByIdBoolean(id);
    }

    @Override
    public boolean buscarByNameBoolean( String nombre) {
        return productoRepository.buscarByNameBoolean(nombre);
    }


}
