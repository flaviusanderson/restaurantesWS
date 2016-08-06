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
import br.com.informati.restaurantes.http.MesaHttp;
import br.com.informati.restaurantes.modelo.FormaPagamentoEntity;
import br.com.informati.restaurantes.modelo.MesaEntity;
import br.com.informati.restaurantes.repositorio.FormaPagamentoDAO;

/**
 * @author Flavius
 *
 */
public class FormaPagamentoController implements IGenericoController<FormaPagamentoHttp> {
	
	public final FormaPagamentoDAO repositorio = new FormaPagamentoDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(FormaPagamentoHttp formaHttp) {
		
		String msg = "Registro atualizado com sucesso!";
		FormaPagamentoEntity entidade = new FormaPagamentoEntity();

		try {

			//entidade.setId(formaHttp.getId());
			entidade.setNome(formaHttp.getNome());
			
			// TODO Forma Pagamento
			//entidade.setPagamentos(pagamentos);
			
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
			
			// TODO Forma Pagamento
			//entidade.setPagamentos(pagamentos);
			
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
