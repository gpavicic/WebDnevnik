/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stenci
 */
@Entity
@Table(name = "cas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cas.findAll", query = "SELECT c FROM Cas c")})
public class Cas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cas_id")
    private Integer casId;
    @Column(name = "cas_datum")
    @Temporal(TemporalType.DATE)
    private Date casDatum;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private Predmet prdId;

    public Cas() {
    }

    public Cas(Integer casId) {
        this.casId = casId;
    }

    public Integer getCasId() {
        return casId;
    }

    public void setCasId(Integer casId) {
        this.casId = casId;
    }

    public Date getCasDatum() {
        return casDatum;
    }

    public void setCasDatum(Date casDatum) {
        this.casDatum = casDatum;
    }

    public Predmet getPrdId() {
        return prdId;
    }

    public void setPrdId(Predmet prdId) {
        this.prdId = prdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (casId != null ? casId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cas)) {
            return false;
        }
        Cas other = (Cas) object;
        if ((this.casId == null && other.casId != null) || (this.casId != null && !this.casId.equals(other.casId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Cas[ casId=" + casId + " ]";
    }
    
}
