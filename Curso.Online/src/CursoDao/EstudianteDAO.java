/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CursoDao;

import entidades.Estudiante;
import entidades.cursos;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface EstudianteDAO {
    
    //List <Estudiante> getEstudiante();
    void ingresar(Estudiante estudiantes);
    void actualizar(Estudiante estudiantes);
    void eliminar(int id);
    List<cursos> getCursosPorEstudiante(int estudianteId);
    List<Estudiante> getEstudiante();
}
