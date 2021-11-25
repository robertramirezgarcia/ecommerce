package com.ecommerce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Curso;
import com.ecommerce.service.ICursoService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api")
public class WebController {

	@Autowired
	private ICursoService cursoService;

	@GetMapping(value = "/cursos")
	public List<Curso> getAllCursos() {
		return cursoService.getAllCursos();
	}

	@PostMapping("/nuevocurso")
	public Curso createCurso(@RequestBody Curso curso) {
		return cursoService.saveCurso(curso);
	}

	@PutMapping("/cursos/{id}")
	public ResponseEntity<Curso> updateCurso(@PathVariable(value = "id") Long cursoId, @RequestBody Curso curso)
			throws ResourceNotFoundException {
		Curso cursoActualizado = cursoService.updateCurso(cursoId, curso);
		return ResponseEntity.ok(cursoActualizado);
	}
	
	@DeleteMapping("/curso/{id}")
	public Map<String,String> deleteCurso(@PathVariable(value = "id") Long cursoId) throws Exception {
		return cursoService.deleteCurso(cursoId);
	}

}
