
package curso.online;

import CursoDao.CursoDAO;
import CursoDao.CursoDAOImple;
import CursoDao.EstudianteDAO;
import CursoDao.EstudianteDAOImple;
import entidades.Estudiante;
import entidades.cursos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CursoOnline {

    static String URL = "jdbc:postgresql://localhost/clases_online";
    static String USUARIO = "postgres";
    static String CLAVE = "1234";
    
    public static void main(String[] args) {
        
        
        EstudianteDAO estudianteDAO = new EstudianteDAOImple();
//        Estudiante newEstudiante = new Estudiante(0,"RONALD","HOLGUIN","ronald@holguin");
//        estudianteDAO.ingresar(newEstudiante);
//        estudianteDAO.eliminar(5);
        
        List <Estudiante> estu = estudianteDAO.getEstudiante();
        System.out.println(estu);
               
        
        CursoDAO cursoDAO = new CursoDAOImple();
//        cursos newCurso = new cursos(0,"INTERFACES");
//        cursoDAO.ingresar(newCurso);
//        cursoDAO.eliminar(7);
      
        List <cursos> curso = cursoDAO.getCursos();
        System.out.println(curso);
        
//        curso = cursoDAO.getCursos();
//        System.out.println(curso.size());
//        
        
        
        
//        Connection conn ; 
//        //PreparedStatement sentencia;
//        //ResultSet rset;
//        
//        try {
//            conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
//            System.out.println("Conexion Exitosa");
//            
//            String SQL = "SELECT idc, nombre FROM cursos";
//            PreparedStatement sentencia = conn.prepareStatement(SQL);
//            ResultSet rset=sentencia.executeQuery();
//            while (rset.next()){
//                 System.out.println(rset.getInt(1)+ " " + rset.getString(2));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CursoOnline.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    
}
