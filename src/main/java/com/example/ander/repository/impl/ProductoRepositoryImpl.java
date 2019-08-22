package com.example.ander.repository.impl;

import com.example.ander.domain.Producto;
import com.example.ander.repository.ProductoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private static final Log LOG = LogFactory.getLog(ProductoRepositoryImpl.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Producto> findAll() {
        String sql = "select * from producto;";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    @Override
    public List<Producto> FindByName(String nombre) {
        String sql ="select * from producto where nombre like '%"+nombre+"%'";
        LOG.info("Producto Repository-Impl ");
        LOG.info("query: " +sql);
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    @Override
    public void delete(long id) {
        String sql="delete from producto where id = "+id+";";
        LOG.info("query: "+sql );
        this.jdbcTemplate.execute(sql);
        LOG.info("execute Ok , Eliminado Correctamente");
    }

    @Override
    public void insert(Producto producto) {
        // Registrado registro
        String codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        Boolean estado = producto.getEstado();
        String nombre = producto.getNombre();

        LOG.info("Registrando:");
        LOG.info("id: " + producto.getId());
        LOG.info("codigo: " + codigo);
        LOG.info("descrip: " + descripcion);
        LOG.info("Estado: " + estado);
        LOG.info("nombre: " + nombre);

        String sql = "insert into producto (codigo,descripcion,estado,nombre) values('" + codigo + "','"+ descripcion + "'," + estado + ",'" + nombre + "');";
        LOG.info("query: " + sql);
        this.jdbcTemplate.execute(sql);
        LOG.info("Registro OK");
    }

    @Override
      public boolean buscarByIdBoolean( long id) {
        boolean valorDelaVerdad = true;

        String sql = "SELECT * FROM producto where id =" + id + ";";
        LOG.info("query: " + sql);
        List datos = this.jdbcTemplate.queryForList(sql);

        LOG.info(datos);

        if (datos.isEmpty()) {
            valorDelaVerdad = false;
        } else {
            valorDelaVerdad = true;
        }
        return valorDelaVerdad;
    }

    @Override
    public boolean buscarByNameBoolean(String nombre) {

        boolean valorDelaVerdad = true;
        LOG.info("String nombre : " + nombre);

        String sql = "SELECT * FROM producto where nombre ='" + nombre + "';";
        LOG.info("query: " + sql);
        List datos = this.jdbcTemplate.queryForList(sql);

        LOG.info(datos);

        if (datos.isEmpty()) {
            valorDelaVerdad = true;
        } else {
            valorDelaVerdad = false;
        }

        return valorDelaVerdad;
    }


}
