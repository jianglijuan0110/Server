package serveur;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


//import 

import common.Espece;
import common.IAnimal;


public class Serveur {
	
	private Serveur() {
		
	}

	public static void main(String[] args) {
		
		//java.rmi.server.useLocalHostname=true;
		//System.setProperty("java.rmi.server.hostname", "127.0.0.1");
		
		
		
		///*    TOUJOURS AJOUTER LA POLITIQUE SE SECURITE AVANT LE GESTIONNAIRE DE SECURITE    *///
		
		//POLITIQUE DE SECURITE
/*		System.setProperty("java.security.Policy", "file:C:\\Users\\mague\\eclipse-workspace\\Serveur\\src\\server.policy");
				
		//GESTIONNAIRE DE SECURITE
		try {
			if (System.getSecurityManager() == null) {
			    System.setSecurityManager(new SecurityManager());
			}
		} catch (Exception a) {
			a.printStackTrace();
		}
*/		
		
		
		try {
						
			//ON CREE UN DOSSIER
			DossierSuivi dossierA = new DossierSuivi();
			
			
			//ON CREE UN ESPECE
			Espece especeA = new Espece();
			//On renseigne le nom de l'espece et sa dur�e de vie
			especeA.setNomEspece("Chat");
			especeA.setDureeVie(12);
			

			//ON CREE UN ANIMAL
			IAnimal animalA = new Animal("Ayden", "Max", 2, dossierA, especeA);
			
			
			//ON CREE LE CABINET
			CabinetImpl cabinet = new CabinetImpl(animalA);
			/*cabinet.ajouterAnimal("Ayden", "Max", 2, especeA);
			cabinet.ajouterAnimal("Narbor", "Li", 3, "Chien", 10);
			
			
			/*Il y a cr�ation automatique d'un objet UnicastRemote (ie pour chaque objet qu'on cr�e on a un squeleton)
			 *Le squeleton qui est UnicastRemote, lui ouvre un service d'�coute r�seau utilisant un num�ro de port (al�atoire)*/
			
			/*On d�marre l'annuaire sur le port 1099*/
			Registry registry = LocateRegistry.createRegistry(1099);
			
			//Registry registry = LocateRegistry.getRegistry();   //On devra dans ce cas passer en param�tre le port sur lequel l'annuaire �coute
			
			if (registry == null) {
				System.err.println("Registry not found");
			}
			else {
				/*On cr�e l'objet distant
				 * On publie sa r�f�rence*/
				//registry.bind("Interface Animal", animalA);
				registry.bind("Interface Cabinet", cabinet);
				System.err.println("Server is ready");
			}
		}
		catch (RemoteException | AlreadyBoundException e) {
			System.err.println("Server Exception: " + e.toString());
			e.printStackTrace();
		}

	}

}
