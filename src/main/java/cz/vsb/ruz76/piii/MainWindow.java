package cz.vsb.ruz76.piii;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruz76 on 12.4.2017.
 */
public class MainWindow extends JFrame {
    private JTextField txtLongitude;
    private JTextField txtLatitude;
    private JButton btnInterpolate;
    private JTextField txtResult;
    private JPanel mainPanel;
    private JComboBox cmbType;

    public MainWindow(){
        this.getContentPane().add(mainPanel);
        List<String> ls = new ArrayList<String>();
        ls.add("Teplota");
        ls.add("Tlak");
        ls.add("Prach");
        cmbType.setModel(new DefaultComboBoxModel(ls.toArray()));
        btnInterpolate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double x = Double.parseDouble(txtLongitude.getText());
                double y = Double.parseDouble(txtLatitude.getText());
                Point p = new Point(x, y);
                double prumer = MeasuresStorage.getInstance().getIDW(p, cmbType.getSelectedIndex());
                prumer = Math.round(prumer*100) / 100d;
                txtResult.setText(String.valueOf(prumer));
            }
        });
    }
}
