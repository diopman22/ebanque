package banking.dao.file;

import banking.bean.Proprietaire;
import banking.dao.DaoProp;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mansour Baro DIOP
 */
public class DaoImplProp extends DaoProp<Proprietaire>{

    private static File f ;
    private static FileWriter w ;
    
    public DaoImplProp() throws InstantiationException, IllegalAccessException, IOException {
        f = new File ("C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\proprietaire.txt");
        w = null;
    }    
    
    @Override
    public Proprietaire find(int id) {
        List<Proprietaire> list = getList();
        Proprietaire prop = new Proprietaire();
        prop = (Proprietaire)list.get(id-1);
        return prop;
    }
    
    /*
    @Override
    public void create(Proprietaire prop) {
        String ch=null;
        List<Proprietaire> list = getList();
        if(list.isEmpty()==true){
            prop.setId(1);
        }else{
            prop.setId(list.size()+1);
        }
        try {
            w = new FileWriter(f, true);
            ch = prop.getId()+" "+prop.getNom()+" "+prop.getPrenom()+" "+prop.getAdresse();
            w.write(ch+"\n");
            w.flush();
            w.close();
        } catch (Exception e) {}
    }

    @Override
    public void update(Proprietaire prop) {
        List<Proprietaire> list = getList();
        list.set(prop.getId()-1,prop);
        ecrire(list);    
    }
    */
    
    /*
    public void ecrire(List<Proprietaire> l){
        Proprietaire prop = new Proprietaire();
        String ch = null;
        f.delete();
        Collection<Proprietaire> col=l;
        Iterator<Proprietaire> it= col.iterator();
        while(it.hasNext()){
            prop = (Proprietaire)it.next();
            try {
            w = new FileWriter(f, true);
            ch = prop.getId()+" "+prop.getNom()+" "+prop.getPrenom()+" "+prop.getAdresse();
            w.write(ch+"\n");
            w.flush();
            w.close();
        } catch (Exception e) {}
        }
    }
    */
    /*
    @Override
    public void delete(Proprietaire p) {
        List<Proprietaire> list = getList();
        list.remove(p.getId()-1);
        ecrire(list);     
    }
	*/
    @Override
    public List<Proprietaire> getList() {
        List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
        try {
        String ligne;
        BufferedReader fichier = new BufferedReader(new FileReader("C:\\Users\\Mansour\\Documents\\eclipse projects\\HelloStruts2\\files\\proprietaire.txt"));
            try{
                while ((ligne = fichier.readLine()) != null) {
                    proprietaires.add(proprietaire(ligne));
                }
                fichier.close();
            }catch(IOException io){}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return proprietaires;    
    }
    
    public Proprietaire proprietaire(String ch){
	String sortie[] = ch.split(" ");
	try{
	 Proprietaire prop =  new Proprietaire(sortie[1],sortie[2],sortie[3]);
	 prop.setId(Integer.parseInt(sortie[0]));
         return prop;
	}catch(NumberFormatException e){
		return new Proprietaire();
	}
	
    }
    
}
