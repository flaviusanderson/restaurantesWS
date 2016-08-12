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
import br.com.informati.restaurantes.http.ProdutoHttp;
import br.com.informati.restaurantes.modelo.CategoriaEntity;
import br.com.informati.restaurantes.modelo.ItemPedidoEntity;
import br.com.informati.restaurantes.modelo.ProdutoEntity;
import br.com.informati.restaurantes.repositorio.CategoriaDAO;
import br.com.informati.restaurantes.repositorio.ItemPedidoDAO;
import br.com.informati.restaurantes.repositorio.ProdutoDAO;

/**
 * @author Flavius
 *
 */
@Path("/produto")
public class ProdutoController implements IGenericoController<ProdutoHttp> {

	private final ProdutoDAO repositorio = new ProdutoDAO();
	private final CategoriaDAO repositorioCategoria = new CategoriaDAO();
	private final ItemPedidoDAO repositorioItem = new ItemPedidoDAO();

	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(ProdutoHttp produtoHttp) {

		String msg = "Registro atualizado com sucesso!";
		ProdutoEntity entidade = new ProdutoEntity();

		try {

			CategoriaEntity aux = this.repositorioCategoria.consultarPorId(produtoHttp.getCategoria().getId());

			entidade.setCategoria(aux);

			List<ItemPedidoEntity> listaItens = new ArrayList<ItemPedidoEntity>();
			for (ItemPedidoHttp itemHttp : produtoHttp.getItens()) {
				ItemPedidoEntity itemEntity = new ItemPedidoEntity();
				itemEntity = repositorioItem.consultarPorId(itemHttp.getId());
				if (itemEntity != null)
					listaItens.add(itemEntity);
			}
			entidade.setItens(listaItens);
			//entidade.setId(produtoHttp.getId());
			entidade.setNome(produtoHttp.getNome());
			entidade.setDescricao(produtoHttp.getDescricao());
			entidade.setPreco(produtoHttp.getPreco());
			entidade.setQuantidade(produtoHttp.getQuantidade());
			entidade.setIdUsuario(produtoHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(produtoHttp.getUltimaAtualizacao().getTime()));

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
	public String atualizar(ProdutoHttp produtoHttp) {

		String msg = "Registro atualizado com sucesso!";
		ProdutoEntity entidade = new ProdutoEntity();

		try {

			CategoriaEntity aux = this.repositorioCategoria.consultarPorId(produtoHttp.getCategoria().getId());

			entidade.setCategoria(aux);

			List<ItemPedidoEntity> listaItens = new ArrayList<ItemPedidoEntity>();
			for (ItemPedidoHttp itemHttp : produtoHttp.getItens()) {
				ItemPedidoEntity itemEntity = new ItemPedidoEntity();
				itemEntity = repositorioItem.consultarPorId(itemHttp.getId());
				if (itemEntity != null)
					listaItens.add(itemEntity);
			}
			entidade.setItens(listaItens);
			entidade.setId(produtoHttp.getId());
			entidade.setNome(produtoHttp.getNome());
			entidade.setDescricao(produtoHttp.getDescricao());
			entidade.setPreco(produtoHttp.getPreco());
			entidade.setQuantidade(produtoHttp.getQuantidade());
			entidade.setIdUsuario(produtoHttp.getIdUsuario());
			entidade.setUltimaAtualizacao(new Timestamp(produtoHttp.getUltimaAtualizacao().getTime()));

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
	public List<ProdutoHttp> consultarTodos() {

		List<ProdutoHttp> listaProdutos = new ArrayList<ProdutoHttp>();

		List<ProdutoEntity> listaEntidades = repositorio.consultarTodos();

		for (ProdutoEntity entidade : listaEntidades) {

			ProdutoHttp produto = ProdutoHttp.converterEntity(entidade);

			listaProdutos.add(produto);
		}

		return listaProdutos;
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public ProdutoHttp consultarPorId(int id) {
		ProdutoHttp aux = new ProdutoHttp();

		ProdutoEntity entidade = repositorio.consultarPorId(id);

		if (entidade != null) {
			aux = ProdutoHttp.converterEntity(entidade);
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
