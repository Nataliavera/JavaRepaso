package com.educacionit.modelos;

//REPRESENTA LA TABLA DE LA DB
//VO = VALUE OBJECT
public class PersonaVO {

	private Integer idPersona; 
	private String nombre; 
	private Integer edad; 
	private String profesion; 
	private Integer telefono;
	
	public PersonaVO() {
		
	}
	
	public PersonaVO(String nombre, Integer edad, String profesion, Integer telefono) {
		this.nombre = nombre;
		this.edad = edad;
		this.profesion = profesion;
		this.telefono = telefono;
	}
	

	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	} 
	
	
	
}
