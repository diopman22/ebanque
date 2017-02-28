package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import banking.bean.Compte;
import banking.bean.Proprietaire;
import model.ModelImpl;

public class TestDAO {
	
	

	@Test
	public void testCreate() {
		Compte compte = new Compte(5000,4000,2000,"samb","mohamedd","medina");
		
		try {
			ModelImpl model = new ModelImpl();
			int idAtt = model.getCptDAO().getList().size()+1;
			String resultatAtt = idAtt+compte.getSolde()+compte.getDecouvert()+compte.getDebitMax()+compte.getNomProp()+compte.getPrenomProp()+compte.getAdresseProp();
			
			model.getCptDAO().create(compte);
			int idObt = model.getCptDAO().getList().size();
			Compte cObt = (Compte)model.getCptDAO().find(idObt);
			Proprietaire pObt = (Proprietaire)model.getPropsDAO().find(idObt);
			String resultatObt = idObt+cObt.getSolde()+cObt.getDecouvert()+cObt.getDebitMax()+pObt.getNom()+pObt.getPrenom()+pObt.getAdresse();
			
			assertEquals(resultatAtt,resultatObt);
			
			
		} catch (Exception e) {
		
		}
	}
	
	
	@Test
	public void testDebit() {
		
		try {
			ModelImpl model = new ModelImpl();
			Compte c1 = (Compte)model.getCptDAO().find(1);
			Compte c2 = (Compte)model.getCptDAO().find(2);
			
			//cas1: solde >= montant et montant <= debitMax			
			model.getCptDAO().debit(c1, 1000);
			Compte c1Obt = (Compte)model.getCptDAO().find(1);
			c1.setSolde(4000);
			assertEquals((int)c1.getSolde(),(int)c1Obt.getSolde());
			c1.setSolde(5000);
			model.getCptDAO().update(c1);
			
			//cas2: solde+decouvert >= montant et debitMax >= montant
			model.getCptDAO().debit(c2, 10000);
			Compte c2Obt = (Compte)model.getCptDAO().find(2);
			c2.setSolde(0);
			assertEquals((int)c2.getSolde(), (int)c2Obt.getSolde());
			c2.setSolde(7000);
			c2.setDecouvert(6000);
			model.getCptDAO().update(c2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Test
	public void testCredit() {
		ModelImpl model;
		try {
			model = new ModelImpl();
			Compte c1 = (Compte)model.getCptDAO().find(3);
			model.getCptDAO().credit(c1, 1000);
			Compte c1Obt = (Compte)model.getCptDAO().find(3);
			assertEquals(4000,(int)c1Obt.getSolde());
			c1.setSolde(3000);
			model.getCptDAO().update(c1);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testVirement() {
		ModelImpl model;
		try {
			model = new ModelImpl();
			Compte c1 = (Compte)model.getCptDAO().find(1);
			Compte c2 = (Compte)model.getCptDAO().find(2);
			model.getCptDAO().virement(c1, c2, 1000);
			Compte c1Obt = (Compte)model.getCptDAO().find(1);
			Compte c2Obt = (Compte)model.getCptDAO().find(2);
			assertEquals(4000,(int)c1Obt.getSolde());
			assertEquals(8000,(int)c2Obt.getSolde());
			c1.setSolde(5000);
			model.getCptDAO().update(c1);
			c2.setSolde(7000);
			model.getCptDAO().update(c2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
