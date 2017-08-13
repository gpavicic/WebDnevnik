/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import main.model.Predmet;
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
@Table(name = "tip_predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipPredmet.findAll", query = "SELECT t FROM TipPredmet t")})
public class TipPredmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tip_id")
    private Integer tipId;
    @Size(max = 45)
    @Column(name = "tip_naziv")
    private String tipNaziv;
    @OneToMany(mappedBy = "tipId")
    private List<Predmet> predmetList;

    public TipPredmet() {
    }

    public TipPredmet(Integer tipId) {
        this.tipId = tipId;
    }

    public Integer getTipId() {
        return tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }

    public String getTipNaziv() {
        return tipNaziv;
    }

    public void setTipNaziv(String tipNaziv) {
        this.tipNaziv = tipNaziv;
    }

    @XmlTransient
    public List<Predmet> getPredmetList() {
        return predmetList;
    }

    public void setPredmetList(List<Predmet> predmetList) {
        this.predmetList = predmetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipId != null ? tipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipPredmet)) {
            return false;
        }
        TipPredmet other = (TipPredmet) object;
        if ((this.tipId == null && other.tipId != null) || (this.tipId != null && !this.tipId.equals(other.tipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.TipPredmet[ tipId=" + tipId + " ]";
    }
    
}
