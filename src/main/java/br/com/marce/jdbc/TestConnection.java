package br.com.marce.jdbc;

import javax.persistence.EntityManagerFactory;

public class TestConnection {

    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();

        if (emf != null) {
            System.out.println("Conexão bem-sucedida com o banco de dados.");
        } else {
            System.err.println("Erro ao obter o EntityManagerFactory.");
        }

        HibernateUtil.closeEntityManagerFactory();
    }
}