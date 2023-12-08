import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dersForm
{
	private JFrame dersForm;
	private JTextField txtDersKod;
	private JTextField txtDersAd;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					dersForm window = new dersForm();
					window.dersForm.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public dersForm()
	{
		initialize();
	}
	
	private void initialize()
	{
		dersForm = new JFrame();
		dersForm.setTitle("Ders Form");
		dersForm.setBounds(100, 100, 350, 250);
		dersForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dersForm.getContentPane().setLayout(null);
		
		JLabel lblDersKod = new JLabel("Ders Kod:");
		lblDersKod.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersKod.setBounds(10, 11, 100, 20);
		dersForm.getContentPane().add(lblDersKod);
		
		JLabel lblDersAd = new JLabel("Ders Ad:");
		lblDersAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersAd.setBounds(10, 42, 100, 20);
		dersForm.getContentPane().add(lblDersAd);
		
		JLabel lblDersDonem = new JLabel("Ders Dönem:");
		lblDersDonem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersDonem.setBounds(10, 73, 100, 20);
		dersForm.getContentPane().add(lblDersDonem);
		
		JLabel lblDersKredi = new JLabel("Ders Kredi:");
		lblDersKredi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersKredi.setBounds(10, 104, 100, 20);
		dersForm.getContentPane().add(lblDersKredi);
		
		JLabel lblDersKota = new JLabel("Ders Kota:");
		lblDersKota.setHorizontalAlignment(SwingConstants.CENTER);
		lblDersKota.setBounds(10, 135, 100, 20);
		dersForm.getContentPane().add(lblDersKota);
		
		txtDersKod = new JTextField();
		txtDersKod.setHorizontalAlignment(SwingConstants.CENTER);
		txtDersKod.setColumns(10);
		txtDersKod.setBounds(120, 11, 200, 20);
		dersForm.getContentPane().add(txtDersKod);
		
		txtDersAd = new JTextField();
		txtDersAd.setHorizontalAlignment(SwingConstants.CENTER);
		txtDersAd.setColumns(10);
		txtDersAd.setBounds(120, 42, 200, 20);
		dersForm.getContentPane().add(txtDersAd);
		
		JSpinner txtDersDonem = new JSpinner();
		txtDersDonem.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		txtDersDonem.setBounds(120, 73, 200, 20);
		dersForm.getContentPane().add(txtDersDonem);
		
		JSpinner txtDersKredi = new JSpinner();
		txtDersKredi.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		txtDersKredi.setBounds(120, 104, 200, 20);
		dersForm.getContentPane().add(txtDersKredi);
		
		JSpinner txtDersKota = new JSpinner();
		txtDersKota.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		txtDersKota.setBounds(120, 135, 200, 20);
		dersForm.getContentPane().add(txtDersKota);
		
		JButton btnKaydet = new JButton("Ders Kaydet");
		btnKaydet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtDersKod.getText().isEmpty() || txtDersAd.getText().isEmpty() || Integer.parseInt(txtDersDonem.getValue().toString()) == 0 || Integer.parseInt(txtDersKredi.getValue().toString()) == 0 || Integer.parseInt(txtDersKota.getValue().toString()) == 0)
				{
					JOptionPane.showMessageDialog(dersForm, "Lütfen Boş Alan Bırakmayın!");
				}
				else
				{
					dersler nesne = new dersler();
					
					nesne.dersKod = txtDersKod.getText().toString();
					nesne.dersAd = txtDersAd.getText().toString();
					nesne.dersDonem = txtDersDonem.getValue().toString();
					nesne.dersKredi = txtDersKredi.getValue().toString();
					nesne.dersKota = txtDersKota.getValue().toString();
					
					if (nesne.kaydet(nesne))
					{
						JOptionPane.showMessageDialog(dersForm, "Veriler Kayıt Edildi.");
						
						txtDersKod.setText(null);
						txtDersAd.setText(null);
						txtDersDonem.setValue(0);
						txtDersKredi.setValue(0);
						txtDersKota.setValue(0);
					}
					else
					{
						JOptionPane.showMessageDialog(dersForm, "Girilen Ders Kodu Daha Önce Kayıt Edilmiş!");
					}
				}
			}
		});
		btnKaydet.setBounds(120, 166, 200, 34);
		dersForm.getContentPane().add(btnKaydet);
	}
}
