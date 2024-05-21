/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import viewhewan.MainViewHewan;
import viewhewan.EditViewHewan;
import viewhewan.InputViewHewan;
import java.util.List;
import java.util.ArrayList;
import DAOdata.datahewanDAO;
import DAOImplement.datahewanimplement;
import Model.*;
import javax.swing.JOptionPane;
import view.*;
/**
 *
 * @author tadeusvitoo
 */
public class datahewancontroller {
    MainViewHewan frame;
    InputViewHewan tmbh;
    EditViewHewan edit;
    datahewanimplement impldatahewan;
    List<datahewan> dh;
    
    public datahewancontroller(MainViewHewan frame){
        this.frame = frame;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public datahewancontroller(InputViewHewan tmbh){
        this.tmbh = tmbh;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public datahewancontroller(EditViewHewan edit){
        this.edit = edit;
        impldatahewan = new datahewanDAO();
        dh = impldatahewan.getAll();
    }
    
    public void isitabel(){
        dh = impldatahewan.getAll();
        modeltabeldatahewan mp = new modeltabeldatahewan(dh);
        frame.getTableDataHewan().setModel(mp);
    }
    
    public void insert(){
        datahewan dh = new datahewan();
        dh.setNama(tmbh.getJTxtnama().getText());
        dh.setKelas(tmbh.getJtxtkelas().getText());
        dh.setJenis_makanan(tmbh.getJtxtjenis_makanan().getText());
        impldatahewan.insert(dh);
        
    }
    
    public void update(){
        datahewan dh = new datahewan();
        dh.setNama(edit.getJTxtnama().getText());
        dh.setKelas(edit.getJtxtkelas().getText());
        dh.setJenis_makanan(edit.getJtxtjenis_makanan().getText());
        dh.setId(Integer.parseInt(edit.getJTxtid().getText()));
        impldatahewan.update(dh);
    }
    
    public void delete(){
        int id = frame.getSelectedId();
        if (id != -1) {
            impldatahewan.delete(id);
        }
    }
    
    public void cari(String keyword, String category) {
        List<datahewan> search = new ArrayList<>();
        List<datahewan> allData = impldatahewan.getAll();

        for (datahewan hewan : allData) {
            if (category.equalsIgnoreCase("Nama")) {
                if (hewan.getNama().equalsIgnoreCase(keyword)) {
                    search.add(hewan);
                }
            } else if (category.equalsIgnoreCase("Kelas")) {
                if (hewan.getKelas().equalsIgnoreCase(keyword)) {
                    search.add(hewan);
                }
            } else if (category.equalsIgnoreCase("JM")) {
                if (hewan.getJenis_makanan().equalsIgnoreCase(keyword)) {
                    search.add(hewan);
                }
            }
        }

        modeltabeldatahewan model = new modeltabeldatahewan(search);
        frame.getTableDataHewan().setModel(model);
        
        if (search.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Hewan tidak ditemukan!");
        }
    }
}
