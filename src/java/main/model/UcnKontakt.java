/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import main.model.Ucenik;
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
@Table(name = "ucn_kontakt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UcnKontakt.findAll", query = "SELECT u FROM UcnKontakt u")})
public class UcnKontakt implements Serializable {

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
    @JoinColumn(name = "ucn_id", referencedColumnName = "ucn_id")
    @ManyToOne
    private Ucenik ucnId;

    public UcnKontakt() {
    }

    public UcnKontakt(Integer konId) {
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

    public Ucenik getUcnId() {
        return ucnId;
    }

    public void setUcnId(Ucenik ucnId) {
        this.ucnId = ucnId;
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
        if (!(object instanceof UcnKontakt)) {
            return false;
        }
        UcnKontakt other = (UcnKontakt) object;
        if ((this.konId == null && other.konId != null) || (this.konId != null && !this.konId.equals(other.konId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.UcnKontakt[ konId=" + konId + " ]";
    }
    
}
