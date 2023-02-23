package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Font;

public class Vista extends JFrame implements ActionListener {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtDivisa;
    private JButton btnConvertir;
    private JButton btnCancelar;
    private JComboBox<?> cboDivisa;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Vista frame = new Vista();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Vista() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 325, 218);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("CONVERTIDOR DE DIVISAS");
	lblNewLabel.setBounds(129, 11, 152, 14);
	contentPane.add(lblNewLabel);

	txtDivisa = new JTextField();
	txtDivisa.setBounds(149, 103, 129, 20);
	contentPane.add(txtDivisa);
	txtDivisa.setColumns(10);

	JLabel lblNewLabel_1 = new JLabel("Seleccione tipo : ");
	lblNewLabel_1.setBounds(30, 54, 126, 14);
	contentPane.add(lblNewLabel_1);

	JLabel lblNewLabel_2 = new JLabel("Ingrese la cantidad : ");
	lblNewLabel_2.setBounds(30, 106, 126, 14);
	contentPane.add(lblNewLabel_2);

	cboDivisa = new JComboBox();
	cboDivisa.setModel(new DefaultComboBoxModel(new String[] { "Dolar", "Euro", "Yen" }));
	cboDivisa.setBounds(149, 50, 118, 22);
	contentPane.add(cboDivisa);

	btnConvertir = new JButton("CONVERTIR");
	btnConvertir.addActionListener(this);
	btnConvertir.setBounds(31, 142, 118, 23);
	contentPane.add(btnConvertir);

	btnCancelar = new JButton("CANCELAR");
	btnCancelar.addActionListener(this);
	btnCancelar.setBounds(159, 142, 118, 23);
	contentPane.add(btnCancelar);
    }

    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btnConvertir) {
	    btnConvertirActionPerformed(e);
	}
	if (e.getSource() == btnCancelar) {
	    btnCancelarActionPerformed(e);
	}
    }

    protected void btnCancelarActionPerformed(ActionEvent e) {
	txtDivisa.setText("");
	cboDivisa.setSelectedIndex(0);
    }

    protected void btnConvertirActionPerformed(ActionEvent e) {

	
	switch (cboDivisa.getSelectedIndex()) {
	case 0:
	    double dolar = Double.parseDouble(txtDivisa.getText());
	    dolar = dolar * 3.84;
	    df.setRoundingMode(RoundingMode.DOWN);
	    df.format(dolar);

	    JOptionPane.showMessageDialog(null, dolar);
	    break;
	case 1:
	    double euro = Double.parseDouble(txtDivisa.getText());
	    euro = euro * 4.10;
	    df.format(euro);
	    df.setRoundingMode(RoundingMode.UP);
	    JOptionPane.showMessageDialog(null, euro + " Euros");
	    break;
	default:
	    double yen = Double.parseDouble(txtDivisa.getText());
	    yen = yen * 0.029;
	    df.getDecimalFormatSymbols();
	    JOptionPane.showMessageDialog(null, yen);
	    break;

	}
    }
}
