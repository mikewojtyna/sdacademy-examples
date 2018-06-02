package pl.sdacademy.swing.hello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AppBootstrapper {
	static void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final JFrame jFrame = new JFrame();
				jFrame.setLayout(new FlowLayout());
				jFrame.setTitle("First Swing App");
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				final JTextField textField = new JTextField("Hello World!");
				jFrame.add(textField);
				JButton button = new JButton("AAA");

				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						textField.setText("You clicked!");
						jFrame.getContentPane().setBackground(new Color(255, 0, 0));
					}
				});

				jFrame.add(button);
				jFrame.setPreferredSize(new Dimension(320, 240));
				jFrame.pack();
				jFrame.setVisible(true);
			}
		});
	}
}
