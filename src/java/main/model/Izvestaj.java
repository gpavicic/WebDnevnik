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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stenci
 */
@Entity
@Table(name = "izvestaj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Izvestaj.findAll", query = "SELECT i FROM Izvestaj i")})
public class Izvestaj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "izv_id")
    private Integer izvId;
    @Size(max = 500)
    @Column(name = "izv_tekst")
    private String izvTekst;
    @Column(name = "izv_datum")
    @Temporal(TemporalType.DATE)
    private Date izvDatum;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private Profesor proId;
    @JoinColumn(name = "ucn_id", referencedColumnName = "ucn_id")
    @ManyToOne
    private Ucenik ucnId;

    public Izvestaj(String izvTekst, Date izvDatum, Profesor proId, Ucenik ucnId) {
        this.izvTekst = izvTekst;
        this.izvDatum = izvDatum;
        this.proId = proId;
        this.ucnId = ucnId;
    }

    
    
    
    public Izvestaj() {
    }

    public Izvestaj(Integer izvId) {
        this.izvId = izvId;
    }

    public Integer getIzvId() {
        return izvId;
    }

    public void setIzvId(Integer izvId) {
        this.izvId = izvId;
    }

    public String getIzvTekst() {
        return izvTekst;
    }

    public void setIzvTekst(String izvTekst) {
        this.izvTekst = izvTekst;
    }

    public Date getIzvDatum() {
        return izvDatum;
    }

    public void setIzvDatum(Date izvDatum) {
        this.izvDatum = izvDatum;
    }

    public Profesor getProId() {
        return proId;
    }

    public void setProId(Profesor proId) {
        this.proId = proId;
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
        hash += (izvId != null ? izvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Izvestaj)) {
            return false;
        }
        Izvestaj other = (Izvestaj) object;
        if ((this.izvId == null && other.izvId != null) || (this.izvId != null && !this.izvId.equals(other.izvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Izvestaj[ izvId=" + izvId + " ]";
    }
    
}
