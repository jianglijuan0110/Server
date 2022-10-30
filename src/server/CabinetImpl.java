package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.Espece;
import common.IAnimal;
import common.ICabinet;

public class CabinetImpl extends UnicastRemoteObject implements ICabinet{
	
	private ArrayList<IAnimal> listAnimaux = new ArrayList<IAnimal>();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected CabinetImpl() throws RemoteException {
		super();
	}
	
	protected CabinetImpl(Animal animal) throws RemoteException {
		this.listAnimaux.add(animal);
		System.out.println("Nombre de patient(s) dans le cabinet: " + listAnimaux.size());
	}
	
	protected CabinetImpl(String nomAnimal, String nomMaitre, int ageAnimal, Espece espece) throws RemoteException {
		this.listAnimaux.add(new Animal(nomAnimal, nomMaitre, ageAnimal, espece));
		System.out.println("Nombre de patient(s) dans le cabinet: " + listAnimaux.size());
    }

    protected CabinetImpl(String nomAnimal, String nomMaitre, int ageAnimal, String nomEspece, int dureeVie) throws RemoteException {
    	this.listAnimaux.add(new Animal(nomAnimal, nomMaitre, ageAnimal, nomEspece, dureeVie));
    	System.out.println("Nombre de patient(s) dans le cabinet: " + listAnimaux.size());
    }
    
	
	


	@Override
	public void ajouterAnimal(String nomAnimal, String nomMaitre, int ageAnimal, Espece espece) throws RemoteException {
		IAnimal animal = new Animal(nomAnimal,nomMaitre,ageAnimal, espece);
		int i =0;
		while (i < this.listAnimaux.size() && !this.listAnimaux.contains(animal)) {
			if (!this.listAnimaux.get(i).getNomComplet().equals(animal.getNomComplet())) {
				this.listAnimaux.add(animal);
				System.out.println("Animal ajout� avec succ�s!");
			}
			else {
				System.out.println("Animal d�j� pr�sent dans le cabinet!");
			}
			i++;
		}
		System.out.println("Nombre de patient(s) dans le cabinet: " + this.listAnimaux.size());
	}


	@Override
	public void  ajouterAnimal(String nomAnimal, String nomMaitre, int ageAnimal, String nomEspece, int dureeVie) throws RemoteException {
		IAnimal animal = new Animal(nomAnimal,nomMaitre,ageAnimal, nomEspece, dureeVie);
		int i =0;
		while (i < this.listAnimaux.size() && !this.listAnimaux.contains(animal)) {
			if (!this.listAnimaux.get(i).getNomComplet().equals(animal.getNomComplet())) {
				this.listAnimaux.add(animal);
				System.out.println("Animal ajout� avec succ�s!");
			}
			else {
				System.out.println("Animal d�j� pr�sent dans le cabinet!");
			}
			i++;
		}
		System.out.println("Nombre de patient(s) dans le cabinet: " + this.listAnimaux.size());
	}


	@Override
	public void removeAnimal(String nomAnimal, String nomMaitre, int ageAnimal, Espece espece) throws RemoteException {
		IAnimal animal = new Animal(nomAnimal,nomMaitre,ageAnimal, espece);
		for (int i=0; i < this.listAnimaux.size(); i++) {
			if (this.listAnimaux.get(i).getNomComplet().equals(animal.getNomComplet())) {
				this.listAnimaux.remove(i);
			}
		}
		System.out.println("Animal supprimé avec succès!");
	}


	@Override
	public void removeAnimal(String nomAnimal, String nomMaitre, int ageAnimal, String nomEspece, int dureeVie) throws RemoteException {
		IAnimal animal = new Animal(nomAnimal,nomMaitre,ageAnimal, nomEspece, dureeVie);
		for (int i=0; i < this.listAnimaux.size(); i++) {
			if (this.listAnimaux.get(i).getNomComplet().equals(animal.getNomComplet())) {
				this.listAnimaux.remove(i);
			}
		}
		System.out.println("Animal supprimé avec succès!");
	}

	@Override
	public void getCabinet() throws RemoteException {
		for (int i=0; i < this.listAnimaux.size(); i++) {
			System.out.println("Informations animal " + i + " : " + this.listAnimaux.get(i).getNomComplet());
		}
	}

	@Override
	public void rechercherAnimal(String nom) throws RemoteException {
		boolean result = false;
		String reponse = "Aucun animal portant ce nom dans le cabinet!";
		int i = 0;
		while (i < this.listAnimaux.size() && result == false) {
			if (this.listAnimaux.get(i).getNomAnimal().equals(nom)) {
				result = true;
				reponse = "Animal trouv�!";
			}
			i++;
		}
		System.out.println(reponse);
	}

}
