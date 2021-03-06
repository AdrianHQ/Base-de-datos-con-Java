/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Estudiante {
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private List<cursos> curso = new ArrayList<>(); 
    
    public Estudiante() {}

    public Estudiante(int id, String nombres, String apellidos, String correo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
    }
    

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<cursos> getCurso() {
        return curso;
    }

    public void setCurso(List<cursos> curso) {
        this.curso = curso;
    }

    
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + '}';
    }
    
    
}