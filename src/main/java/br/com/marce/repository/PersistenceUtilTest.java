package br.com.marce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import br.com.marce.model.Empresa;
import br.com.marce.model.RamoAtividade;

public class PersistenceUtilTest {

	 public static void main(String[] args) {
	        EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
	        EntityManager entityManager = emf.createEntityManager();

	        RamoAtividadeDAO ramoAtividadeDAO = new RamoAtividadeDAO(entityManager);
	        EmpresaDAO empresaDAO = new EmpresaDAO(entityManager);

	        // Consultando ramos de atividade por descrição
	        System.out.println("Consultando ramos de atividade por descrição:");
	        List<RamoAtividade> ramos = ramoAtividadeDAO.pesquisar("Dist");
	        for (RamoAtividade ramo : ramos) {
	            System.out.println(ramo.getId() + ": " + ramo.getDescricao());
	        }

	        // Consultando empresas por nome fantasia
	        System.out.println("\nConsultando empresas por nome fantasia:");
	        List<Empresa> empresas = empresaDAO.pesquisar("Mercado");
	        for (Empresa empresa : empresas) {
	            System.out.println(empresa.getId() + ": " + empresa.getNomeFantasia());
	        }

	        entityManager.close();
	        PersistenceUtil.closeEntityManagerFactory();
	    }
}
