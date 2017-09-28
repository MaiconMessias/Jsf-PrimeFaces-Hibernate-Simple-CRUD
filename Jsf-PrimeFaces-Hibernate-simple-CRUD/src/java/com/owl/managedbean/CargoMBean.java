/*******************************************************************************
 * ManagedBean of the Office
 ******************************************************************************/
package com.owl.managedbean;

import com.owl.dao.entity.CargoDAO;
import com.owl.entity.Cargo;
import com.owl.managedbeaninterface.CadastroMBeanMainInterface;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/** ManagedBean of the Office
 * @version 1.0
 * @author Maicon Messias
 */
@ManagedBean(name = "cargoBean")
@SessionScoped
public class CargoMBean extends CargoDAO 
                           implements CadastroMBeanMainInterface, Serializable {
    private static final long serialVersionUID = 113154687465458L;

    public CargoMBean() {
        super();
    }
    
    @PostConstruct
    @Override
    public void init() {
        super.atualizar();
    }
    
    @PreDestroy
    @Override
    public void onBeforeUnload() {
        super.onDestroy();
    }

    @Override
    public String edita() {
        super.editar();
        return "cadastrocargo";
    }

    @Override
    public String insere() throws InstantiationException, IllegalAccessException {
        super.inserir(Cargo.class);
        return "cadastrocargo";
    }

    @Override
    public void deleta() {
        super.deletar();
    }

    @Override
    public String salva() {
        super.salvar();
        return "pesquisacargo";
    }

    @Override
    public String cancela() {
        super.cancelar();
        return "pesquisacargo";
    }

    @Override
    public String atualiza() {
        super.atualizar();
        return "pesquisacargo";
    }
    
}
