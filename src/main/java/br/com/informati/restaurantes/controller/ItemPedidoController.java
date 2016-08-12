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
import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.PedidoEntity;
import br.com.informati.restaurantes.modelo.ProdutoEntity;
import br.com.informati.restaurantes.repositorio.ItemPedidoDAO;
import br.com.informati.restaurantes.repositorio.PedidoDAO;
import br.com.informati.restaurantes.repositorio.ProdutoDAO;

/**
 * @author Flavius
 *
 */
@Path("/itemPedido")
public class ItemPedidoController implements IGenericoController<ItemPedidoHttp> {

	private final ItemPedidoDAO repositorio = new ItemPedidoDAO();
	private final ProdutoDAO repositorioProduto = new ProdutoDAO();
	private final PedidoDAO repositorioPedido = new PedidoDAO();
	
	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(ItemPedidoHttp itemHttp) {
		String msg = "Registro atualizado com sucesso!";
		ItemPedidoEntity entidade = new ItemPedidoEntity();

		try {

//			entidade.setId(itemHttp.getId());
			entidade.setNome(itemHttp.getNome());
			entidade.setPrecoUnitario(itemHttp.getPrecoUnitario());
			entidade.setQuantidade(itemHttp.getQuantidade());

			entidade.setIdUsuario(itemHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(itemHttp.getUltimaAtualizacao().getTime()));

			ProdutoEntity produto = this.repositorioProduto.consultarPorId(itemHttp.getProduto().getId());

			entidade.setProduto(produto);
			
			PedidoEntity pedido = this.repositorioPedido.consultarPorId(itemHttp.getPedido().getId());
			
			entidade.setPedido(pedido);
			
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
	public String atualizar(ItemPedidoHttp itemHttp) {
		String msg = "Registro atualizado com sucesso!";
		ItemPedidoEntity entidade = new ItemPedidoEntity();

		try {

			entidade.setId(itemHttp.getId());
			entidade.setNome(itemHttp.getNome());
			entidade.setPrecoUnitario(itemHttp.getPrecoUnitario());
			entidade.setQuantidade(itemHttp.getQuantidade());

			entidade.setIdUsuario(itemHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(itemHttp.getUltimaAtualizacao().getTime()));

			ProdutoEntity produto = this.repositorioProduto.consultarPorId(itemHttp.getProduto().getId());

			entidade.setProduto(produto);
			
			PedidoEntity pedido = this.repositorioPedido.consultarPorId(itemHttp.getPedido().getId());
			
			entidade.setPedido(pedido);
			
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
	public List<ItemPedidoHttp> consultarTodos() {
		List<ItemPedidoHttp> listaItens = new ArrayList<ItemPedidoHttp>();

		List<ItemPedidoEntity> listaEntidades = repositorio.consultarTodos();

		for (ItemPedidoEntity entidade : listaEntidades) {

			ItemPedidoHttp item = ItemPedidoHttp.converterEntity(entidade);

			listaItens.add(item);
		}

		return listaItens;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public ItemPedidoHttp consultarPorId(int id) {
		ItemPedidoHttp aux = new ItemPedidoHttp();

		ItemPedidoEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			aux = ItemPedidoHttp.converterEntity(entidade);
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
