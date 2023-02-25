package vista;

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
import javax.swing.SwingConstants;

public class FrmConvertidor extends JFrame implements ActionListener {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantidad;
	private JButton btnConvertir;
	private JButton btnCancelar;
	private JComboBox<?> cboMonedas;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	private JLabel lblNewLabel_2;
	private JComboBox cboTipo;
	private JLabel lblCantidad;
	private JLabel lbltipo;
	private JButton btnLimpiar;
	private final JComboBox cboLongitud = new JComboBox();
	private final JComboBox cboDatos = new JComboBox();
	private final JComboBox cboMasa = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConvertidor frame = new FrmConvertidor();
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
	public FrmConvertidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CONVERTIDOR DE DIVISAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 423, 32);
		contentPane.add(lblNewLabel);

		txtCantidad = new JTextField();
		txtCantidad.setVisible(false);
		txtCantidad.setBounds(273, 134, 160, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		lbltipo = new JLabel("Seleccione tipo : ");
		lbltipo.setVisible(false);
		lbltipo.setBounds(26, 105, 126, 14);
		contentPane.add(lbltipo);

		lblCantidad = new JLabel("Ingrese la cantidad : ");
		lblCantidad.setVisible(false);
		lblCantidad.setBounds(26, 137, 126, 14);
		contentPane.add(lblCantidad);

		cboMonedas = new JComboBox();
		cboMonedas.setVisible(false);
		cboMonedas.setModel(new DefaultComboBoxModel(new String[] {"Soles a Dolar", "Soles a Euro", "Soles a Yen"}));
		cboMonedas.setBounds(273, 101, 160, 22);
		contentPane.add(cboMonedas);

		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.addActionListener(this);
		btnConvertir.setBounds(26, 173, 126, 23);
		contentPane.add(btnConvertir);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(307, 173, 126, 23);
		contentPane.add(btnCancelar);

		lblNewLabel_2 = new JLabel("Seleccione tipo de Conversion : ");
		lblNewLabel_2.setBounds(20, 54, 182, 22);
		contentPane.add(lblNewLabel_2);

		cboTipo = new JComboBox();
		cboTipo.addActionListener(this);
		cboTipo.setModel(
				new DefaultComboBoxModel(new String[] { "seleccione ... ", "monedas", "longitud", "masa", "datos" }));
		cboTipo.setBounds(273, 54, 160, 22);
		contentPane.add(cboTipo);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setVisible(false);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(162, 173, 135, 23);
		contentPane.add(btnLimpiar);
		cboLongitud.setVisible(false);

		cboLongitud.setModel(
				new DefaultComboBoxModel(new String[] {"Milimetros a Centimetros", "Centimetros a Metros", "Metros a Kilometros"}));
		cboLongitud.setBounds(273, 101, 160, 22);
		contentPane.add(cboLongitud);
		cboDatos.setVisible(false);

		cboDatos.setModel(
				new DefaultComboBoxModel(new String[] {"Byte a Kilobyte", "Kilobyte a Megabyte", "Megabyte a Gigabyte", "Gigabyte a Terabyte"}));
		cboDatos.setBounds(273, 101, 160, 22);
		contentPane.add(cboDatos);
		cboMasa.setVisible(false);

		cboMasa.setModel(new DefaultComboBoxModel(new String[] {"Gramos a Kilogramos", "Libras a Toneladas", "Toneladas a Libras"}));
		cboMasa.setBounds(273, 101, 160, 22);
		contentPane.add(cboMasa);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipo) {
			cboTipoActionPerformed(e);
		}
		if (e.getSource() == btnConvertir) {
			btnConvertirActionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			btnCancelarActionPerformed(e);
		}

		if (e.getSource() == btnLimpiar) {
			btnLimpiarActionPerformed(e);
		}

	}

	protected void btnLimpiarActionPerformed(ActionEvent e) {
		txtCantidad.setText("");
		cboMonedas.setSelectedIndex(0);
		cboMasa.setSelectedIndex(0);
		cboLongitud.setSelectedIndex(0);
		cboDatos.setSelectedIndex(0);
	}

	protected void btnCancelarActionPerformed(ActionEvent e) {
		cboTipo.setSelectedIndex(0);
		cboMonedas.setVisible(false);
		cboMasa.setVisible(false);
		cboLongitud.setVisible(false);
		cboDatos.setVisible(false);
	}

	protected void cboTipoActionPerformed(ActionEvent e) {
		switch (cboTipo.getSelectedIndex()) {
		case 0:
			lbltipo.setVisible(false);
			txtCantidad.setVisible(false);
			txtCantidad.setEnabled(false);
			lblCantidad.setVisible(false);
			cboMasa.setVisible(false);
			cboLongitud.setVisible(false);
			cboDatos.setVisible(false);
			cboMonedas.setVisible(false);
			btnCancelar.setVisible(true);
			btnCancelar.setEnabled(true);
			btnLimpiar.setVisible(false);
			btnLimpiar.setEnabled(false);
			break;
		case 1:
			lbltipo.setVisible(true);
			txtCantidad.setVisible(true);
			txtCantidad.setEnabled(true);
			lblCantidad.setVisible(true);
			cboMasa.setVisible(false);
			cboLongitud.setVisible(false);
			cboDatos.setVisible(false);
			cboMonedas.setVisible(true);
			btnCancelar.setVisible(true);
			btnCancelar.setEnabled(true);
			btnLimpiar.setVisible(true);
			btnLimpiar.setEnabled(true);
			break;

		case 2:
			lbltipo.setVisible(true);
			txtCantidad.setVisible(true);
			txtCantidad.setEnabled(true);
			lblCantidad.setVisible(true);
			cboMasa.setVisible(false);
			cboLongitud.setVisible(true);
			cboDatos.setVisible(false);
			cboMonedas.setVisible(false);
			btnCancelar.setVisible(true);
			btnCancelar.setEnabled(true);
			btnLimpiar.setVisible(true);
			btnLimpiar.setEnabled(true);
			break;
		case 3:
			lbltipo.setVisible(true);
			txtCantidad.setVisible(true);
			txtCantidad.setEnabled(true);
			lblCantidad.setVisible(true);
			cboMasa.setVisible(true);
			cboLongitud.setVisible(false);
			cboDatos.setVisible(false);
			cboMonedas.setVisible(false);
			btnCancelar.setVisible(true);
			btnCancelar.setEnabled(true);
			btnLimpiar.setVisible(true);
			btnLimpiar.setEnabled(true);
			break;
		default:
			lbltipo.setVisible(true);
			txtCantidad.setVisible(true);
			txtCantidad.setEnabled(true);
			lblCantidad.setVisible(true);
			cboMasa.setVisible(false);
			cboLongitud.setVisible(false);
			cboDatos.setVisible(true);
			cboMonedas.setVisible(false);
			btnCancelar.setVisible(true);
			btnCancelar.setEnabled(true);
			btnLimpiar.setVisible(true);
			btnLimpiar.setEnabled(true);
			break;

		}

	}

	protected void btnConvertirActionPerformed(ActionEvent e) {

		if(cboTipo.getSelectedIndex()==1) {
			
			switch (cboMonedas.getSelectedIndex()) {
			case 0:
				double dolar = Double.parseDouble(txtCantidad.getText());
				dolar = dolar * 3.84;
				df.setRoundingMode(RoundingMode.DOWN);
				df.format(dolar);
				JOptionPane.showMessageDialog(null, dolar + " Dolares");
				break;
			case 1:
				double euro = Double.parseDouble(txtCantidad.getText());
				euro = euro * 4.10;
				df.format(euro);
				df.setRoundingMode(RoundingMode.UP);
				JOptionPane.showMessageDialog(null, euro + " Euros");
				break;
			default:
				double yen = Double.parseDouble(txtCantidad.getText());
				yen = yen * 0.029;
				df.getDecimalFormatSymbols();
				JOptionPane.showMessageDialog(null, yen + " yenes");
				break;

			}
		}
		else if(cboTipo.getSelectedIndex()==2) {
			
		switch (cboLongitud.getSelectedIndex()) {
		/*
		 * Milimetros a Centimetros
Centimetros a Metros
Metros a Kilometros
		 */
		
		case 0:
			double centimetros = Double.parseDouble(txtCantidad.getText());
			centimetros = centimetros / 10;
			df.setRoundingMode(RoundingMode.DOWN);
			df.format(centimetros);
			JOptionPane.showMessageDialog(null, centimetros + " centimetros");
			break;
		case 1:
			double metros = Double.parseDouble(txtCantidad.getText());
			metros = metros / 100;
			df.setRoundingMode(RoundingMode.DOWN);
			df.format(metros);
			JOptionPane.showMessageDialog(null, metros + " metros");
			break;
		default:
			double kilometros = Double.parseDouble(txtCantidad.getText());
			kilometros = kilometros * 0.029;
			df.getDecimalFormatSymbols();
			JOptionPane.showMessageDialog(null, kilometros + " kilometros");
			break;

		}}
		
		else if(cboTipo.getSelectedIndex()==3) {
			switch (cboMasa.getSelectedIndex()) {
			
			/**Gramos a Kilogramos
Libras a Toneladas
Toneladas a Libras*/
			
			case 0:
				double kilogramos = Double.parseDouble(txtCantidad.getText());
				kilogramos = kilogramos /100;
				df.setRoundingMode(RoundingMode.DOWN);
				df.format(kilogramos);
				JOptionPane.showMessageDialog(null, kilogramos + " kilogramos");
				break;
			case 1:
				double toneladas = Double.parseDouble(txtCantidad.getText());
				toneladas = toneladas /1000;
				df.format(toneladas);
				df.setRoundingMode(RoundingMode.UP);
				JOptionPane.showMessageDialog(null, toneladas + " toneladas");
				break;
			default:
				double libras = Double.parseDouble(txtCantidad.getText());
				libras = libras * 2205;
				df.getDecimalFormatSymbols();
				JOptionPane.showMessageDialog(null, libras + " libras");
				break;

			}}
		else if(cboTipo.getSelectedIndex()==4) {
			
			switch (cboDatos.getSelectedIndex()) {
			/*
			 * Byte a Kilobyte
Kilobyte a Megabyte
Megabyte a Gigabyte
Gigabyte a Terabyte
			 */
			case 0:
				double kilobyte = Double.parseDouble(txtCantidad.getText());
				kilobyte = kilobyte /1000;
				df.setRoundingMode(RoundingMode.DOWN);
				df.format(kilobyte);
				JOptionPane.showMessageDialog(null, kilobyte + " kilobyte");
				break;
			case 1:
				double megabyte = Double.parseDouble(txtCantidad.getText());
				megabyte = megabyte /1000;
				df.format(megabyte);
				df.setRoundingMode(RoundingMode.UP);
				JOptionPane.showMessageDialog(null, megabyte + " megabyte");
				break;
			case 2:
				double gigabyte = Double.parseDouble(txtCantidad.getText());
				gigabyte = gigabyte / 4.1000;
				df.format(gigabyte);
				df.setRoundingMode(RoundingMode.UP);
				JOptionPane.showMessageDialog(null, gigabyte + " gigabyte");
				break;
			default:
				double terabyte = Double.parseDouble(txtCantidad.getText());
				terabyte = terabyte * 4.10;
				df.format(terabyte);
				df.setRoundingMode(RoundingMode.UP);
				JOptionPane.showMessageDialog(null, terabyte + " terabyte");
				break;

			}}
		
	}

}
