/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CursoDao;

import entidades.CursoEstudiante;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface cursoEstudianteDAO {
    	List<CursoEstudiante> getCursos_estudiante();
	public void ingresar(CursoEstudiante curestu);
	public void actualizar(CursoEstudiante curestu);
	public void eliminar(int id);
}
