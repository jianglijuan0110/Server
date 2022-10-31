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
		
		
		///*    TOUJOURS AJOUTER LA POLITIQUE SE SECURITE AVANT LE GESTIONNAIRE DE SECURITE    *///
		
/*		//POLITIQUE DE SECURITE
		System.setProperty("java.security.Policy", "C:\\Users\\mague\\eclipse-workspace\\Serveur\\src\\server.policy");
				
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
			
			
			///*    PREMIERE VERSION DU CABINET AVEC LE SERVEUR QUI DISTRIBUE DES ANIMAUX    *///
						
			//ON CREE UN DOSSIER DE SUIVI POUR L'ANIMAL
			DossierSuivi dossierA = new DossierSuivi();
			
			
			//ON CREE L'ESPECE DE L'ANIMAL
			Espece especeA = new Espece();
			//On renseigne le nom de l'espece et sa dur�e de vie
			especeA.setNomEspece("Chat");
			especeA.setDureeVie(12);
			

			//ON CREE L'ANIMAL 
			IAnimal animalA = new Animal("Ayden", "Max", 2, dossierA, especeA);
			
			
			
			///*    DEUXIEME VERSION DU CABINET AVEC LE SERVEUR QUI DISTRIBUE DES CABINETS VETERINAIRES    *///
			
			//ON INITIALISE LE CABINET AVEC L'ANIMAL "anilmalA"
			CabinetImpl cabinet = new CabinetImpl(animalA);
			
			
			
			/*Il y a cr�ation automatique d'un objet UnicastRemote (ie pour chaque objet qu'on cr�e on a un squeleton)
			 *Le squeleton qui est UnicastRemote, lui ouvre un service d'�coute r�seau utilisant un num�ro de port (al�atoire)*/
			
			/*On démarre l'annuaire sur le port 1099*/
			Registry registry = LocateRegistry.createRegistry(1099);
			
			//Registry registry = LocateRegistry.getRegistry();   //On devra dans ce cas passer en param�tre le port sur lequel l'annuaire �coute
			
			if (registry == null) {
				System.err.println("Registry not found");
			}
			else {
				/*On cr�e l'objet distant
				 * On publie sa r�f�rence*/
				//registry.bind("Interface Animal", animalA);    //A DECOMMENTER POUR LA 1ER VERSION DU CABINET
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
