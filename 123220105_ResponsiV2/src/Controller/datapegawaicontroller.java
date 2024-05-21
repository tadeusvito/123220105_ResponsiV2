/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.List;
import java.util.ArrayList;
import DAOdata.datapegawaiDAO;
import DAOImplement.datapegawaiimplement;
import Model.*;
import viewpegawai.*;
/**
 *
 * @author tadeusvitoo
 */
public class datapegawaicontroller {
    ViewPegawai frame;
    datapegawaiimplement impldatapegawai;
    List<datapegawai> dh;
    
    public datapegawaicontroller(ViewPegawai frame){
        this.frame = frame;
        impldatapegawai = new datapegawaiDAO();
        dh = impldatapegawai.getAll();
    }
    
    public void isitabel(){
        dh = impldatapegawai.getAll();
        modeltabeldatapegawai mp = new modeltabeldatapegawai(dh);
        frame.getTabelDataPegawai().setModel(mp);
    }
    
}
