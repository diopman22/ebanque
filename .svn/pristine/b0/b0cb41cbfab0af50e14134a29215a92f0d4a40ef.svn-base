package banking.dao.file;

import banking.bean.Compte;
import banking.bean.Proprietaire;
import banking.dao.DaoCompte;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mansour Baro DIOP
 */
public class DaoImplCompte extends DaoCompte<Compte> {

	private static File f;
	private static FileWriter w;
	private static File e;
	private static FileWriter v;

	public DaoImplCompte() throws InstantiationException, IllegalAccessException, IOException {
		f = new File("C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\compte.txt");
		e = new File("C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\proprietaire.txt");
		w = null;
		v = null;
	}

	@Override
	public Compte find(int id) {
		List<Compte> list = getList();
		Compte cpt = new Compte();
		cpt = (Compte) list.get(id - 1);
		return cpt;
	}

	@Override
	public void create(Compte c) {
		String ch = null;
		String chProp = null;
		List<Compte> list = getList();
		List<Proprietaire> listProp = getListProp();
		
		c.setIdProp(listProp.size() + 1);
		c.setIdCompte(list.size() + 1);
		
		/*cas ou le fichier est non vide
		if (listProp.isEmpty() == true) {
			c.setIdProp(1);
		} else {
			c.setIdProp(listProp.size() + 1);
		}

		if (list.isEmpty() == true) {
			c.setIdCompte(1);
		} else {
			c.setIdCompte(list.size() + 1);
		}
		*/
		try {
			v = new FileWriter(e, true);
			chProp = c.getIdProp() + " " + c.getNomProp() + " " + c.getPrenomProp() + " " + c.getAdresseProp() + " ";
			v.write(chProp + "\n");
			v.flush();
			v.close();
		} catch (Exception e) {
		}

		try {
			w = new FileWriter(f, true);
			ch = c.getIdCompte() + " " + c.getSolde() + " " + c.getDecouvert() + " " + c.getDebitMax() + " "
					+ c.getIdProp() + " ";
			w.write(ch + "\n");
			w.flush();
			w.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void update(Compte c) {
		List<Compte> list = listComptes();
		Compte c1 = list.get(c.getIdCompte() - 1);
		c.setIdProp(c1.getIdProp());
		list.set(c.getIdCompte() - 1, c);
		try {
			ecrire(list);
		} catch (IOException ex) {
			Logger.getLogger(DaoImplCompte.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void ecrire(List<Compte> l) throws IOException {
		Compte c = new Compte();
		String ch = null;
		f.delete();
		Collection<Compte> col = l;
		Iterator<Compte> it = col.iterator();
		while (it.hasNext()) {
			c = (Compte) it.next();
			try {
				w = new FileWriter(f, true);
				ch = c.getIdCompte() + " " + c.getSolde() + " " + c.getDecouvert() + " " + c.getDebitMax() + " "
						+ c.getIdProp();
				w.write(ch + "\n");
				w.flush();
				w.close();
			} catch (Exception e) {
				w.close();
			}
		}
	}

	/*
	 * @Override public void delete(Compte c) { List<Compte> list =
	 * listComptes(); list.remove(c.getIdCompte()-1); try { ecrire(list); }
	 * catch (IOException ex) {
	 * Logger.getLogger(DaoImplCompte.class.getName()).log(Level.SEVERE, null,
	 * ex); } }
	 */

	@Override
	public Compte credit(Compte c, double montant) {
		c.setSolde(c.getSolde() + montant);
		update(c);
		return c;
	}

	@Override
	public Compte debit(Compte c, double montant) {
		if ((c.getSolde() >= montant)) {
			if ((c.getDebitMax() >= montant)) {
				c.setSolde(c.getSolde() - montant);
				update(c);
			}
		} else if (((c.getSolde() + c.getDecouvert()) >= montant) && (c.getDebitMax() >= montant)) {
			c.setDecouvert((c.getSolde() + c.getDecouvert()) - montant);
			c.setSolde(0);
			update(c);
		}
		return c;
	}

	@Override
	public Compte virement(Compte src, Compte dest, double montant) {
		double solde = src.getSolde() + src.getDecouvert();
		debit(src, montant);
		if ((solde != (src.getSolde() + src.getDecouvert())))
			credit(dest, montant);
		return src;
	}

	@Override
	public List<Compte> getList() {
		List<Compte> comptes = new ArrayList<Compte>();
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(
					new FileReader("C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\compte.txt"));
			while ((ligne = fichier.readLine()) != null) {
				comptes.add(compte(ligne));
			}
			fichier.close();
		} catch (Exception e) {
		}
		return comptes;
	}

	public List<Compte> listComptes() {
		List<Compte> comptes = new ArrayList<Compte>();
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(
					new FileReader("C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\compte.txt"));
			while ((ligne = fichier.readLine()) != null) {
				comptes.add(strTocompte(ligne));
			}
			fichier.close();
		} catch (Exception e) {
		}
		return comptes;
	}

	public Compte compte(String ch) {
		String sortie[] = ch.split(" ");
		try {
			Compte cpt = new Compte(Double.parseDouble(sortie[1]), Double.parseDouble(sortie[2]),
					Double.parseDouble(sortie[3]));
			cpt.setIdCompte(Integer.parseInt(sortie[0]));

			Proprietaire p = findProp(Integer.parseInt(sortie[4]));
			cpt.setNomProp(p.getNom());
			cpt.setPrenomProp(p.getPrenom());
			cpt.setAdresseProp(p.getAdresse());
			cpt.setIdProp(Integer.parseInt(sortie[4]));
			return cpt;
		} catch (NumberFormatException e) {
			return new Compte();
		}

	}

	public Compte strTocompte(String ch) {
		String sortie[] = ch.split(" ");
		try {
			Compte cpt = new Compte(Double.parseDouble(sortie[1]), Double.parseDouble(sortie[2]),
					Double.parseDouble(sortie[3]));
			cpt.setIdCompte(Integer.parseInt(sortie[0]));
			cpt.setIdProp(Integer.parseInt(sortie[4]));
			return cpt;
		} catch (NumberFormatException e) {
			return new Compte();
		}

	}

	public Proprietaire findProp(int id) {
		List<Proprietaire> list = getListProp();
		Proprietaire prop = new Proprietaire();
		prop = (Proprietaire) list.get(id - 1);
		return prop;
	}

	public List<Proprietaire> getListProp() {
		List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
		try {
			String ligne;
			BufferedReader fichier = new BufferedReader(new FileReader(
					"C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\proprietaire.txt"));
			try {
				while ((ligne = fichier.readLine()) != null) {
					proprietaires.add(proprietaire(ligne));
				}
				fichier.close();
				
				
			} catch (IOException io) {
			}
			
		} catch (FileNotFoundException e) {
		}
		return proprietaires;
	}

	public Proprietaire proprietaire(String ch) {
		String sortie[] = ch.split(" ");
		try {
			Proprietaire prop = new Proprietaire(sortie[1], sortie[2], sortie[3]);
			prop.setId(Integer.parseInt(sortie[0]));
			return prop;
		} catch (NumberFormatException e) {
			return new Proprietaire();
		}

	}

	/*
	public List<Integer> listIdComptes() {
		List<Integer> inds = new ArrayList<Integer>();
		for (int i = 0; i < listComptes().size(); i++)
			inds.add(listComptes().get(i).getIdCompte());

		return inds;

	}
	*/
}
