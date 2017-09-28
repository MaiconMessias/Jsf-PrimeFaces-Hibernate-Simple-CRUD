/*******************************************************************************
 * Class responsible for implementing the SELECT, INSERT, UPDATE, REFRESH, DELETE, 
 * CANCEL, DESTROY methods called by the user through the ManagedBean of each 
 * .xhtml screen.
 ******************************************************************************/
package com.owl.dao;

import com.owl.util.HibernateUtil;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;

/** Main cadastre DAO class
 * @version 1.0
 * @author Maicon Messias
 */
public class CadastroMainDAOImpl<T> implements CadastroMainDAO<T> {
    private List<T> lista;
    private T selecionado;
    private Session selectSession;
    private Session insertOrUpdteOrDeleteSession;
    private String namedQuery;

    public CadastroMainDAOImpl(String namedQuery) {
        this.namedQuery = namedQuery;
    }

//  Method invoked in the ManagedBean @PreDestroy
    @Override
    public void onDestroy() {
        if (selectSession.isOpen()) {
            selectSession.getTransaction().begin();
            selectSession.getTransaction().rollback();
            selectSession.close();
        }

        if (insertOrUpdteOrDeleteSession != null) {
            if (insertOrUpdteOrDeleteSession.isOpen()) {
                insertOrUpdteOrDeleteSession.getTransaction().begin();
                insertOrUpdteOrDeleteSession.getTransaction().rollback();
                insertOrUpdteOrDeleteSession.close();
            }
        }
    }

//  Method used in the edit screen call, locks the record so that it is not used by users
    @Override
    public void editar() {
//      Restarts a session insertOrUpdteOrDeleteSession if competition occurs, thus preventing a session from being opened two or more times.
        if (insertOrUpdteOrDeleteSession != null) {
            if (insertOrUpdteOrDeleteSession.isOpen()) {
                insertOrUpdteOrDeleteSession.getTransaction().begin();
                insertOrUpdteOrDeleteSession.getTransaction().rollback();
                insertOrUpdteOrDeleteSession.close();
            }
        }
        insertOrUpdteOrDeleteSession = HibernateUtil.getSessionFactory().openSession();
        /** The "onDestroy" method was not executed when the browser was closed 
         * after executing the "lock" below. It was only executed when the server 
         * was terminated. This was necessary so that the locked record could be 
         * used. With the "setTimeOut(0)" method, the user trying to use the 
         * locked registry will not be able to, but will not be locked.
         */
//        insertOrUpdteOrDeleteSession.buildLockRequest(new LockOptions(LockMode.PESSIMISTIC_WRITE))
//                                                             .setTimeOut(0)
//                                                             .lock(selecionado);
        insertOrUpdteOrDeleteSession.refresh(selecionado, 
                                   new LockOptions(LockMode.PESSIMISTIC_WRITE).setTimeOut(0));
//        insertOrUpdteOrDeleteSession.refresh(selecionado);
    }

    @Override
    public void inserir(Class<T> novaClasse) throws InstantiationException, IllegalAccessException {
        this.selecionado = novaClasse.newInstance();
        insertOrUpdteOrDeleteSession = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void deletar() {
        insertOrUpdteOrDeleteSession = HibernateUtil.getSessionFactory().openSession();
        try {
            insertOrUpdteOrDeleteSession.getTransaction().begin();
            insertOrUpdteOrDeleteSession.delete(selecionado);
            insertOrUpdteOrDeleteSession.getTransaction().commit();
        } catch (RuntimeException rex) {
            insertOrUpdteOrDeleteSession.getTransaction().rollback();
            rex.printStackTrace();
        } finally {
            insertOrUpdteOrDeleteSession.close();
            atualizar();
        }
    }

    @Override
    public void salvar() {
        try {
            insertOrUpdteOrDeleteSession.getTransaction().begin();
            insertOrUpdteOrDeleteSession.saveOrUpdate(selecionado);
            insertOrUpdteOrDeleteSession.getTransaction().commit();
        } catch (RuntimeException rex) {
            insertOrUpdteOrDeleteSession.getTransaction().rollback();
            rex.printStackTrace();
        } finally {
            insertOrUpdteOrDeleteSession.close();
            atualizar();
        }
    }

    @Override
    public void cancelar() {
        if (insertOrUpdteOrDeleteSession.isOpen()) {
            insertOrUpdteOrDeleteSession.getTransaction().begin();
            insertOrUpdteOrDeleteSession.getTransaction().rollback();
            insertOrUpdteOrDeleteSession.close();
            atualizar();
        }
    }

    @Override
    public void atualizar() {
        selectSession = HibernateUtil.getSessionFactory().openSession();
        try {
            selectSession.getTransaction().begin();
            lista = selectSession.getNamedQuery(namedQuery).list();
        } catch (RuntimeException rex) {
            selectSession.getTransaction().rollback();
            rex.printStackTrace();
        } finally {
            selectSession.getTransaction().commit();
            selectSession.close();
        }
    }

//  Variables accessed by .xhtml pages
    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public T getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(T selecionado) {
        this.selecionado = selecionado;
    }
}
