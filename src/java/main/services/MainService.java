/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services;

import java.util.List;
import main.model.Ocena;

/**
 *
 * @author Stenci
 */

public interface MainService {

    List<Ocena> getAllOcene();

    void insertNovaOcena(String predmetId, String ucenikId, String ocena) throws NumberFormatException;
    
    void insertNoviIzvestaj(String profesorId, String ucenikId, String izvestaj) throws NumberFormatException;

}
