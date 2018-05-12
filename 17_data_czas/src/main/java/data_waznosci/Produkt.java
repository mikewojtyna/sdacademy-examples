package data_waznosci;


public class Produkt {
    private String nazwa;
    private String dataWażności;

    public Produkt(String nazwa, String dataWażności) {
        this.nazwa = nazwa;
        this.dataWażności = dataWażności;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getDataWażności() {
        return dataWażności;
    }
}
