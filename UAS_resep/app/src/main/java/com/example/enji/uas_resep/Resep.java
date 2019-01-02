package com.example.enji.uas_resep;

/**
 * Created by enji on 1/27/2018.
 */

public class Resep {
    private long id;
    private String nama_resep;
    private String cara_pembuatan;
    private String bahan;

    public Resep()
    {
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the nama_resep
     */
    public String getNama_resep() {
        return nama_resep;
    }
    /**
     * @param nama_resep the nama_resep to set
     */
    public void setNama_resep(String nama_resep) {
        this.nama_resep = nama_resep;
    }
    /**
     * @return the menu_resep
     */
    public String getBahan() {
        return bahan;
    }
    /**
     */
    public void setBahan(String bahan) {this.bahan = bahan; }
    /**
     * @return the cara_pembuatan
     */
    public String getCara_pembuatan() {
        return cara_pembuatan;
    }
    /**
     * @param cara_pembuatan the cara_pembuatan to set
     */
    public void setCara_pembuatan(String cara_pembuatan) {
        this.cara_pembuatan = cara_pembuatan;
    }
    @Override
    public String toString()
    {

        return "\n "+ nama_resep +"\n BAHAN:"+ bahan + "\n CARA_PEMBUATAN: "+ cara_pembuatan;
    }
}
