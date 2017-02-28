package model;

import banking.bean.Compte;
import banking.bean.Proprietaire;
import banking.dao.DaoCompte;
import banking.dao.DaoProp;
import banking.dao.file.DaoImplProp;
import banking.dao.file.DaoImplCompte;
import java.io.IOException;

/**
 *
 * @author Mohamed Samb
 */
public class ModelImpl {
    private DaoCompte cptDAO;
    private DaoProp propsDAO;

    public ModelImpl() throws InstantiationException, IllegalAccessException, IOException {
        cptDAO = new DaoImplCompte();
        propsDAO = new DaoImplProp();
       
    }

    public DaoCompte getCptDAO() {
        return cptDAO;
    }
    
    public DaoProp getPropsDAO() {
        return propsDAO;
    }

    
}
