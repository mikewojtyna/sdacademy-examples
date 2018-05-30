package pl.sdacademy;

import org.yaml.snakeyaml.Yaml;
import pl.sdacademy.config.Configuration;

import java.io.*;

public class Main {


    public static void main(String[] args) {

        Yaml yaml = new Yaml();
        String inputPath = "yaml_config" + File.separator + "config.yaml";

        try (BufferedReader fileInputStream =  new BufferedReader(new FileReader(inputPath));) { //używamy try-with-resources (try z zasobami) - dzięki temu mamy pewność że zawsze plik zostanie zamknięty, nie trzeba go zamykać w bloku finally
            Configuration config = yaml.loadAs( fileInputStream, Configuration.class ); //metoda loadAs oczekuje obiektu, za pomocą którego będzie mogłą przeczytać plik, drugim argumentem jest obiekt reprezentujący klasę - służy on naszej bibliotece do utworzenia obiektu żądanej klasy
            System.out.println(config); // ponieważ nasza klasa Configuration posiada przeciążoną metodę toString(), możemy wypisać ją w konsoli
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
