package pl.sdacademy.stream.movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film { //film jest klasą danych - trzyma inforamcje o jednym filmie. Posiada kilka pól - tytuł, reżysera, rok premiery itd. Posiada jedynie gettery i settery oraz przeciążoną metodę toString() - nie posiada żadnych dodatkowych metod do przetwarzania swoich danych. W javie często można spotkać takie obiekty - w javie EE będą to JavaBeans.
    String tytuł;
    String rezyser;
    LocalDate rokPremiery;
    double cenaDVD;
    List<String> listaGatunków;
    List<String> listaAktorów;

    public Film(String tytuł, String rezyser, LocalDate rokPremiery, double cenaDVD, List<String> listaGatunków, List<String> listaAktorów) {
        this.tytuł = tytuł;
        this.rezyser = rezyser;
        this.rokPremiery = rokPremiery;
        this.cenaDVD = cenaDVD;
        this.listaGatunków = listaGatunków;
        this.listaAktorów = listaAktorów;
    }

    public Film(Film filmDoSkopiowania) { // to jest konstruktor kopiujący - kopiuje obiekt przekazany jako argument do naszego nowego obiektu
        this.tytuł = filmDoSkopiowania.getTytuł();
        this.rezyser = filmDoSkopiowania.getRezyser();
        this.rokPremiery = filmDoSkopiowania.getRokPremiery();
        this.cenaDVD = filmDoSkopiowania.getCenaDVD();
        this.listaGatunków = new ArrayList<>();
        this.listaGatunków.addAll(filmDoSkopiowania.getListaGatunków());
        this.listaAktorów = new ArrayList<>();
        this.listaAktorów.addAll(filmDoSkopiowania.getListaAktorów());
    }

    public String getTytuł() {
        return tytuł;
    }

    public String getRezyser() {
        return rezyser;
    }

    public LocalDate getRokPremiery() {
        return rokPremiery;
    }

    public double getCenaDVD() {
        return cenaDVD;
    }

    public List<String> getListaGatunków() {
        return listaGatunków;
    }

    public List<String> getListaAktorów() {
        return listaAktorów;
    }


    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public void setRezyser(String rezyser) {
        this.rezyser = rezyser;
    }

    public void setRokPremiery(LocalDate rokPremiery) {
        this.rokPremiery = rokPremiery;
    }

    public void setCenaDVD(double cenaDVD) {
        this.cenaDVD = cenaDVD;
    }

    public void setListaGatunków(List<String> listaGatunków) {
        this.listaGatunków = listaGatunków;
    }

    public void setListaAktorów(List<String> listaAktorów) {
        this.listaAktorów = listaAktorów;
    }

    @Override
    public String toString() {
        return "Film{" +
                "tytuł='" + tytuł + '\'' +
                ", rezyser='" + rezyser + '\'' +
                ", rokPremiery=" + rokPremiery +
                ", cenaDVD=" + cenaDVD +
                ", listaGatunków=" + listaGatunków +
                ", listaAktorów=" + listaAktorów +
                '}';
    }
}
