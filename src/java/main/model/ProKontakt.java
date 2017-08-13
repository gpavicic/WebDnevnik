/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stenci
 */
@Entity
@Table(name = "pro_kontakt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProKontakt.findAll", query = "SELECT p FROM ProKontakt p")})
public class ProKontakt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kon_id")
    private Integer konId;
    @Size(max = 45)
    @Column(name = "kon_adresa")
    private String konAdresa;
    @Size(max = 45)
    @Column(name = "kon_telefon")
    private String konTelefon;
    @Size(max = 45)
    @Column(name = "kon_email")
    private String konEmail;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private Profesor proId;

    public ProKontakt() {
    }

    public ProKontakt(Integer konId) {
        this.konId = konId;
    }

    public Integer getKonId() {
        return konId;
    }

    public void setKonId(Integer konId) {
        this.konId = konId;
    }

    public String getKonAdresa() {
        return konAdresa;
    }

    public void setKonAdresa(String konAdresa) {
        this.konAdresa = konAdresa;
    }

    public String getKonTelefon() {
        return konTelefon;
    }

    public void setKonTelefon(String konTelefon) {
        this.konTelefon = konTelefon;
    }

    public String getKonEmail() {
        return konEmail;
    }

    public void setKonEmail(String konEmail) {
        this.konEmail = konEmail;
    }

    public Profesor getProId() {
        return proId;
    }

    public void setProId(Profesor proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (konId != null ? konId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProKontakt)) {
            return false;
        }
        ProKontakt other = (ProKontakt) object;
        if ((this.konId == null && other.konId != null) || (this.konId != null && !this.konId.equals(other.konId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.ProKontakt[ konId=" + konId + " ]";
    }
    
}
