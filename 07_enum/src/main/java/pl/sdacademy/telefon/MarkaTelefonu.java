package pl.sdacademy.telefon;

public enum MarkaTelefonu {
    SAMSUNG(3),
    HUAWEI(2),
    IPHONE(2),
    LENOVO(1),
    XIAO_MI(3);


    private final int popularnosc;

    MarkaTelefonu(int popularonosc) {
        this.popularnosc = popularonosc;
    }

    public int getPopularnosc() {
        return popularnosc;
    }
}
