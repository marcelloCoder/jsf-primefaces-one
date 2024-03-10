package br.com.marce.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.marce.model.Empresa;
import br.com.marce.repository.EmpresaDAO;
import br.com.marce.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  @Inject
	    private EmpresaDAO empresas;

	    @Transacional
	    public void salvar(Empresa empresa) {
	        empresas.salvar(empresa);
	    }

	    @Transacional
	    public void excluir(Empresa empresa) {
	        empresas.remover(empresa);
	    }

}
