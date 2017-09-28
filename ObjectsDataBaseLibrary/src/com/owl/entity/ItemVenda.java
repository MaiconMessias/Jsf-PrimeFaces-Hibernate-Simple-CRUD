/*******************************************************************************
 * This class represents an Item for Sale entity
 ******************************************************************************/
package com.owl.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/** ItemSale entity - ItemVenda
 * @version 1.0
 * @author Maicon Messias
 */
@Entity
@Table(name = "itemvenda")
public class ItemVenda implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venda", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private Venda venda;
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private Produto prod;
    
    private int qtde;

    public ItemVenda() {}

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
