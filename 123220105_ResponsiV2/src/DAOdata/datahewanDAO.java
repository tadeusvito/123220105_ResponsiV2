/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdata;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import Model.*;
import DAOImplement.datahewanimplement;
import Model.datahewan;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tadeusvitoo
 */
public class datahewanDAO implements datahewanimplement {
    Connection connection;
    
    final String select = "select * from hewan";
    final String insert = "INSERT INTO hewan (nama, kelas, jenis_makanan) VALUES (?, ?, ?);";
    final String update = "update hewan set nama=?, kelas=?, jenis_makanan=? where id=?";
    final String delete = "delete from hewan where id=?";
    
    public datahewanDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void insert(datahewan h) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, h.getNama());
            statement.setString(2, h.getKelas());
            statement.setString(3, h.getJenis_makanan());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                h.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datahewan h) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, h.getNama());
            statement.setString(2, h.getKelas());
            statement.setString(3, h.getJenis_makanan());
            statement.setInt(4, h.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datahewan> getAll() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datahewan hw = new datahewan();
                hw.setId(rs.getInt("id"));
                hw.setNama(rs.getString("nama"));
                hw.setKelas(rs.getString("kelas"));
                hw.setJenis_makanan(rs.getString("jenis_makanan"));
                dh.add(hw);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(datahewanDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dh;
    }
    
}
