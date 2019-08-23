package com.example.ander.controller;

import com.example.ander.domain.Producto;
import com.example.ander.service.ProductoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// rest
@RestController

@RequestMapping("api") //mapeo principal
public class ProductoController {
    private static final Log LOG = LogFactory.getLog(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @GetMapping("/list")
    public List<Producto> listAll(){
        List<Producto> productos = productoService.findAll();
        return productos;
    }

    @GetMapping("/buscar/{nombre}")
    public  List<Producto> FindByName(@PathVariable String nombre){
        List<Producto> productos = productoService.FindByName(nombre);
        return productos;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        if(productoService.buscarByIdBoolean(id)){
            productoService.delete(id);
            return "Producto Eliminado Correctamente";
        }else{
            return "Producto con ID: "+id+" no registrado";
        }

    }

    @PostMapping("/insert")
    public String insert(@RequestBody Producto producto) {

        LOG.info("Enviando:");

        String codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        Boolean estado = producto.getEstado();
        String nombre = producto.getNombre();

        LOG.info("id: " + producto.getId());
        LOG.info("codigo: " + codigo);
        LOG.info("descrip: " + descripcion);
        LOG.info("Estado: " + estado);
        LOG.info("nombre: " + nombre);

        // IS TRUE
        if (productoService.buscarByNameBoolean( nombre)) {
            productoService.insert(producto);
            return "Producto: " + nombre + " Registrado Correctamente";
        }else {
            return "El producto con nombre: " + nombre + " ya se encuentra registrado";
        }
    }

}
