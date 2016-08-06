/**
 * 
 */
package br.com.informati.restaurantes.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.informati.restaurantes.http.MesaHttp;
import br.com.informati.restaurantes.http.PracaAlimentacaoHttp;
import br.com.informati.restaurantes.modelo.MesaEntity;
import br.com.informati.restaurantes.modelo.PracaAlimentacaoEntity;
import br.com.informati.restaurantes.repositorio.PracaAlimentacaoDAO;

/**
 * @author Flavius
 *
 */
public class PracaAlimentacaoController implements IGenericoController<PracaAlimentacaoHttp> {

	public final PracaAlimentacaoDAO repositorio = new PracaAlimentacaoDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(PracaAlimentacaoHttp praca) {
		String msg = "Registro atualizado com sucesso!";
		PracaAlimentacaoEntity entidade = new PracaAlimentacaoEntity();

		try {

			//entidade.setId(praca.getId());
			entidade.setNome(praca.getNome());

			// TODO Restaurantes
			// entidade.setRestaurantes(restaurantes);

			entidade.setIdUsuario(praca.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(praca.getUltimaAtualizacao().getTime()));

			repositorio.atualizar(entidade);

		} catch (Exception e) {

			msg = "Erro ao alterar o registro " + e.getMessage();

		}

		return msg;
	}

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/atualizar")
	public String atualizar(PracaAlimentacaoHttp praca) {

		String msg = "Registro atualizado com sucesso!";
		PracaAlimentacaoEntity entidade = new PracaAlimentacaoEntity();

		try {

			entidade.setId(praca.getId());
			entidade.setNome(praca.getNome());

			// TODO Restaurantes
			// entidade.setRestaurantes(restaurantes);

			entidade.setIdUsuario(praca.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(praca.getUltimaAtualizacao().getTime()));

			repositorio.atualizar(entidade);

		} catch (Exception e) {

			msg = "Erro ao alterar o registro " + e.getMessage();

		}

		return msg;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodos")
	public List<PracaAlimentacaoHttp> consultarTodos() {
		List<PracaAlimentacaoHttp> listaPracas = new ArrayList<PracaAlimentacaoHttp>();

		List<PracaAlimentacaoEntity> listaEntidades = repositorio.consultarTodos();

		for (PracaAlimentacaoEntity entidade : listaEntidades) {

			PracaAlimentacaoHttp praca = PracaAlimentacaoHttp.converterEntity(entidade);

			listaPracas.add(praca);
		}

		return listaPracas;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public PracaAlimentacaoHttp consultarPorId(int id) {
		PracaAlimentacaoHttp praca = new PracaAlimentacaoHttp();

		PracaAlimentacaoEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			praca = PracaAlimentacaoHttp.converterEntity(entidade);
		}

		return praca;
	}

	@Override
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")
	public String excluir(int id) {

		String msg = "Registro excluído com sucesso!";
		try {

			repositorio.excluir(id);

		} catch (Exception e) {

			msg = "Erro ao excluir o registro! " + e.getMessage();
		}

		return msg;

	}

}
