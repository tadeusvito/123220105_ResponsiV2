/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tadeusvitoo
 */
public class datahewan {
    private Integer id;
    private String nama;
    private String kelas;
    private String jenis_makanan;
    
    public datahewan() {
    }
    
    public datahewan(int id, String nama, String kelas, String jenis_makanan) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.jenis_makanan = jenis_makanan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJenis_makanan() {
        return jenis_makanan;
    }

    public void setJenis_makanan(String jenis_makanan) {
        this.jenis_makanan = jenis_makanan;
    }
}
