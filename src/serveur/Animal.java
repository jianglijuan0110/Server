package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Espece;
import common.IAnimal;

public class Animal extends UnicastRemoteObject implements IAnimal{
	
	private String nomAnimal;
	private String nomMaitre;
	private int ageAnimal;
	
	private DossierSuivi dossier;
	
	private Espece espece;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//CONSTRUCTEUR PAR DEFAUT
	public Animal() throws RemoteException {
		
	}
	
	//CONSTRUCTEUR
	public Animal(String nomAnimal, String nomMaitre, int ageAnimal) throws RemoteException {
		this.nomAnimal = nomAnimal;
		this.nomMaitre  = nomMaitre;
		this.ageAnimal = ageAnimal;
		this.dossier = new DossierSuivi();
	}
	
	
	public Animal(String nomAnimal, String nomMaitre, int ageAnimal, Espece espece) throws RemoteException {
		this.nomAnimal = nomAnimal;
		this.nomMaitre  = nomMaitre;
		this.ageAnimal = ageAnimal;
		this.dossier = new DossierSuivi();
		this.espece = espece;
	}
	
	
	
	//CONSTRUCTEUR AVEC TOUS LES PARAMETRES
	public Animal(String nomAnimal, String nomMaitre, int ageAnimal, DossierSuivi dossier, Espece espece) throws RemoteException {
		this.nomAnimal = nomAnimal;
		this.nomMaitre  = nomMaitre;
		this.ageAnimal = ageAnimal;
		this.dossier = dossier;
		this.espece = espece;
	}
	
	public Animal(String nomAnimal, String nomMaitre, int ageAnimal, String nomEspece, int dureeVie) throws RemoteException {
		this.nomAnimal = nomAnimal;
		this.nomMaitre  = nomMaitre;
		this.ageAnimal = ageAnimal;
		this.dossier = new DossierSuivi();
		this.espece = new Espece(nomEspece, dureeVie);
	}
	
	
	
	//LES ACCESSEURS POUR LE NOM DE L'ANIMAL
	@Override
	public String getNomAnimal() throws RemoteException {
		return this.nomAnimal;
	}
	@Override
	public void setNomAnimal(String nomAnimal) throws RemoteException {
		this.nomAnimal = nomAnimal;	
	}
	
	
	
	//LES ACCESSEURS POUR LE NOM DU MAITRE DE L'ANIMAL
	@Override
	public String getNomMaitre() throws RemoteException {
		return this.nomMaitre;
	}
	@Override
	public void setNomMaitre(String nomMaitre) throws RemoteException {
	    this.nomMaitre = nomMaitre;
	}
	
	
	
	//LES ACCESSEURS POUR L'AGE DE L'ANIMAL
	@Override
	public int getAgeAnimal() throws RemoteException {
		return this.ageAnimal;
	}
	@Override
	public void setAgeAnimal(int ageAnimal) throws RemoteException {
		this.ageAnimal = ageAnimal;
	}
	
	
	
	//POUR AFFICHER LES INFOS LIES AU NOM, AGE ET MAITRE DE L'ANIMAL
	@Override
	public String getNomComplet() throws RemoteException {
		return "\n Nom de l'animal: " + this.nomAnimal + "\n Nom de son ma�tre: " + this.nomMaitre + "\n �ge de l'animal: " + this.ageAnimal + " an(s)"
				+ "\n Info dossier de suivi: " + this.getDossier() + "\n Info esp�ce: " + this.getEspece();
	}

	

	//LES ACCESSEURS POUR LE DOSSIER DE SUIVI DE L'ANIMAL
	@Override
	public String getDossier() throws RemoteException {
		return this.dossier.getDossierSuivi();
	}
	@Override
	public void setDossier(String suivi) throws RemoteException {
		this.dossier.setDossierSuivi(suivi);
	}
	
	

	//LES ACCESSEURS POUR L'ESPECE DE L'ANIMAL
	@Override
	public String getEspece() throws RemoteException {
		return espece.getEspece();
	}
	
	@Override
	public String nomEspece() throws RemoteException{
		return espece.getNomEspece();
	}
	@Override
	public void setNomEspece(String nom) throws RemoteException {
		this.espece.setNomEspece(nom);
		
	}
	
	@Override
	public int dureeVieEspece() throws RemoteException {
		return espece.getDureeVieEspece();
	}
	@Override
	public void setDureeVieEspece(int vie) throws RemoteException {
		this.espece.setDureeVie(vie);
		
	}
	
	
}
