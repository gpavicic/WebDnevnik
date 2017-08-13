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
@Table(name = "ocena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocena.findAll", query = "SELECT o FROM Ocena o")})
public class Ocena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ocn_id")
    private Integer ocnId;
    @Column(name = "ocn_ocena")
    private Integer ocnOcena;
    @Column(name = "ocn_datum")
    @Temporal(TemporalType.DATE)
    private Date ocnDatum;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private Predmet prdId;
    @JoinColumn(name = "ucn_id", referencedColumnName = "ucn_id")
    @ManyToOne
    private Ucenik ucnId;

    public Ocena(Integer ocnOcena, Date ocnDatum, Predmet prdId, Ucenik ucnId) {
        this.ocnOcena = ocnOcena;
        this.ocnDatum = ocnDatum;
        this.prdId = prdId;
        this.ucnId = ucnId;
    }

    
    
    

    public Ocena() {
    }

    public Ocena(Integer ocnId) {
        this.ocnId = ocnId;
    }

    public Integer getOcnId() {
        return ocnId;
    }

    public void setOcnId(Integer ocnId) {
        this.ocnId = ocnId;
    }

    public Integer getOcnOcena() {
        return ocnOcena;
    }

    public void setOcnOcena(Integer ocnOcena) {
        this.ocnOcena = ocnOcena;
    }

    public Date getOcnDatum() {
        return ocnDatum;
    }

    public void setOcnDatum(Date ocnDatum) {
        this.ocnDatum = ocnDatum;
    }

    public Predmet getPrdId() {
        return prdId;
    }

    public void setPrdId(Predmet prdId) {
        this.prdId = prdId;
    }

    public Ucenik getUcnId() {
        return ucnId;
    }

    public void setUcnId(Ucenik ucnId) {
        this.ucnId = ucnId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ocnId != null ? ocnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocena)) {
            return false;
        }
        Ocena other = (Ocena) object;
        if ((this.ocnId == null && other.ocnId != null) || (this.ocnId != null && !this.ocnId.equals(other.ocnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Ocena[ ocnId=" + ocnId + " ]";
    }
    
}
