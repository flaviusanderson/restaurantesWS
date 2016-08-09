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

import br.com.informati.restaurantes.http.CategoriaHttp;
import br.com.informati.restaurantes.http.PagamentoHttp;
import br.com.informati.restaurantes.modelo.CategoriaEntity;
import br.com.informati.restaurantes.modelo.FormaPagamentoEntity;
import br.com.informati.restaurantes.modelo.PagamentoEntity;
import br.com.informati.restaurantes.modelo.PedidoEntity;
import br.com.informati.restaurantes.modelo.RestauranteEntity;
import br.com.informati.restaurantes.repositorio.FormaPagamentoDAO;
import br.com.informati.restaurantes.repositorio.PagamentoDAO;
import br.com.informati.restaurantes.repositorio.PedidoDAO;

/**
 * @author Flavius
 *
 */
public class PagamentoController implements IGenericoController<PagamentoHttp> {

	private final PagamentoDAO repositorio = new PagamentoDAO();
	private final PedidoDAO repositorioPedido = new PedidoDAO();
	private final FormaPagamentoDAO repositorioForma = new FormaPagamentoDAO();
	
	
	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(PagamentoHttp pagamentoHttp) {
		String msg = "Registro atualizado com sucesso!";
		PagamentoEntity entidade = new PagamentoEntity();

		try {

			PedidoEntity pedido = this.repositorioPedido.consultarPorId(pagamentoHttp.getPedido().getId());

			entidade.setPedido(pedido);

			FormaPagamentoEntity formaPagamento = this.repositorioForma.consultarPorId(pagamentoHttp.getPedido().getId());

			entidade.setFormaPagamento(formaPagamento);

//			entidade.setId(pagamentoHttp.getId());
			entidade.setValor(pagamentoHttp.getValor());
			entidade.setIdUsuario(pagamentoHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(pagamentoHttp.getUltimaAtualizacao().getTime()));

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
	public String atualizar(PagamentoHttp pagamentoHttp) {
		String msg = "Registro atualizado com sucesso!";
		PagamentoEntity entidade = new PagamentoEntity();

		try {

			PedidoEntity pedido = this.repositorioPedido.consultarPorId(pagamentoHttp.getPedido().getId());

			entidade.setPedido(pedido);

			FormaPagamentoEntity formaPagamento = this.repositorioForma.consultarPorId(pagamentoHttp.getPedido().getId());

			entidade.setFormaPagamento(formaPagamento);

			entidade.setId(pagamentoHttp.getId());
			entidade.setValor(pagamentoHttp.getValor());
			entidade.setIdUsuario(pagamentoHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(pagamentoHttp.getUltimaAtualizacao().getTime()));

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
	public List<PagamentoHttp> consultarTodos() {
		List<PagamentoHttp> listaPagamentos = new ArrayList<PagamentoHttp>();

		List<PagamentoEntity> listaEntidades = repositorio.consultarTodos();

		for (PagamentoEntity entidade : listaEntidades) {

			PagamentoHttp pagamento = PagamentoHttp.converterEntity(entidade);

			listaPagamentos.add(pagamento);
		}

		return listaPagamentos;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public PagamentoHttp consultarPorId(int id) {
		PagamentoHttp aux = new PagamentoHttp();

		PagamentoEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			aux = PagamentoHttp.converterEntity(entidade);
		}

		return aux;
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
