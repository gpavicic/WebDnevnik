/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import main.model.PlanProgram;
import main.model.Cas;
import main.model.Ocena;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "predmet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Predmet.findAll", query = "SELECT p FROM Predmet p")})
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prd_id")
    private Integer prdId;
    @Size(max = 45)
    @Column(name = "prd_naziv")
    private String prdNaziv;
    @OneToMany(mappedBy = "prdId")
    private List<PlanProgram> planProgramList;
    @OneToMany(mappedBy = "prdId")
    private List<Cas> casList;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne
    private Profesor proId;
    @JoinColumn(name = "tip_id", referencedColumnName = "tip_id")
    @ManyToOne
    private TipPredmet tipId;
    @OneToMany(mappedBy = "prdId")
    private List<Ocena> ocenaList;

    public Predmet() {
    }

    public Predmet(Integer prdId) {
        this.prdId = prdId;
    }

    public Integer getPrdId() {
        return prdId;
    }

    public void setPrdId(Integer prdId) {
        this.prdId = prdId;
    }

    public String getPrdNaziv() {
        return prdNaziv;
    }

    public void setPrdNaziv(String prdNaziv) {
        this.prdNaziv = prdNaziv;
    }

    @XmlTransient
    public List<PlanProgram> getPlanProgramList() {
        return planProgramList;
    }

    public void setPlanProgramList(List<PlanProgram> planProgramList) {
        this.planProgramList = planProgramList;
    }

    @XmlTransient
    public List<Cas> getCasList() {
        return casList;
    }

    public void setCasList(List<Cas> casList) {
        this.casList = casList;
    }

    public Profesor getProId() {
        return proId;
    }

    public void setProId(Profesor proId) {
        this.proId = proId;
    }

    public TipPredmet getTipId() {
        return tipId;
    }

    public void setTipId(TipPredmet tipId) {
        this.tipId = tipId;
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
        hash += (prdId != null ? prdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.prdId == null && other.prdId != null) || (this.prdId != null && !this.prdId.equals(other.prdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.Predmet[ prdId=" + prdId + " ]";
    }
    
}
