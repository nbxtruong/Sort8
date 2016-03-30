package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class WinTracer extends JFrame implements Observer {

	JLabel[] labels;

	JSlider slider;

	private static class Action {
		String name;

		Color color;

		Action(String name, Color c) {
			this.name = name;
			this.color = c;
		}
	}

	private static final Action[] ACTIONS = {
			new Action(ObservableSortableData.COMPARE_NAME, Color.red),
			new Action(ObservableSortableData.SWAP_NAME, Color.blue),
			new Action(ObservableSortableData.GET_NAME, Color.green) };

	private static final Color NORMAL_COLOR = Color.black;

	private static final Color LABELS_BG = Color.white;

	public WinTracer(final ObservableSortableData<?> data) {
		super("Sort");

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				data.deleteObserver(WinTracer.this); // Plug-out the
				// observer
			}
		});

		JPanel mainPane = new JPanel(new BorderLayout());
		JPanel labelsPane = new JPanel();
		labelsPane.setLayout(new FlowLayout(5));
		labelsPane.setBackground(LABELS_BG);
		labelsPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		labels = new JLabel[data.size()];
		for (int i = 0; i < data.size(); ++i) {
			labels[i] = new JLabel();
			labels[i].setForeground(NORMAL_COLOR);
			labelsPane.add(labels[i]);
			labels[i].setText(data.get(i).toString());
		}
		mainPane.add(labelsPane, BorderLayout.NORTH);
		slider = new JSlider();
		mainPane.add(slider, BorderLayout.SOUTH);
		setContentPane(mainPane);
		pack();
		setVisible(true);
	}

	public void update(Observable o, Object arg) {
		ObservableSortableData<?>.Operation op = (ObservableSortableData<?>.Operation) arg;
		int[] indices = op.indices();
		for (Action a : ACTIONS) {
			if (op.name().equals(a.name)) {
				for (int i : indices) {
					labels[i].setForeground(a.color);
				}
				break;
			}
		}
		if (op.name().equals(ObservableSortableData.SWAP_NAME)) {
			String tmp = labels[indices[0]].getText();
			labels[indices[0]].setText(labels[indices[1]].getText());
			labels[indices[1]].setText(tmp);
		}
		try {
			Thread.sleep(20 * slider.getValue());
		} catch (InterruptedException e) {
		}

		for (int i : indices) {
			labels[i].setForeground(NORMAL_COLOR);
		}
	}
}