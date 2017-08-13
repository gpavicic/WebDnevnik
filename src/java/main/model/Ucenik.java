/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import main.model.Izvestaj;
import main.model.Ocena;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Stenci
 */
@Entity
@Table(name = "ucenik")
//@Scope("session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ucenik.findAll", query = "SELECT u FROM Ucenik u")})
public class Ucenik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ucn_id")
    private Integer ucnId;
    @Column(name = "kon_id")
    private Integer konId;
    @Size(max = 45)
    @Column(name = "ucn_ime")
    private String ucnIme;
    @Size(max = 45)
    @Column(name = "ucn_prezime")
    private String ucnPrezime;
    @Size(max = 45)
    @Column(name = "ucn_user")
    private String ucnUser;
    @Size(max = 45)
    @Column(name = "ucn_pass")
    private String ucnPass;
    @OneToMany(mappedBy = "ucnId")
    private List<UcnKontakt> ucnKontaktList;
    @OneToMany(mappedBy = "ucnId")
    private List<Izvestaj> izvestajList;
    @OneToMany(mappedBy = "ucnId")
    private List<Ocena> ocenaList;

    public Ucenik() {
    }

    public Ucenik(Integer ucnId) {
        this.ucnId = ucnId;
    }

    public Integer getUcnId() {
        return ucnId;
    }

    public void setUcnId(Integer ucnId) {
        this.ucnId = ucnId;
    }

    public Integer getKonId() {
        return konId;
    }

    public void setKonId(Integer konId) {
        this.konId = konId;
    }

    public String getUcnIme() {
        return ucnIme;
    }

    public void setUcnIme(String ucnIme) {
        this.ucnIme = ucnIme;
    }

    public String getUcnPrezime() {
        return ucnPrezime;
    }

    public void setUcnPrezime(String ucnPrezime) {
        this.ucnPrezime = ucnPrezime;
    }

    public String getUcnUser() {
        return ucnUser;
    }

    public void setUcnUser(String ucnUser) {
        this.ucnUser = ucnUser;
    }

    public String getUcnPass() {
        return ucnPass;
    }

    public void setUcnPass(String ucnPass) {
        this.ucnPass = ucnPass;
    }

    @XmlTransient
    public List<UcnKontakt> getUcnKontaktList() {
        return ucnKontaktList;
    }

    public void setUcnKontaktList(List<UcnKontakt> ucnKontaktList) {
        this.ucnKontaktList = ucnKontaktList;
    }

    @XmlTransient
    public List<Izvestaj> getIzvestajList() {
        return izvestajList;
    }

    public void setIzvestajList(List<Izvestaj> izvestajList) {
        this.izvestajList = izvestajList;
    }

    @XmlTransient
    public List<Ocena> getOcenaList() {
        return ocenaList;
    }

    public void setOcenaList(List<Ocena> ocenaList) {
        this.ocenaList = ocenaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ucnId != null ? ucnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ucenik)) {
            return false;
        }
        Ucenik other = (Ucenik) object;
        if ((this.ucnId == null && other.ucnId != null) || (this.ucnId != null && !this.ucnId.equals(other.ucnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Ucenik[ ucnId=" + ucnId + " ]";
    }
    
}
