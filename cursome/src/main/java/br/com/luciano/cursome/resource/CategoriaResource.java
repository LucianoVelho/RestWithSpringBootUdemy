/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.luciano.cursome.resource;

import br.com.luciano.cursome.domain.Categoria;
import br.com.luciano.cursome.repository.CategoriaRepository;
import br.com.luciano.cursome.services.CategoriaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luciano Velho Garcia
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    
    @Autowired
    CategoriaService  categoriaService; 
    @Autowired
    CategoriaRepository categoriaRepository; 
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<?> find(@PathVariable long id){
        Categoria cat = categoriaService.buscar(id);
        return ResponseEntity.ok().body(cat);
    }
    
    @RequestMapping(value = "/addCategoria", method = RequestMethod.GET )
    public ResponseEntity<?> add(){
        
        Categoria cat1 = new Categoria();
        cat1.setNome("Infomatica");
        
        Categoria cat2 = new Categoria();
        cat2.setNome("Escritorio");
       
        categoriaRepository.save(cat1);
        categoriaRepository.save(cat2);
        
        return ResponseEntity.ok().body("Adicionado Categoria");
    }
    
    @RequestMapping(value = "/todos", method = RequestMethod.GET )
    public ResponseEntity<?>  todos(){
       
        return  ResponseEntity.ok().body(categoriaRepository.findAll());
    }
    
    
    
}
