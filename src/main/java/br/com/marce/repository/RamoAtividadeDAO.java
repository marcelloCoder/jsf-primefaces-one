package br.com.marce.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.marce.model.RamoAtividade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RamoAtividadeDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public List<RamoAtividade> pesquisar(String descricao){
		CriteriaBuilder cB = manager.getCriteriaBuilder();
		CriteriaQuery<RamoAtividade> cQ = cB.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = cQ.from(RamoAtividade.class);
		cQ.select(root);
		cQ.where(cB.like(root.get("descricao"), descricao +"%"));
		TypedQuery<RamoAtividade> query = manager.createQuery(cQ);
		
		return query.getResultList();
	}
	
	

}
