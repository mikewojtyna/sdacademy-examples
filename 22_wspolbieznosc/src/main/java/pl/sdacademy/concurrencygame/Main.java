package pl.sdacademy.concurrencygame;


import pl.sdacademy.concurrencygame.gui.WatkiPrzeciagajaLine;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WatkiPrzeciagajaLine().setVisible(true);
            }
        });
    }
}
