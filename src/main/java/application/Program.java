package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class Program {

	public static void main(String[] args) {
		
		/*
		//Instanciando objeto
		Person p = new Person(null, "Carlota", "carlota@gmail.com");
		Person q = new Person(null, "Marian", "mar@gmail.com");
		Person r = new Person(null, "Luka", "luka@gmail.com");
		//O próprio banco de dados vai atribuir um Id para as informações
		 */
		
		//Instanciando o EntityManagerFactory para o acesso e alteração de dados
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
		//O PersistenceUnity é o nome do Persistence que foi colocado no persistence.xml
		
		//Instanciando o EntityManager para aplicação do contexto de persistência
		EntityManager em = enf.createEntityManager();
		
		//Removendo pessoa do banco de dados
		Person p = em.find(Person.class, 2);
		//Por padrão, o .find busca dois parametros: A classe onde se encontra a informação e a chave correspondente a ela
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		 
		/*
		//Buscando pessoa pelo o Id usando uma função de busca do JPA
		Person p = em.find(Person.class, 2);
		//Por padrão, o .find busca dois parametros: A classe onde se encontra a informação e a chave correspondente a ela
		System.out.println(p);
		*/
		
		/*Como adicionar uma informação no banco de dados? Com o método .persist
		 * Quando o banco de dados faz uma operação que não é uma simples leitura
		 * ele precisa de uma transação para realizar a alteração.
		 * Vamos acessar o banco de dados através do EntityManager e adicionar os dados
		 */
		
		/*
		//Realizando transação
		em.getTransaction().begin();
		
		//Adicionando informações
		em.persist(p);
		em.persist(q);
		em.persist(r);
		
		//Finalizando transação
		em.getTransaction().commit();
		*/
		
		//Fechando ambos os EntityManager
		enf.close();
		em.close();
	}

}
