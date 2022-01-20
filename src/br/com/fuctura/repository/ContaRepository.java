package br.com.fuctura.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.fuctura.models.Conta;

public class ContaRepository {
	public void incluir(Conta novaConta, EntityManager em) {
		
		EntityTransaction transacao = em.getTransaction();
				
		transacao.begin();
		em.persist(novaConta);
		transacao.commit();
	}
}
