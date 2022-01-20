package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.fuctura.models.Conta;
import br.com.fuctura.models.Usuario;

public class ContaRepository {
	public void incluir(Conta novaConta, EntityManager em) {
		
		EntityTransaction transacao = em.getTransaction();
				
		transacao.begin();
		em.persist(novaConta);
		transacao.commit();
	}
	
	public List<Conta>pesquisarPorTodos(EntityManager em){
		Query consulta = em.createQuery("SELECT c FROM Conta c");
		List<Conta> resultado = consulta.getResultList();
		return resultado;
		
	}
}
