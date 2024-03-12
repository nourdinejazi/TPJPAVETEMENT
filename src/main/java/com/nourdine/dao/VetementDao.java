package com.nourdine.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.nourdine.entities.Vetement;
import com.nourdine.util.JPAutil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.nourdine.entities.Vetement;
import com.nourdine.util.JPAutil;

//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class VetementDao {
	private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA2");

//méthode ajouter d'une entité à la bd
	public void ajouter(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(v);
		tx.commit();
	}

//méthode modifier d'une entité à partir de la bd
	public void modifier(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(v);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Vetement v) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		v = entityManager.merge(v); // important
		entityManager.remove(v);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Vetement consulter(Vetement v, Object id) {
		return entityManager.find(v.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Vetement> listerTous() {
		List<Vetement> Vetements = entityManager.createQuery("select v from Vetement v").getResultList();

		return Vetements;
	}

//méthode pour lister tous les Vetement dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Vetement> listerParMarque(String marque) {
		List<Vetement> Vetements = entityManager.createQuery("select v from Vetement v where v.marque like :pnom")
		  .setParameter("pnom", "%" + marque + "%").getResultList();

		return Vetements;
	}
}