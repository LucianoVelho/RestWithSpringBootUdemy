/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.luciano.cursome.resource;

import br.com.luciano.cursome.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
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
    
    @RequestMapping(method = RequestMethod.GET )
    public List<Categoria> listar(){
        Categoria cat = new Categoria(1 , "Informatica");
        Categoria cat2 = new Categoria(2, "Escritorio");
        
        List<Categoria>categoriasList = new ArrayList<>();
        categoriasList.add(cat);
        categoriasList.add(cat2);
        
        return categoriasList;
    }
    
}
