package pl.sdacademy.swing.fancy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class AppBootstrapper {

	private ScheduledFuture<?> bottomLeftFuture;

	private ScheduledFuture<?> bottomRightFuture;
	private ScheduledFuture<?> upperLeftFuture;
	private ScheduledFuture<?> upperRightFuture;

	private boolean cancelFuture(Future<?> future) {
		if (future != null) {
			return future.cancel(true);
		}
		return false;
	}

	private ScheduledFuture<?> lightUpComponent(final Component component) {
		final Random random = new Random();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		final ScheduledFuture<?> future = executor.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						component.setBackground(new Color(random.nextInt(256), random.nextInt
							(256), random.nextInt(256)));
					}
				});
			}
		}, 10, 50, TimeUnit.MILLISECONDS);
		executor.schedule(new Runnable() {

			@Override
			public void run() {
				future.cancel(false);
			}
		}, 10, TimeUnit.SECONDS);
		return future;
	}

	void start() {
		final int size = 2;
		final List<List<JTextFieldDestination>> textFields = new ArrayList<>();
		final JTextField selectedCellMessageTextField = new JTextField();
		selectedCellMessageTextField.setHorizontalAlignment(JTextField.CENTER);
		for (int x = 0; x < size; x++) {
			List<JTextFieldDestination> column = new ArrayList<>(size);
			for (int y = 0; y < size; y++) {
				final JTextFieldDestination textFieldWrapper = new JTextFieldDestination(new
					Destination(x, y));
				textFieldWrapper.setText("Hello World!");
				textFieldWrapper.setHorizontalAlignment(JTextField.CENTER);
				textFieldWrapper.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						textFieldWrapper.setText("Don't click me!");
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						textFieldWrapper.setBackground(new Color(255, 0, 0));
						selectedCellMessageTextField.setText(String.format("You selected cell " +
							"" + "" + "" + "" + "" + "" + "[%d, %d]", textFieldWrapper
							.getDest().getX(), textFieldWrapper.getDest().getY()));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						textFieldWrapper.setBackground(new Color(255, 255, 255));
					}

					@Override
					public void mousePressed(MouseEvent e) {

					}

					@Override
					public void mouseReleased(MouseEvent e) {
					}
				});
				column.add(textFieldWrapper);
			}
			textFields.add(column);
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame mainWindow = new JFrame("Swing Hello World!");
				GridLayout gridLayout = new GridLayout(size, size);
				JPanel panel = new JPanel();
				panel.setLayout(gridLayout);
				BoxLayout boxLayout = new BoxLayout(mainWindow.getContentPane(), BoxLayout.Y_AXIS);
				mainWindow.setLayout(boxLayout);
				for (int i = 0; i < textFields.size(); i++) {
					for (JTextFieldDestination textField : textFields.get(i)) {
						panel.add(textField);
					}
				}
				panel.setPreferredSize(new Dimension(640, 480));
				mainWindow.add(panel);
				mainWindow.add(selectedCellMessageTextField);

				JButton upperLeftCellButton = new JButton();
				upperLeftCellButton.setText("Light up upper-left cell");
				upperLeftCellButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!cancelFuture(upperLeftFuture)) {
							upperLeftFuture = lightUpComponent(textFields.get(0).get(0));
						}
					}
				});
				JButton upperRightCellButton = new JButton();
				upperRightCellButton.setText("Light up upper-right cell");
				upperRightCellButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!cancelFuture(upperRightFuture)) {
							upperRightFuture = lightUpComponent(textFields.get(0).get(1));
						}
					}

				});
				JButton bottonLeftCellButton = new JButton();
				bottonLeftCellButton.setText("Light up bottom-left cell");
				bottonLeftCellButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!cancelFuture(bottomLeftFuture)) {
							bottomLeftFuture = lightUpComponent(textFields.get(1).get(0));
						}
					}
				});
				JButton bottomRightCellButton = new JButton();
				bottomRightCellButton.setText("Light up bottom-right cell");
				bottomRightCellButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (!cancelFuture(bottomRightFuture)) {
							bottomRightFuture = lightUpComponent(textFields.get(1).get(1));
						}
					}
				});

				JPanel buttonsPanel = new JPanel(new FlowLayout());
				buttonsPanel.add(upperLeftCellButton);
				buttonsPanel.add(upperRightCellButton);
				buttonsPanel.add(bottonLeftCellButton);
				buttonsPanel.add(bottomRightCellButton);
				mainWindow.add(buttonsPanel);

				mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainWindow.pack();
				mainWindow.setVisible(true);
			}
		});
	}

	private class JTextFieldDestination extends JTextField {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;
		private final Destination dest;

		/**
		 * @param dest
		 */
		public JTextFieldDestination(Destination dest) {
			super();
			this.dest = dest;
		}

		public Destination getDest() {
			return dest;
		}
	}

	private class Destination {
		private final int x;
		private final int y;

		/**
		 * @param x
		 * @param y
		 */
		Destination(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}

}
