package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.IDossier;

public class DossierSuivi extends UnicastRemoteObject implements IDossier {
	
	public String dossierSuivi;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//NOTRE CONSTRUCTEUR
	public DossierSuivi() throws RemoteException {
		super();
		this.dossierSuivi = "Votre dossier de suivi est vide. Vous pouvez y rajouter des informations si vous le souhaitez.";
	}
	
	

	//LES ACCESSEURS POUR LE DOSSIER DE SUIVI
	
	@Override
	public String getDossierSuivi() throws RemoteException {
		return this.dossierSuivi;
	}
	

	@Override
	public void setDossierSuivi(String suivi) throws RemoteException {
		this.dossierSuivi = suivi;
		//this.dossierSuivi = this.dossierSuivi + suivi;
	}

}
