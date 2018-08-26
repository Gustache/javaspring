package com.gustache.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustache.cursomc.domain.Categoria;
import com.gustache.cursomc.domain.Cidade;
import com.gustache.cursomc.domain.Cliente;
import com.gustache.cursomc.domain.Endereco;
import com.gustache.cursomc.domain.Estados;
import com.gustache.cursomc.domain.Produto;
import com.gustache.cursomc.domain.enums.TipoCliente;
import com.gustache.cursomc.repositories.CategoriaRepository;
import com.gustache.cursomc.repositories.CidadeRepository;
import com.gustache.cursomc.repositories.ClienteRepository;
import com.gustache.cursomc.repositories.EnderecoRepository;
import com.gustache.cursomc.repositories.EstadoRepository;
import com.gustache.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository cateroriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estados est1 = new Estados(null, "Minas Gerais");
		Estados est2 = new Estados(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2); //muitos pra 1, faz no proprio construtor
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		cateroriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2)); 
		cidadeRepository.saveAll(Arrays.asList(c1, c2));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "30293093", TipoCliente.PESSOAFISICA);		
		cli1.getTelefones().addAll(Arrays.asList("999566", "858585"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "3837378", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 303", "Centro", "84784784", cli1, c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));		
	}
}

