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
import br.com.informati.restaurantes.http.FormaPagamentoHttp;
import br.com.informati.restaurantes.http.PagamentoHttp;
import br.com.informati.restaurantes.modelo.FormaPagamentoEntity;
import br.com.informati.restaurantes.modelo.PagamentoEntity;
import br.com.informati.restaurantes.repositorio.FormaPagamentoDAO;
import br.com.informati.restaurantes.repositorio.PagamentoDAO;

/**
 * @author Flavius
 *
 */
@Path("/formaPagamento")
public class FormaPagamentoController implements IGenericoController<FormaPagamentoHttp> {

	private final FormaPagamentoDAO repositorio = new FormaPagamentoDAO();
	private final PagamentoDAO repositorioPagamento = new PagamentoDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(FormaPagamentoHttp formaHttp) {

		String msg = "Registro atualizado com sucesso!";
		FormaPagamentoEntity entidade = new FormaPagamentoEntity();

		try {

			// entidade.setId(formaHttp.getId());
			entidade.setNome(formaHttp.getNome());

			List<PagamentoEntity> listaPagamentos = new ArrayList<PagamentoEntity>();
			for (PagamentoHttp pagamentoHttp : formaHttp.getPagamentos()) {
				PagamentoEntity pagamentoEntity = new PagamentoEntity();
				pagamentoEntity = repositorioPagamento.consultarPorId(pagamentoHttp.getId());
				if (pagamentoEntity != null)
					listaPagamentos.add(pagamentoEntity);
			}
			entidade.setPagamentos(listaPagamentos);

			entidade.setIdUsuario(formaHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(formaHttp.getUltimaAtualizacao().getTime()));

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
	public String atualizar(FormaPagamentoHttp formaHttp) {
		String msg = "Registro atualizado com sucesso!";
		FormaPagamentoEntity entidade = new FormaPagamentoEntity();

		try {

			entidade.setId(formaHttp.getId());
			entidade.setNome(formaHttp.getNome());

			List<PagamentoEntity> listaPagamentos = new ArrayList<PagamentoEntity>();
			for (PagamentoHttp pagamentoHttp : formaHttp.getPagamentos()) {
				PagamentoEntity pagamentoEntity = new PagamentoEntity();
				pagamentoEntity = repositorioPagamento.consultarPorId(pagamentoHttp.getId());
				if (pagamentoEntity != null)
					listaPagamentos.add(pagamentoEntity);
			}
			entidade.setPagamentos(listaPagamentos);

			entidade.setIdUsuario(formaHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(formaHttp.getUltimaAtualizacao().getTime()));

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
	public List<FormaPagamentoHttp> consultarTodos() {
		List<FormaPagamentoHttp> listaFormas = new ArrayList<FormaPagamentoHttp>();

		List<FormaPagamentoEntity> listaEntidades = repositorio.consultarTodos();

		for (FormaPagamentoEntity entidade : listaEntidades) {

			FormaPagamentoHttp forma = FormaPagamentoHttp.converterEntity(entidade);

			listaFormas.add(forma);
		}

		return listaFormas;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public FormaPagamentoHttp consultarPorId(int id) {
		FormaPagamentoHttp forma = new FormaPagamentoHttp();

		FormaPagamentoEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			forma = FormaPagamentoHttp.converterEntity(entidade);
		}

		return forma;
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
