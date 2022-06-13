
import java.rmi.Naming;
import java.util.List;

import metier.Produit;
import service.ICatalogueRemote;

public class ClientRMICatalogue {

	public static void main(String[] args) {
		try {
			ICatalogueRemote stub = (ICatalogueRemote)Naming.lookup("rmi://localhost:1099/CATAL");
			System.out.println("Prix moeyn: "+stub.getPrixMoyen());
			System.out.println("-------------------------");
			List<Produit> produits = stub.consulterProduisParMC("A");
			for (Produit produit : produits) {
			System.out.println(produit.getNomProduit()+" -- "+produit.getPrix());	
			}
			Produit p=stub.consulterProdui(1L);
			System.out.println("-------------------------");
			System.out.println("Nom Produit : "+p.getNomProduit());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
