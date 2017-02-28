package banking.dao;
import java.util.List;

public abstract class DaoCompte<T> {

    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract T find(int id);

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract void create(T obj);

    /**
     * Permet de mettre à jour les données d'une entrée dans la base 
     * @param obj
     */
    public abstract void update(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    
    /*
    public abstract void delete(T obj);
    */
    
    /**
     * Permet de crediter un compte
     * @param obj
     * @param montant
     */
    public abstract T credit(T obj, double montant);
    
    /**
     * Permet de debiter un compte
     * @param obj
     * @param montant
     */
    public abstract T debit(T obj, double montant);
    
    /**
     * Permet d'effectuer un virement d'un compte vers un autre
     * @param src
     * @param dest
     * @param montant
     */
    public abstract T virement(T src, T dest, double montant);
    
    /**
     * Permet de charger la liste de compte de la BDD
     * @return 
     */
    public abstract List<T> getList();
}