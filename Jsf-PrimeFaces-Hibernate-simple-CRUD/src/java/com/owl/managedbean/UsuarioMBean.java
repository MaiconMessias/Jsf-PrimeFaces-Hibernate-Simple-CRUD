/*******************************************************************************
 * ManagedBean of the User
 ******************************************************************************/
package com.owl.managedbean;

import java.io.Serializable;
import com.owl.dao.entity.UsuarioDAO;
import com.owl.managedbeaninterface.CadastroMBeanMainInterface;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/** ManagedBean of the User
 * @version 1.0
 * @author Maicon Messias
 */
@ManagedBean(name = "usuarioBean")
public class UsuarioMBean extends UsuarioDAO 
                       implements CadastroMBeanMainInterface, Serializable {
    private static final long serialVersionUID = 113154687465456L;
    
    private ResourceBundle label;
    private String usuario;
    private String senha;
    private FacesContext context;
    
    @PostConstruct
    @Override
    public void init() {
        context = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();  
   	Locale locale = viewRoot.getLocale();
   	label = ResourceBundle.getBundle("com.owl.util.language", locale);
    }

    @PreDestroy
    @Override
    public void onBeforeUnload() {
        
    }
    
    public String validaUsuario() {
        if (validarUsuario(usuario, senha)) {
            getMensagemDialog(FacesMessage.SEVERITY_INFO, 
                              label.getString("login_message.informacao"), 
                              label.getString("login_message.login_sucesso"));
            return "index";
        } else {
            getMensagemDialog(FacesMessage.SEVERITY_WARN, 
                              label.getString("login_message.atencao"), 
                              label.getString("login_message.usuario_senha_invalidos"));
            return "";
        }
    }

    private void getMensagemDialog(Severity icon, String titulo, String msg) {
            context.addMessage(null, new FacesMessage(icon, titulo, msg));
    }
    
    @Override
    public String edita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insere() throws InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String salva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cancela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String atualiza() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    Variables used in screens .xhtml
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
