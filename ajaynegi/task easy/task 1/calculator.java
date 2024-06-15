package ajaynegi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator extends JFrame implements ActionListener {
	// Create a text-field
	private final JTextField textField;
	// Store operator and operands
	private String operator;
	private double num1;
	private double result;

	// Default constructor
	public calculator() {
		// Create a frame
		// Create a frame
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 600);
		frame.setLayout(new BorderLayout());

		// Create a text-field
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 24));
		frame.add(textField, BorderLayout.NORTH);

		// Create a panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));

		// Create number buttons and some operators
		String[] buttons = {
				"7", "8", "9", "/",
				"4", "5", "6", "*",
				"1", "2", "3", "-",
				"0", ".", "=", "+"
		};

		// Add buttons to the panel
		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.PLAIN, 24));
			button.addActionListener(this);
			panel.add(button);
		}

		// Add panel to frame
		frame.add(panel);

		// Set visibility
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
			textField.setText(textField.getText() + command);
		} else if (command.equals("=")) {
			if (!operator.isEmpty()) {
				double num2 = Double.parseDouble(textField.getText());

				switch (operator) {
					case "+":
						result = num1 + num2;
						break;
					case "-":
						result = num1 - num2;
						break;
					case "*":
						result = num1 * num2;
						break;
					case "/":
						if (num2 != 0) {
							result = num1 / num2;
						} else {
							textField.setText("Error: Divide by zero");
							return;
						}
						break;
				}

				textField.setText(String.valueOf(result));
				operator = "";
			}
		} else {
			if (!operator.isEmpty()) {
				return;
			}

			num1 = Double.parseDouble(textField.getText());
			operator = command;
			textField.setText("");
		}
	}

	public static void main(String[] args) {
		// Create an instance of calculator
		new calculator();
	}
}
