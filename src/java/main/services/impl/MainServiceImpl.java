/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services.impl;

import java.util.List;
import main.model.Ocena;
import main.modelDAO.MainDAO;
import main.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stenci
 */
@Service
public class MainServiceImpl implements MainService{
    @Autowired
    MainDAO mainDAO;

    public List<Ocena> getAllOcene() {
        List<Ocena> res = mainDAO.getAllOcene();
        return res;
    }

    public void insertNovaOcena(String predmetId, String ucenikId, String ocena) throws NumberFormatException {
        mainDAO.insertNovaOcena(predmetId, ucenikId, ocena);
    }    
    
    public void insertNoviIzvestaj(String profesorId, String ucenikId, String izvestaj) throws NumberFormatException {
       mainDAO.insertNoviIzvestaj(profesorId, ucenikId, izvestaj);
    }
    
}
