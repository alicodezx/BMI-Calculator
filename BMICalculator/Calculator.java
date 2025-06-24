package bmicalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JLabel heading = new JLabel("BMI Calculator");
    JLabel weight = new JLabel("Weight (kg): ");
    JLabel height = new JLabel("Height (cm): ");
    JTextField weight_field = new JTextField();
    JTextField height_field = new JTextField();
    JLabel displayResult = new JLabel();
    JButton btn = new JButton("Calculate");

    Calculator() {
        this.setSize(500, 500);
        this.setTitle("BMI Calculator");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        heading.setHorizontalAlignment(JLabel.CENTER);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setFont(heading.getFont().deriveFont(24f));
        heading.setBounds(0, 20, 500, 50);

        weight.setFont(weight.getFont().deriveFont(16f));
        weight.setBounds(125, 100, 100, 100);

        height.setFont(height.getFont().deriveFont(16f));
        height.setBounds(125, 175, 100, 100);

        weight_field.setBounds(225, 140, 125, 25);
        height_field.setBounds(225, 215, 125, 25);

        displayResult.setFont(displayResult.getFont().deriveFont(16f));
        displayResult.setBounds(125, 270, 300, 100);

        btn.setBounds(165, 350, 150, 45);
        btn.setBackground(Color.green);
        btn.addActionListener(this);

        this.add(heading);
        this.add(weight);
        this.add(height);
        this.add(weight_field);
        this.add(height_field);
        this.add(btn);
        this.add(displayResult);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            try {
                double weight = Double.parseDouble(weight_field.getText());
                double height_cm = Double.parseDouble(height_field.getText());

                if (weight <= 0 || height_cm <= 0) {
                    displayResult.setText("Please enter positive values.");
                    return;
                }

                double height_m = height_cm / 100.0;
                double bmi = weight / (height_m * height_m);

                String category;
                if (bmi < 18.5)
                    category = "Underweight";
                else if (bmi < 24.9)
                    category = "Normal weight";
                else if (bmi < 29.9)
                    category = "Overweight";
                else
                    category = "Obese";

                displayResult.setText(String.format("Your BMI is: %.2f (%s)", bmi, category));
            } catch (NumberFormatException ex) {
                displayResult.setText("Invalid input. Please enter numbers only.");
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
