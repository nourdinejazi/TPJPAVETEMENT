package com.nourdine.test;

import com.nourdine.dao.VetementDao;
import com.nourdine.entities.Vetement;

public class VetementTest {
	public static void main(String[] args) {
//créer un objet client
		Vetement v = new Vetement();
		v.setMarque("Armani");
		v.setCouleur("black");
//ajouter l'objet client à la BD
		VetementDao cltDao = new VetementDao();
		cltDao.ajouter(v);
		System.out.println("Appel de la méthode listerTous");
		for (Vetement cl : cltDao.listerTous())
			System.out.println(cl.toString());
		System.out.println("Appel de la méthode lister Par marque");
		for (Vetement cl : cltDao.listerParMarque("Armani"))

			System.out.println(cl.toString());

//tester les autres méthodes de la classe ClientDao
	}
}