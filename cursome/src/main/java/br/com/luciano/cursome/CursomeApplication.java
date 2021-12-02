package br.com.luciano.cursome;

import br.com.luciano.cursome.domain.Categoria;
import br.com.luciano.cursome.repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomeApplication implements CommandLineRunner{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomeApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
       Integer id = 1;
        if(!categoriaRepository.existsById(id)){
            
            Categoria cat1 = new Categoria(null, "Informatica");
            Categoria cat2 = new Categoria(null, "Escritorio");
        
            categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
            
        }
        
       
        
    }

}
