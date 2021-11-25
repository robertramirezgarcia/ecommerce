package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private long id;
	
	@Column(name = "nombre_curso", nullable = false)
	private String nombreCurso;
	
	@Column(name = "resumen", nullable = false)
	private String resumen;
	
	@Column(name = "imagen_promocional", nullable = false)
	private String imagenPromocional;
	
	@Column(name = "autor", nullable = false)
	private String autor;
	
	@Column(name = "calificacion", nullable = false)
	private Integer calificacion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getImagenPromocional() {
		return imagenPromocional;
	}

	public void setImagenPromocional(String imagenPromocional) {
		this.imagenPromocional = imagenPromocional;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

}
