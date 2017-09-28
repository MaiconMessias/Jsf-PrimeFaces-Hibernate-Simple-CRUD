/*******************************************************************************
 * ManagedBean of the Employee
 ******************************************************************************/
package com.owl.managedbean;

import com.owl.dao.entity.FuncionarioDAO;
import com.owl.dao.onemenu.OneMenuCargo;
import com.owl.entity.Funcionario;
import com.owl.managedbeaninterface.CadastroMBeanMainInterface;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/** ManagedBean of the Employee
 * @version 1.0
 * @author Maicon Messias
 */
@ManagedBean(name = "funciBean")
@SessionScoped
public class FuncionarioMBean extends FuncionarioDAO 
                           implements CadastroMBeanMainInterface, Serializable {
    private static final long serialVersionUID = 113154687465457L;
    private OneMenuCargo cargoSelecionado;
    
    public FuncionarioMBean() {
        super();
    }

    @PostConstruct
    @Override
    public void init() {
        super.atualizar();
        cargoSelecionado = new OneMenuCargo();
    }

    @PreDestroy
    @Override
    public void onBeforeUnload() {
        super.onDestroy();
    }

    @Override
    public String edita() {
//      The "super.edit()" method needs to be executed before the "editOneMenu" 
//      method because of the registry locking process.
        super.editar();
        cargoSelecionado.editaOneMenu(super.getSelecionado().getCargo());
        return "cadastrofuncionario";
    }

    @Override
    public String insere() throws InstantiationException, IllegalAccessException {
        cargoSelecionado.insereOneMenu();
        super.inserir(Funcionario.class);
        return "cadastrofuncionario";
    }

    @Override
    public void deleta() {
        super.deletar();
    }

    @Override
    public String salva() {
        super.getSelecionado().setCargo(cargoSelecionado.salvaOneMenu());
        super.salvar();
        return "pesquisafuncionario";
    }

    @Override
    public String cancela() {
        cargoSelecionado.cancelaOneMenu();
        super.cancelar();
        return "pesquisafuncionario";
    }

    @Override
    public String atualiza() {
        super.atualizar();
        return "pesquisafuncionario";
    }

    public OneMenuCargo getCargoSelecionado() {
        return cargoSelecionado.getInstance();
    }
}
