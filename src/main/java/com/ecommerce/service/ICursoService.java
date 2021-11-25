package com.ecommerce.service;

import java.util.List;
import java.util.Map;

import com.ecommerce.model.Curso;

public interface ICursoService {

	List<Curso> getAllCursos();
	Curso saveCurso(Curso curso);
	Curso updateCurso(Long cursoId, Curso cursoDet);
	Map<String, String> deleteCurso(Long cursoId);
}