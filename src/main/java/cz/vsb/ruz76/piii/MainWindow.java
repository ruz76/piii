package cz.vsb.ruz76.piii;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jencek on 12.4.17.
 */
public class MainWindow extends JFrame {
    private JPanel panel1;
    private JTextField x;
    private JTextField y;
    private JButton btnCompute;
    private JTextField output;

    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel1);
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temperature = MeasuresStorage.getInstance().getAverageTemperature();
                temperature = Math.round(temperature * 100) / 100d;
                output.setText(String.valueOf(temperature));
            }
        });
    }
}
