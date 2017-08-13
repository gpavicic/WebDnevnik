/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modelDAO;

import java.util.Date;
import java.util.List;
import main.model.Izvestaj;
import main.model.Predmet;
import main.model.Profesor;
import main.model.Ucenik;
import main.model.Ocena;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stenci
 */
@Repository
public class MainDAO {

    public List<Ocena> getAllOcene() {
        List<Ocena> res = DB.query("SELECT o FROM Ocena o ");
        return res;
    }

    public void insertNovaOcena(String predmetId, String ucenikId, String ocena) throws NumberFormatException {
        Predmet prd = (Predmet) DB.query("SELECT p FROM Predmet p WHERE p.prdId=?1", Integer.valueOf(predmetId)).get(0);
        Ucenik uck = (Ucenik) DB.query("SELECT u FROM Ucenik u WHERE u.ucnId=?1", Integer.valueOf(ucenikId)).get(0);

        Ocena novaOcena = new Ocena();
        novaOcena.setOcnDatum(new Date());
        novaOcena.setPrdId(prd);
        novaOcena.setUcnId(uck);
        novaOcena.setOcnOcena(Integer.valueOf(ocena));

        DB.insertNativeSQL(novaOcena);
    }

    public void insertNoviIzvestaj(String profesorId, String ucenikId, String izvestaj) throws NumberFormatException {
        Profesor pro = (Profesor) DB.query("SELECT p FROM Profesor p WHERE p.proId=?1", Integer.valueOf(profesorId)).get(0);
        Ucenik uck = (Ucenik) DB.query("SELECT u FROM Ucenik u WHERE u.ucnId=?1", Integer.valueOf(ucenikId)).get(0);

        Izvestaj noviIzvestaj = new Izvestaj();
        noviIzvestaj.setIzvDatum(new Date());
        noviIzvestaj.setProId(pro);
        noviIzvestaj.setUcnId(uck);
        noviIzvestaj.setIzvTekst(izvestaj);

        DB.insertNativeSQL1(noviIzvestaj);
    }

}
