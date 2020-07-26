
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

public class CursoDAOImple implements CursoDAO{

//    String URL = "jdbc:postgresql://localhost/cursos_online";
//    String USUARIO = "postgres";
//    String CLAVE = "1234";
    
    
    
    
    @Override
    public List<cursos> getCursos() {
        
        List<cursos> Curso = new ArrayList<>();
        Connection conn ;
        
        try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            System.out.println("Conexion Exitosa");
            
            String SQL = "SELECT id, nombre FROM cursos";
            PreparedStatement sentencia = conn.prepareStatement(SQL);
            ResultSet rset=sentencia.executeQuery();
            while (rset.next()){
                 cursos Cursos = new cursos(rset.getInt(1), rset.getString(2));
                 Curso.add(Cursos);
            }
            } catch (SQLException ex) {
            Logger.getLogger(CursoOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Curso;
    }

    @Override
    public void ingresar(cursos curso) {
        
       String query = "INSERT INTO cursos(nombre)VALUES(?);";
       Connection conn ;
        
        try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, curso.getNombre());
            sentencia.execute();
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void actualizar(cursos curso) {
        
        String query = "UPDATE public.cursos SET nombre=? WHERE id =?";
          Connection conn ;
        
        try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setString(1, curso.getNombre());
            sentencia.setInt(2, curso.getId());
            sentencia.execute();
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void eliminar(int id) {
        
        String query = "DELETE FROM public.cursos WHERE id=?";
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
    public List<Estudiante> getEstudiantePorCurso(int cursoId) {
          String query = "SELECT estudiantes.id, nombres, apellidos, correo\n" +
"	FROM public.estudiantes\n" +
"	inner join cursos_estudiantes on estudiantes.id = cursos_estudiantes.estudiante_id\n" +
"	where cursos_estudiantes.curso_id=?;";
        
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        
        Connection conn ;     
            try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);
            PreparedStatement sentencia = conn.prepareStatement(query);
            sentencia.setInt(1,cursoId);
            ResultSet rset=sentencia.executeQuery();
             while (rset.next()){
                Estudiante estudiante = new Estudiante (rset.getInt(1), rset.getString(2),rset.getString(3),rset.getString(4));
                 estudiantes.add(estudiante);
            }
            
            
    }   catch (SQLException ex) {
            Logger.getLogger(CursoDAOImple.class.getName()).log(Level.SEVERE, null, ex);
        }
         return estudiantes;
        
        
    }
    
}
