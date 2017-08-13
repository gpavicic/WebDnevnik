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
import javax.persistence.Lob;
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
@Table(name = "plan_program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanProgram.findAll", query = "SELECT p FROM PlanProgram p")})
public class PlanProgram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "plan_id")
    private Integer planId;
    @Column(name = "plan_godina")
    private Integer planGodina;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "plan_tekst")
    private String planTekst;
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id")
    @ManyToOne
    private Predmet prdId;

    public PlanProgram() {
    }

    public PlanProgram(Integer planId) {
        this.planId = planId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getPlanGodina() {
        return planGodina;
    }

    public void setPlanGodina(Integer planGodina) {
        this.planGodina = planGodina;
    }

    public String getPlanTekst() {
        return planTekst;
    }

    public void setPlanTekst(String planTekst) {
        this.planTekst = planTekst;
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
        hash += (planId != null ? planId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanProgram)) {
            return false;
        }
        PlanProgram other = (PlanProgram) object;
        if ((this.planId == null && other.planId != null) || (this.planId != null && !this.planId.equals(other.planId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "main.PlanProgram[ planId=" + planId + " ]";
    }
    
}
