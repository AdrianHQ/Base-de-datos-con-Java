/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CursoDao;

import Util.util;
import curso.online.CursoOnline;
import entidades.Estudiante;
import entidades.cursos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EstudianteDAOImple implements EstudianteDAO{

    @Override
    public List<Estudiante> getEstudiante() {
      
//          String query ="SELECT *FROM public.estudiante";
          List<Estudiante> estudiantes = new ArrayList<>();
        Connection conn ;
        
        try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
//            System.out.println("Conexion Exitosa");
           
            String query ="SELECT id, nombres, apellidos, correo FROM public.estudiantes;";
            PreparedStatement sentencia = conn.prepareStatement(query);
            ResultSet rset=sentencia.executeQuery();
            while (rset.next()){
                 Estudiante estudiante = new Estudiante (rset.getInt(1), rset.getString(2), rset.getString(3),rset.getString(4));
                 estudiantes.add(estudiante);
            }
            } catch (SQLException ex) {
            Logger.getLogger(CursoOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudiantes;
    
        
    }

    @Override
    public void ingresar(Estudiante estudiantes) {
          String query ="INSERT INTO public.estudiantes(nombres, apellidos, correo)VALUES (?,?,?)";
          Connection conn ;
        
        try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, estudiantes.getNombres());
            sentencia.setString(2, estudiantes.getApellidos());
            sentencia.setString(3, estudiantes.getCorreo());
            sentencia.execute();
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void actualizar(Estudiante estudiantes) {
        
          String query = "UPDATE public.estudiantes SET nombres=?, apellidos=?, correo=? WHERE id=?;";
          Connection conn ;
           try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, estudiantes.getNombres());
            sentencia.setString(2, estudiantes.getApellidos());
            sentencia.setString(3, estudiantes.getCorreo());
            sentencia.setInt(4, estudiantes.getId());
            sentencia.execute();
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
             

    @Override
    public void eliminar(int id) {
        
        String query = "DELETE FROM public.estudiantes	WHERE id=?;";
        Connection conn ;     
            try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setInt(1,id);
            sentencia.execute();
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<cursos> getCursosPorEstudiante(int estudianteId) {
        
        String query = "SELECT cursos.id, nombre\n" +
"	FROM public.cursos\n" +
"	inner join cursos_estudiantes on cursos.id = cursos_estudiantes.curso_id\n" +
"	where estudiante_id=?;";
        
        List<cursos> curso = new ArrayList<cursos>();
        
        Connection conn ;     
            try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setInt(1,estudianteId);
            ResultSet rset=sentencia.executeQuery();
             while (rset.next()){
                cursos Cursos = new cursos (rset.getInt(1), rset.getString(2));
                 curso.add(Cursos);
            }
  
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }
    
}
