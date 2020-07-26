/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CursoDao;

import Util.util;
import entidades.CursoEstudiante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class cursoEstudianteDAOImple implements cursoEstudianteDAO {

    @Override
    public List<CursoEstudiante> getCursos_estudiante() {
        
        List<CursoEstudiante> estudiante = new ArrayList<>();
        Connection conn;
            try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);

            String SQL = "SELECT id, curso_id, estudiante_id FROM public.cursos_estudiantes;";

            PreparedStatement stm = conn.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CursoEstudiante estudiant = new CursoEstudiante(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                estudiante.add(estudiant);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudiante;

        
        
    }

    @Override
    public void ingresar(CursoEstudiante curestu) {
        String query ="INSERT INTO public.cursos_estudiantes(curso_id, estudiante_id) VALUES ( ?, ?);";
        Connection conn;
          try {
            conn = DriverManager.getConnection(util.URL, util.USUARIO, util.CLAVE);

            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, curestu.getCursos_id());
            stm.setInt(2, curestu.getEsudiantes_id());

            stm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(CursoEstudiante curestu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
