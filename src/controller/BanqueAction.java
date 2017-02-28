package controller;

import com.opensymphony.xwork2.ActionSupport;
import banking.bean.Compte;
import banking.bean.Proprietaire;
import java.io.IOException;
import model.ModelImpl;

/**
 *
 * @author Mohamed Samb
 */
public class BanqueAction extends ActionSupport{
    private Compte cpt = new Compte();
    private Compte cptDest = new Compte();
    private Proprietaire prop = new Proprietaire();
    private ModelImpl model;
    public double montant;//la somme a debiter ou a crediter
    public int idCourant;

    public BanqueAction() throws InstantiationException, IllegalAccessException, IOException {
        model = new ModelImpl();
    }

    public Proprietaire getProp() {
        return prop;
    }

    public void setProp(Proprietaire prop) {
        this.prop = prop;
    }

    public Compte getCptDest() {
        return cptDest;
    }

    public void setCptDest(Compte cptDest) {
        this.cptDest = cptDest;
    }

    public int getIdCourant() {
        return idCourant;
    }

    public void setIdCourant(int idCourant) {
        this.idCourant = idCourant;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCpt() {
        return cpt;
    }

    public void setCpt(Compte cpt) {
        this.cpt = cpt;
    }
    

    public ModelImpl getModel() {
        return model;
    }

    public void setModel(ModelImpl model) {
        this.model = model;
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    
    
    public String list() throws IOException{
        return SUCCESS;
    }
    
    public String create(){
 
        if(cpt.getNomProp()==null){
            return INPUT;
        }
        
        model.getCptDAO().create(cpt);

        return SUCCESS;
    }
    
    public String editer(){
        if((cpt.getDebitMax()==0) || (cpt==null)){
            cpt = (Compte) model.getCptDAO().find(idCourant);
            
            
            System.out.print("Debit max "+cpt.getDebitMax());
            
            return INPUT;
        }
        
        return SUCCESS;
        
        
    }
    /*
    public String delete(Compte cpt){
        model.getCptDAO().delete(cpt);
        return SUCCESS;
    }
    */
    
    public String debiter(){
        if(montant==0){
            return INPUT;
        }
        cpt = (Compte) model.getCptDAO().find(cpt.getIdCompte());
        System.out.println(cpt.getAdresseProp());
        model.getCptDAO().debit(cpt, montant);
        return SUCCESS;
    }
    
    public String crediter(){
        if(montant==0){
            return INPUT;
        }
        cpt = (Compte) model.getCptDAO().find(cpt.getIdCompte());
        model.getCptDAO().credit(cpt, montant);
        return SUCCESS;
    }
    
    public String virement(){
        if(montant==0){
            return INPUT;
        }
        cpt = (Compte) model.getCptDAO().find(cpt.getIdCompte());
        cptDest = (Compte) model.getCptDAO().find(cptDest.getIdCompte());
        model.getCptDAO().virement(cpt, cptDest, montant);
        return SUCCESS;
    }
    
}
