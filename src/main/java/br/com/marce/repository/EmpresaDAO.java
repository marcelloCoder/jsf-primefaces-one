package br.com.marce.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.marce.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	
	public Empresa porID(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> pesquisar(String nome){
		String jpql = "from Empresa where nomeFantasia like :nomeFantasia";
		TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
		query.setParameter("nomeFantasia", nome +"%");
		return query.getResultList();
	}
	
	public List<Empresa> todas() {
        return manager.createQuery("from Empresa", Empresa.class).getResultList();
   }
	
	public Empresa salvar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porID(empresa.getId());
		manager.remove(empresa);
	}

}
