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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import br.com.informati.restaurantes.http.PerfilHttp;
import br.com.informati.restaurantes.modelo.PerfilEntity;
import br.com.informati.restaurantes.repositorio.PerfilDAO;

/**
 * @author Flavius
 *
 */
@Path("/perfil")
public class PerfilController implements IGenericoController<PerfilHttp> {

	private final PerfilDAO repositorio = new PerfilDAO();
	
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String cadastrar(PerfilHttp perfilHttp){
		
		String msg = "Registro cadastrado com sucesso!";
		PerfilEntity entidade = new PerfilEntity();
		
		try{
			
			entidade.setNome(perfilHttp.getNome());
			entidade.setIdUsuario(perfilHttp.getIdUsuario());
			
			repositorio.salvar(entidade);
			
		}catch(Exception e){
			
			msg = "Erro ao cadastrar um registro " + e.getMessage();
		}
		
		return msg;
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/atualizar")
	public String atualizar(PerfilHttp perfilHttp){
 
		String msg = "Registro atualizado com sucesso!";
		PerfilEntity entidade = new PerfilEntity();
 
		try {
 
			entidade.setId(perfilHttp.getId());
			entidade.setNome(perfilHttp.getNome());
			entidade.setUltimaAtualizacao( new Timestamp(perfilHttp.getUltimaAtualizacao().getTime()));
			entidade.setIdUsuario(perfilHttp.getIdUsuario());
 
			repositorio.atualizar(entidade);
 
		} catch (Exception e) {
 
			msg = "Erro ao alterar o registro " + e.getMessage();
 
		}
		
		return msg;
 
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarTodos")
	public List<PerfilHttp> consultarTodos(){
 
		List<PerfilHttp> listaPerfisHttp =  new ArrayList<PerfilHttp>();
 
		List<PerfilEntity> listaEntityPerfis = repositorio.consultarTodos();
 
		for (PerfilEntity entidade : listaEntityPerfis) {
 
			listaPerfisHttp.add(PerfilHttp.converterEntity(entidade));
			
		}
 
		return listaPerfisHttp;
	}
	
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/consultarPorId/{id}")
	public PerfilHttp consultarPorId(@PathParam("id") int id){
 
		PerfilEntity entidade = repositorio.consultarPorId(id);
 
		/*if(entidade != null)
			return new PerfilHttp(entidade.getId(), entidade.getNome(), entidade.getUltimaAtualizacao(), entidade.getIdUsuario());
 */
		return null;
	}
	
	
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")	
	public String excluir(@PathParam("id") int id){
 
		String msg = "Registro excluído com sucesso!";
		try {
 
			repositorio.excluir(id);
 
		} catch (Exception e) {
 
			msg = "Erro ao excluir o registro! " + e.getMessage();
		}
		
		return msg;
 
	}
	
	
}
