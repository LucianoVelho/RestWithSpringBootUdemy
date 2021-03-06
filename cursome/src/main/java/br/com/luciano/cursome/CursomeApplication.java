package br.com.luciano.cursome;

import br.com.luciano.cursome.domain.Categoria;
import br.com.luciano.cursome.domain.Cidade;
import br.com.luciano.cursome.domain.Estado;
import br.com.luciano.cursome.domain.Produto;
import br.com.luciano.cursome.repository.CategoriaRepository;
import br.com.luciano.cursome.repository.CidadeRepository;
import br.com.luciano.cursome.repository.EstadoRepository;
import br.com.luciano.cursome.repository.ProdutoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomeApplication implements CommandLineRunner{
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomeApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
       Integer id = 1;
        if(!categoriaRepository.existsById(id)){
            
            Categoria cat1 = new Categoria(null, "Informatica");
            Categoria cat2 = new Categoria(null, "Escritorio");
            
            Produto p1 = new Produto(null, "Computador",2000.00);
            Produto p2 = new Produto(null, "Impressora",800.00);
            Produto p3 = new Produto(null, "Mouse",80.00);
            
            cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
            cat2.getProdutos().addAll(Arrays.asList(p2));
            
            p1.getCategorias().addAll(Arrays.asList(cat1));
            p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
            p2.getCategorias().addAll(Arrays.asList(cat1));
            
            categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
            produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
            
            Estado est1 = new Estado(null,"Minas Gerais");
            Estado est2 = new Estado(null,"S??o Paulo");
            
            Cidade c1 = new Cidade(null,"Urbelandia", est1);
            Cidade c2 = new Cidade(null,"S??o Paulo", est2);
            Cidade c3 = new Cidade(null,"Campinas", est2);
            
            est1.getCidades().addAll(Arrays.asList(c1));
            est2.getCidades().addAll(Arrays.asList(c2,c3));
            
            estadoRepository.saveAll(Arrays.asList(est1,est2));
            cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
            
        }
        
       
        
    }

}
