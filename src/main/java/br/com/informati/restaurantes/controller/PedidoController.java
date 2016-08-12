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
import br.com.informati.restaurantes.http.ItemPedidoHttp;
import br.com.informati.restaurantes.http.PagamentoHttp;
import br.com.informati.restaurantes.http.PedidoHttp;
import br.com.informati.restaurantes.modelo.ClienteEntity;
import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.MesaEntity;
import br.com.informati.restaurantes.modelo.PagamentoEntity;
import br.com.informati.restaurantes.modelo.PedidoEntity;
import br.com.informati.restaurantes.repositorio.ClienteDAO;
import br.com.informati.restaurantes.repositorio.ItemPedidoDAO;
import br.com.informati.restaurantes.repositorio.MesaDAO;
import br.com.informati.restaurantes.repositorio.PagamentoDAO;
import br.com.informati.restaurantes.repositorio.PedidoDAO;

/**
 * @author Flavius
 *
 */
@Path("/pedido")
public class PedidoController implements IGenericoController<PedidoHttp> {

	private final PedidoDAO repositorio = new PedidoDAO();
	private final ClienteDAO repositorioCliente = new ClienteDAO();
	private final MesaDAO repositorioMesa = new MesaDAO();
	private final ItemPedidoDAO repositorioItem = new ItemPedidoDAO();
	
	private final PagamentoDAO repositorioPagamento = new PagamentoDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(PedidoHttp pedidoHttp) {
		String msg = "Registro atualizado com sucesso!";
		PedidoEntity entidade = new PedidoEntity();

		try {

			ClienteEntity cliente = this.repositorioCliente.consultarPorId(pedidoHttp.getCliente().getId());
			entidade.setCliente(cliente);

			MesaEntity mesa = this.repositorioMesa.consultarPorId(pedidoHttp.getMesa().getId());
			entidade.setMesa(mesa);

			List<ItemPedidoEntity> listaItens = new ArrayList<ItemPedidoEntity>();
			for (ItemPedidoHttp itemHttp : pedidoHttp.getItens()) {
				ItemPedidoEntity itemEntity = new ItemPedidoEntity();
				itemEntity = repositorioItem.consultarPorId(itemHttp.getId());
				if (itemEntity != null)
					listaItens.add(itemEntity);
			}
			entidade.setItens(listaItens);
			
			List<PagamentoEntity> listaPagamentos = new ArrayList<PagamentoEntity>();
			for (PagamentoHttp pagamentoHttp : pedidoHttp.getPagamentos()) {
				PagamentoEntity pagamentoEntity = new PagamentoEntity();
				pagamentoEntity = repositorioPagamento.consultarPorId(pagamentoHttp.getId());
				if (pagamentoEntity != null)
					listaPagamentos.add(pagamentoEntity);
			}
			entidade.setPagamentos(listaPagamentos);
			
			
			entidade.setId(pedidoHttp.getId());
			entidade.setCodigo(pedidoHttp.getCodigo());
			entidade.setNotaFiscal(pedidoHttp.getNotaFiscal());

			entidade.setIdUsuario(pedidoHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(pedidoHttp.getUltimaAtualizacao().getTime()));

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
	public String atualizar(PedidoHttp pedidoHttp) {

		String msg = "Registro atualizado com sucesso!";
		PedidoEntity entidade = new PedidoEntity();

		try {

			ClienteEntity cliente = this.repositorioCliente.consultarPorId(pedidoHttp.getCliente().getId());
			entidade.setCliente(cliente);

			MesaEntity mesa = this.repositorioMesa.consultarPorId(pedidoHttp.getMesa().getId());
			entidade.setMesa(mesa);

			List<ItemPedidoEntity> listaItens = new ArrayList<ItemPedidoEntity>();
			for (ItemPedidoHttp itemHttp : pedidoHttp.getItens()) {
				ItemPedidoEntity itemEntity = new ItemPedidoEntity();
				itemEntity = repositorioItem.consultarPorId(itemHttp.getId());
				if (itemEntity != null)
					listaItens.add(itemEntity);
			}
			entidade.setItens(listaItens);
			
			List<PagamentoEntity> listaPagamentos = new ArrayList<PagamentoEntity>();
			for (PagamentoHttp pagamentoHttp : pedidoHttp.getPagamentos()) {
				PagamentoEntity pagamentoEntity = new PagamentoEntity();
				pagamentoEntity = repositorioPagamento.consultarPorId(pagamentoHttp.getId());
				if (pagamentoEntity != null)
					listaPagamentos.add(pagamentoEntity);
			}
			entidade.setPagamentos(listaPagamentos);
			
			
			entidade.setId(pedidoHttp.getId());
			entidade.setCodigo(pedidoHttp.getCodigo());
			entidade.setNotaFiscal(pedidoHttp.getNotaFiscal());

			entidade.setIdUsuario(pedidoHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(pedidoHttp.getUltimaAtualizacao().getTime()));

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
	public List<PedidoHttp> consultarTodos() {
		List<PedidoHttp> listaPedidos = new ArrayList<PedidoHttp>();

		List<PedidoEntity> listaEntidades = repositorio.consultarTodos();

		for (PedidoEntity entidade : listaEntidades) {

			PedidoHttp pedido = PedidoHttp.converterEntity(entidade);

			listaPedidos.add(pedido);
		}

		return listaPedidos;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public PedidoHttp consultarPorId(int id) {
		PedidoHttp aux = new PedidoHttp();

		PedidoEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			aux = PedidoHttp.converterEntity(entidade);
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
