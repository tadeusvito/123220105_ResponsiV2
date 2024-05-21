/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOImplement;
import java.util.List;
import Model.*;

/**
 *
 * @author tadeusvitoo
 */
public interface datahewanimplement {
    public void insert(datahewan h);
    public void update(datahewan h);
    public void delete(int id);
    public List<datahewan> getAll();
}
