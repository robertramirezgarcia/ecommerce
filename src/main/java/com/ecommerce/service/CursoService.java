package com.ecommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Curso;
import com.ecommerce.repository.CursoRepository;

@Transactional
@Service
public class CursoService implements ICursoService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CursoService.class);
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<Curso> getAllCursos(){
		return cursoRepository.findAll();
	}
	
	@Override
	public Curso saveCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Override
	public Curso updateCurso(Long cursoId, Curso cursoDet) {
		Curso cursoActualizado = new Curso();
		try {
			Curso curso = new Curso();
			curso = cursoRepository.findById(cursoId).orElseThrow(()-> new ResourceNotFoundException("Curso no encontrado: " + cursoId));
			curso.setNombreCurso(cursoDet.getNombreCurso());
			curso.setResumen(cursoDet.getResumen());
			curso.setImagenPromocional(cursoDet.getImagenPromocional());
			curso.setAutor(cursoDet.getAutor());
			curso.setCalificacion(cursoDet.getCalificacion());
			cursoActualizado = cursoRepository.save(curso);
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Error al actualizar el curso" , e);
		}
		return cursoActualizado;
	}
	
	@Override
	public Map<String, String> deleteCurso(Long cursoId){
		Map<String, String> response = new HashMap<String, String>();
		try {
			Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado"));
			cursoRepository.delete(curso);
			response.put("eliminado", "ok");
		} catch (ResourceNotFoundException e) {
			response.put("eliminado", "error");
			LOGGER.error("Error al eliminar el curso");
		}
		return response;
	}
	
}
