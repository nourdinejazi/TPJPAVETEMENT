package com.nourdine.entities;

import java.io.Serializable;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vetement implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int code;
	
	private String marque;
	private String couleur;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getMarque() {
		return marque;
	}

	public void setCouleur(String couleur) {
	this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Vetement [code=" + code + ", marque=" + marque + ", couleur=" + couleur + "]";
	}
}


