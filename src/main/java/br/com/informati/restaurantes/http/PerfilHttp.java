package br.com.informati.restaurantes.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.informati.restaurantes.modelo.PerfilEntity;
import br.com.informati.restaurantes.modelo.UsuarioEntity;

/**
 * @author Flavius
 *
 */
@XmlRootElement
public class PerfilHttp extends GenericoHttp {

	private int id;
	private String nome;
	private List<UsuarioHttp> usuarios;

	public static PerfilHttp converterEntity(PerfilEntity entidade) {

		PerfilHttp perfil = new PerfilHttp();

		perfil.setId(entidade.getId());
		perfil.setNome(entidade.getNome());
		perfil.setIdUsuario(entidade.getIdUsuario());
		perfil.setUltimaAtualizacao(entidade.getUltimaAtualizacao());

		List<UsuarioHttp> listaAux = new ArrayList<UsuarioHttp>();

		for (UsuarioEntity usuario : entidade.getUsuarios()) {

			UsuarioHttp aux = new UsuarioHttp();

			aux = UsuarioHttp.converterEntity(usuario);

			listaAux.add(aux);

		}

		perfil.setUsuarios(listaAux);

		return perfil;

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the usuarios
	 */
	public List<UsuarioHttp> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<UsuarioHttp> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @param id
	 * @param nome
	 */
	public PerfilHttp(int id, String nome, List<UsuarioHttp> usuarios, Date ultimaAtualizacao, int idUsuario) {
		super(ultimaAtualizacao, idUsuario);
		this.id = id;
		this.nome = nome;
		this.usuarios = usuarios;
	}

	/**
	 * 
	 */
	public PerfilHttp() {
		super();
	}

}
