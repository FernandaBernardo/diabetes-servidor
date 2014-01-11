package biblioteca.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import biblioteca.dao.PublicacaoDao;
import biblioteca.model.AnaisConferencia;
import biblioteca.model.ArtigoAnal;
import biblioteca.model.ArtigoLivro;
import biblioteca.model.ArtigoPeriodico;
import biblioteca.model.Livro;
import biblioteca.model.Monografia;
import biblioteca.model.Periodico;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class CadastrosController {
	
	@Inject private PublicacaoDao dao;
	@Inject private Result result;

	@Get
	public void livro() {
	}
	
	@Post
	public void adicionaLivro(String titulo, String data, String local, String biblioteca, String secao, String edicao,
		String autores, String tituloOriginal, String numeroEdicao, String editora, String numeroPaginas) throws ParseException {
		Livro livro = new Livro();
		livro.setTitulo(titulo);
		livro.setData(parseData(data));
		livro.setLocal(local);
		livro.setBiblioteca(dao.buscaBiblioteca(biblioteca));
		livro.setSecao(dao.buscaSecao(secao));
		livro.setTituloOriginal(tituloOriginal);
		livro.setNumeroEdicao(Integer.parseInt(numeroEdicao));
		livro.setEditora(editora);
		livro.setNumeroPaginas(Integer.parseInt(numeroPaginas));
		
		//VER AUTORES
		
		dao.adiciona(livro);
		
		result.include("tituloLivro", livro.getTitulo());
	}

	
	@Get
	public void monografia() {
	}
	
	@Post
	public void adicionaMonografia(String titulo, String data, String local, String biblioteca, String secao, String edicao,
			String autores, String nomeInstituicao, String numeroMonografia) throws ParseException {
		Monografia monografia = new Monografia();
		monografia.setTitulo(titulo);
		monografia.setData(parseData(data));
		monografia.setLocal(local);
		monografia.setBiblioteca(dao.buscaBiblioteca(biblioteca));
		monografia.setSecao(dao.buscaSecao(secao));
		monografia.setEdicao(Integer.parseInt(edicao));
		monografia.setNomeInstituicao(nomeInstituicao);
		monografia.setNumeroMonografia(Integer.parseInt(numeroMonografia));

		//VER AUTORES
		
		dao.adiciona(monografia);
		
		result.include("tituloMonografia", monografia.getTitulo());
	}
	
	@Get
	public void periodico() {
	}
	
	@Post
	public void adicionaPeriodico(String titulo, String data, String local, String biblioteca, String secao, String edicao,
			String editora) throws ParseException {
		Periodico periodico = new Periodico();
		periodico.setTitulo(titulo);
		periodico.setData(parseData(data));
		periodico.setLocal(local);
		periodico.setBiblioteca(dao.buscaBiblioteca(biblioteca));
		periodico.setSecao(dao.buscaSecao(secao));
		periodico.setEdicao(Integer.parseInt(edicao));
		periodico.setEditora(editora);

		//VER AUTORES
		
		dao.adiciona(periodico);
		
		result.include("tituloPeriodico", periodico.getTitulo());
	}
	
	@Get
	public void anaisConferencia() {
	}
	
	@Post
	public void adicionaAnaisConferencia(String titulo, String data, String local, String biblioteca, String secao, String edicao,
			String artigos, String editora, String numeroVolume) throws ParseException {
		AnaisConferencia anal = new AnaisConferencia();
		anal.setTitulo(titulo);
		anal.setData(parseData(data));
		anal.setLocal(local);
		anal.setBiblioteca(dao.buscaBiblioteca(biblioteca));
		anal.setSecao(dao.buscaSecao(secao));
		anal.setEdicao(Integer.parseInt(edicao));
		anal.setEditora(editora);
		anal.setNumeroVolume(Integer.parseInt(numeroVolume));

		//VER ARTIGOS
		
		dao.adiciona(anal);
		
		result.include("tituloAnal", anal.getTitulo());
	}
	
	@Get
	public void artigoLivro() {
	}
	
	@Post
	public void adicionaArtigoLivro(ArtigoLivro artigoLivro) {
		dao.adiciona(artigoLivro);
	}
	
	@Get
	public void artigoPeriodico() {
	}
	
	@Post
	public void adicionaArtigoPeriodico(ArtigoPeriodico artigoPeriodico) {
		dao.adiciona(artigoPeriodico);
	}
	
	@Get
	public void artigoAnal() {
	}
	
	@Post
	public void adicionaArtigoAnal(ArtigoAnal artigoAnal) {
		dao.adiciona(artigoAnal);
	}
	
	private Calendar parseData(String data) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime((Date) new SimpleDateFormat("dd/MM/yyyy").parse(data));
		return cal;
	}
}
