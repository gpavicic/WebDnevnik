/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import main.model.ProKontakt;
import main.model.Predmet;
import main.model.Izvestaj;
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

/**
 *
 * @author Stenci
 */
@Entity
@Table(name = "profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Column(name = "kon_id")
    private Integer konId;
    @Size(max = 45)
    @Column(name = "pro_ime")
    private String proIme;
    @Size(max = 45)
    @Column(name = "pro_prezime")
    private String proPrezime;
    @Size(max = 45)
    @Column(name = "pro_user")
    private String proUser;
    @Size(max = 45)
    @Column(name = "pro_pass")
    private String proPass;
    @OneToMany(mappedBy = "proId")
    private List<ProKontakt> proKontaktList;
    @OneToMany(mappedBy = "proId")
    private List<Predmet> predmetList;
    @OneToMany(mappedBy = "proId")
    private List<Izvestaj> izvestajList;

    public Profesor() {
    }

    public Profesor(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getKonId() {
        return konId;
    }

    public void setKonId(Integer konId) {
        this.konId = konId;
    }

    public String getProIme() {
        return proIme;
    }

    public void setProIme(String proIme) {
        this.proIme = proIme;
    }

    public String getProPrezime() {
        return proPrezime;
    }

    public void setProPrezime(String proPrezime) {
        this.proPrezime = proPrezime;
    }

    public String getProUser() {
        return proUser;
    }

    public void setProUser(String proUser) {
        this.proUser = proUser;
    }

    public String getProPass() {
        return proPass;
    }

    public void setProPass(String proPass) {
        this.proPass = proPass;
    }

    @XmlTransient
    public List<ProKontakt> getProKontaktList() {
        return proKontaktList;
    }

    public void setProKontaktList(List<ProKontakt> proKontaktList) {
        this.proKontaktList = proKontaktList;
    }

    @XmlTransient
    public List<Predmet> getPredmetList() {
        return predmetList;
    }

    public void setPredmetList(List<Predmet> predmetList) {
        this.predmetList = predmetList;
    }

    @XmlTransient
    public List<Izvestaj> getIzvestajList() {
        return izvestajList;
    }

    public void setIzvestajList(List<Izvestaj> izvestajList) {
        this.izvestajList = izvestajList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Profesor[ proId=" + proId + " ]";
    }
    
}
