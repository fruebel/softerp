/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.jf.seguridad.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import soft.jf.seguridad.bd.ConnectionFactory;
import soft.jf.seguridad.modelos.contiposimpuesto;
import soft.jf.seguridad.modelos.invcategoriasproductos;
import soft.jf.seguridad.modelos.invproductos;
import soft.jf.seguridad.modelos.invtempproducto;
import soft.jf.seguridad.modelos.invunidadesmedida;

/**
 *
 * @author jbarrientos
 */
public class venbuscarproductosDAO {

    ConnectionFactory conexionFactory = new ConnectionFactory();

     public ArrayList<invproductos> consultarproductosavanzado(String idproducto, String descripcion) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<invproductos> lista = new ArrayList<>();

        if (conexion != null) {

            String where= "";     
            if (!idproducto.isEmpty())
                where = where + "p.idproducto like '%"+idproducto+"%'";
            if (!descripcion.isEmpty() && idproducto.isEmpty())
                 where = where + "p.descripcion like '%"+descripcion+"%'";   
            else if(!descripcion.isEmpty() && (!idproducto.isEmpty())) 
                where = where + "and p.descripcion like '%"+descripcion+"%'";   
            
            String sql = "select p.*,c.categoria,u.unidadmedida from invproductos p, invcategoriasproductos c,invunidadesmedida u "
                    + "where  p.idcategoria = c.idcategoria and u.idunidadmedida=p.idunidadmedida and (" + where + ")";

            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta productos " + sql);
            if (rs != null) {

                while (rs.next()) {

                    invproductos data = new invproductos();
                    data.setIdproducto(rs.getString("idproducto"));
                    
                    invcategoriasproductos idcategoria = new invcategoriasproductos();
                    idcategoria.setIdcategoria(rs.getString("idcategoria"));
                    idcategoria.setCategoria(rs.getString("categoria"));
                    data.setIdcategoria(idcategoria);
                    data.setDescripcion(rs.getString("descripcion"));
                    data.setCostoactual(rs.getFloat("costoactual"));
                    
                    invunidadesmedida idunidadmedida = new invunidadesmedida();
                    idunidadmedida.setIdunidadmedida(rs.getInt("idunidadmedida"));
                    idunidadmedida.setUnidadmedida(rs.getString("unidadmedida"));
                    data.setIdunidadmedida(idunidadmedida);
                    
                    lista.add(data);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }
    
    
    public int consultarproductoxid(String idproducto) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        int existe = 0;

        if (conexion != null) {
            String sql = "select count(*) as existe from invproductos where idproducto ='" + idproducto + "'";
            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta productos " + sql);
            if (rs != null) {
                while (rs.next()) {
                    existe = rs.getInt("existe");
                }
            }
        }

        return existe;
    }

    public ArrayList<invtempproducto> consultarproductos(String like, String usuario, int idsucursal) throws ClassNotFoundException, SQLException {

        Connection conexion = conexionFactory.conectar();
        ArrayList<invtempproducto> lista = new ArrayList<>();

        if (conexion != null) {

            String sql = "SELECT p.idproducto,p.costoactual as precio,i.cantidad as stock,1 as cantidad , 'codigo' as codigo,p.descripcion as nombreproducto,p.costoactual as preciounitario,"
                    + "            (1*p.costoactual) as total,a.almacen,ti.*"
                    + "            FROM seg_usuarios u "
                    + "                 join consucursales s on s.idsucursal = u.idsucursal"
                    + "                 join conalmacenes a on a.idsucursal = s.idsucursal  "
                    + "                 join invinventario i on i.idalmacen = a.idalmacen "
                    + "                 join invproductos p on p.idproducto = i.idproducto  "
                    + "                 join contiposimpuesto ti on ti.idtipoimpuesto = p.idtipoimpuesto  "
                    + "            where u.idusuario = '" + usuario + "' and s.idsucursal = " + idsucursal;

            ResultSet rs = conexionFactory.ejecutarConsulta(sql);

            System.out.println("Consulta productos " + sql);
            if (rs != null) {

                while (rs.next()) {

                    invtempproducto data = new invtempproducto();

                    data.setIdproducto(rs.getString("idproducto"));
                    data.setCantidad(rs.getInt("cantidad"));
                    data.setCodigo(rs.getString("codigo"));
                    data.setNombreproducto(rs.getString("nombreproducto"));
                    data.setPrecio(rs.getString("precio"));
                    data.setPreciounitario(rs.getString("preciounitario"));
                    data.setStock(rs.getString("stock"));
                    data.setTotal(rs.getString("total"));
                    data.setAlmacen(rs.getString("almacen"));

                    contiposimpuesto impuesto = new contiposimpuesto();
                    impuesto.setIdtipoimpuesto(rs.getInt("idtipoimpuesto"));
                    impuesto.setPorcentaje(rs.getDouble("porcentaje"));
                    impuesto.setTipoimpuesto(rs.getString("tipoimpuesto"));
                    data.setIdtipoimpuesto(impuesto);

                    lista.add(data);
                }

            }
            conexionFactory.desconectar();
        } else {
            return null;
        }

        return lista;

    }

}
