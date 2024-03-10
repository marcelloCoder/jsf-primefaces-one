package br.com.marce.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.marce.model.Empresa;
import br.com.marce.model.RamoAtividade;
import br.com.marce.model.TipoEmpresa;

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
	        
	        System.out.println("\nSalvando uma nova empresa:");
	        Empresa novaEmpresa = new Empresa();
	        novaEmpresa.setNomeFantasia("Nova Empresa");
	        novaEmpresa.setRazaoSocial("Nova Empresa Ltda.");
	        novaEmpresa.setCnpj("12.345.678/0001-89");
	        novaEmpresa.setDataFundacao(new Date());
	        RamoAtividade ramo = ramoAtividadeDAO.porID(1L);
	        novaEmpresa.setRamoAtividade(ramo);
	        novaEmpresa.setTipo(TipoEmpresa.LTDA);
	        empresaDAO.salvar(novaEmpresa);
	        System.out.println("Empresa salva com sucesso: " + novaEmpresa.getNomeFantasia());

	        // Removendo a empresa recém-criada
	        System.out.println("\nRemovendo a empresa recém-criada:");
	        Empresa empresaRemover = empresaDAO.porID(novaEmpresa.getId());
	        empresaDAO.remover(empresaRemover);
	        System.out.println("Empresa removida com sucesso: " + empresaRemover.getNomeFantasia());

	        entityManager.close();
	        PersistenceUtil.closeEntityManagerFactory();
	    }
}
