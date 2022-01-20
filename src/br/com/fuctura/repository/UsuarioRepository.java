package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fuctura.models.Usuario;

public class UsuarioRepository {
	
	public void incluir(Usuario novoUsuario, EntityManager em) {
		
		EntityTransaction transacao = em.getTransaction();
				
		transacao.begin();
		em.persist(novoUsuario);
		transacao.commit();
	}
	
	public Usuario pesquisarPorEmail(String email, EntityManager em) {
			Usuario usuarioDaBase = em.find(Usuario.class, email);
		return usuarioDaBase;
		
	}
	
	public List<Usuario> pesquisarPorIdade(int idade, EntityManager em){
		
		TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findByIdade", Usuario.class);
		consulta.setParameter("idade", idade);
		List<Usuario> resultado = consulta.getResultList();
		
		return resultado;
		
	}
	
	
	public List<Usuario> pesquisarPorNome(String nome, EntityManager em){
		
		Query consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nome LIKE :nome");
		consulta.setParameter("nome", nome);
		List<Usuario> resultado = consulta.getResultList();
		return resultado;
		
	}
	
	public List<Usuario>pesquisarPorTodos(EntityManager em){
		Query consulta = em.createQuery("SELECT u FROM Usuario u");
		List<Usuario> resultado = consulta.getResultList();
		return resultado;
		
	}
	
	
}
