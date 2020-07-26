
package entidades;


public class CursoEstudiante {
    
    private int id;
	private int cursos_id;
	private int esudiantes_id;
	public int getId() {
		return id;}
        
        
    public CursoEstudiante() {}

    public CursoEstudiante(int id, int cursos_id, int esudiantes_id) {
        this.id = id;
        this.cursos_id = cursos_id;
        this.esudiantes_id = esudiantes_id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public void setCursos_id(int cursos_id) {
        this.cursos_id = cursos_id;
    }

    public void setEsudiantes_id(int esudiantes_id) {
        this.esudiantes_id = esudiantes_id;
    }

    public int getCursos_id() {
        return cursos_id;
    }

    public int getEsudiantes_id() {
        return esudiantes_id;
    }
    
    	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cursos_id;
		result = prime * result + esudiantes_id;
		result = prime * result + id;
		return result;
	}
    	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoEstudiante other = (CursoEstudiante) obj;
		if (cursos_id != other.cursos_id)
			return false;
		if (esudiantes_id != other.esudiantes_id)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
        @Override
	public String toString() {
		return "cursos_estudiantes [id=" + id + ", cursos_id=" + cursos_id + ", esudiantes_id=" + esudiantes_id + "]";
	}
}
