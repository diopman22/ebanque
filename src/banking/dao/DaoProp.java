package banking.dao;
import java.util.List;

/**
 *
 * @author Mohamed Samb
 */
public abstract class DaoProp<T> {

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
     * @return 
     */
    
    
    //public abstract void create(T obj);
	
    /**
     * Permet de mettre à jour les données d'une entrée dans la base 
     * @param obj
     * @return 
     */
    //public abstract void update(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    //public abstract void delete(T obj);
  
     /**
     * Permet de charger la liste de compte de la BDD
     * @return 
     */
    public abstract List<T> getList();
}
