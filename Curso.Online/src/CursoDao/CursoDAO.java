
package CursoDao;

import entidades.Estudiante;
import entidades.cursos;
import java.util.List;


public interface CursoDAO {
    
    
//    List <cursos> getCursos();
    void ingresar(cursos curso);
    void actualizar(cursos curso);
    void eliminar(int id);
    List<cursos> getCursos();
    List<Estudiante> getEstudiantePorCurso(int cursoId);
    
}
