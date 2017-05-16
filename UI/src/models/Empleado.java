package models;

import exceptions.NoRellenadoException;
import models.Empleado.Tipo;

public class Empleado {
	public static enum Tipo { JEFE_SUPREMO, CURRANTE, PROGRAMADOR, BECARIO };
	private String nombre, apellidos;
	private String antiguedad;
	private Tipo puesto;
	private boolean hombre;
	private boolean vacaciones;
	private int sueldo;
	private String comentarios;
	
	public Empleado(String nombre, String apellidos, String antiguedad, Tipo puesto, boolean hombre, boolean vacaciones,
			int sueldo, String comentarios) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.antiguedad = antiguedad;
		this.puesto = puesto;
		this.hombre = hombre;
		this.vacaciones = vacaciones;
		this.sueldo = sueldo;
		this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public Tipo getPuesto() {
		return puesto;
	}
	
	public int getPuestoSeleccionado(){
		switch (puesto) {
		case JEFE_SUPREMO:
			return 0;
		case CURRANTE:
			return 1;
		case PROGRAMADOR:
			return 2;
		case BECARIO:
			return 3;
		default:
			throw new NoRellenadoException("El campo 'Puesto' no está asignado.");
		}
	}

	public boolean isHombre() {
		return hombre;
	}

	public boolean isVacaciones() {
		return vacaciones;
	}

	public int getSueldo() {
		return sueldo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setPuesto(Tipo puesto) {
		this.puesto = puesto;
	}

	public void setHombre(boolean hombre) {
		this.hombre = hombre;
	}

	public void setVacaciones(boolean vacaciones) {
		this.vacaciones = vacaciones;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", antiguedad=" + antiguedad + ", puesto=" + puesto + ", hombre=" + hombre
				+ ", sueldo=" + sueldo + ", comentarios=" + comentarios + "]";
	}
	
	
}
