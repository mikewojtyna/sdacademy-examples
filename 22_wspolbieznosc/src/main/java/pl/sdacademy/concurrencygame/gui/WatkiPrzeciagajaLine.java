package pl.sdacademy.concurrencygame.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WatkiPrzeciagajaLine extends JFrame {
    private Random randomGenerator = new Random();

    public WatkiPrzeciagajaLine() throws HeadlessException {
        inicjalizacja();
    }

    public void inicjalizacja () {
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JProgressBar progress = new JProgressBar();
        progress.setValue(50); // na starcie ustawiamy wątek na 50 - czyli dokładnie na połowie - oba wątki mają równe szanse na wygraną (domślna maksymalna wartość progressbara to 100)
        getContentPane().add(progress); //dodajemy nasz progress bar do kontenera

        Runnable wLewoWatek = new Runnable() { //za pomocą klasy anonimowej definiujemy zachowanie wątku
            @Override
            public void run() {
                while(true) {
                    int oIleWLewo = -randomGenerator.nextInt(10); //losujemy wartość 0-9 - o taką wartość progress bar będzie przesuwany w lewo, wartość ta jest więc ujemna (0 jest najbliżej lewej strony)
                    przesunProgressBarIIdzSpać(progress, oIleWLewo); // dzięki zastosowaniu metody prywatnej nie duplikujemy kodu - zasada DRY (Don't Repeat Yourself)
                }
            }
        };
        Runnable wPrawoWatek = new Runnable() { //wątek przesuwający progressbar w prawo wygląda analogicznie
            @Override
            public void run() {
                while(true) {
                    int oIleWPrawo = randomGenerator.nextInt(10); //analogicznie jak wyżej, z tym, że wartość jest dodatnia - tak aby zwiększać wartość progressbara i przesuwać go w prawo (100 jest najbliżej prawej strony)
                    przesunProgressBarIIdzSpać(progress, oIleWPrawo);
                }
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2); // do uruchomienia naszych wątków używany executor service - czyli tak jak się to powinno w dzisiejszych czasach robić.
        executorService.submit(wLewoWatek); //metoda submit służy do wystartowania wątków.
        executorService.submit(wPrawoWatek);
    }

    private void przesunProgressBarIIdzSpać(JProgressBar progress, int oIle) {
        progress.setValue(progress.getValue() + oIle); // w tym miejscu ustawiamy nową wartość progress bara - zostanie to graficznie pokazane na widgecie paska postępu
        try {
            Thread.sleep(500 + randomGenerator.nextInt(500)); //nasz wątek usypiamy o wartość losową z zakresu 500-1000 ms, czyli do 500 dodajemy losową wartość z przedziału 0-500
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
