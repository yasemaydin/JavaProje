import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ogrenciForm
{
	private JFrame ogrenciForm;
	private JTextField txtOgrenciKod;
	private JTextField txtOgrenciAd;
	private JTextField txtOgrenciSoyad;
	private JTextField txtOgrenciBolum;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ogrenciForm window = new ogrenciForm();
					window.ogrenciForm.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public ogrenciForm()
	{
		initialize();
	}
	
	private void initialize()
	{
		ogrenciForm = new JFrame();
		ogrenciForm.setTitle("Öğrenci Form");
		ogrenciForm.setBounds(100, 100, 400, 300);
		ogrenciForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ogrenciForm.getContentPane().setLayout(null);
		
		JLabel lblOgrenciKod = new JLabel("Öğrenci Kod:");
		lblOgrenciKod.setHorizontalAlignment(SwingConstants.CENTER);
		lblOgrenciKod.setBounds(10, 11, 154, 20);
		ogrenciForm.getContentPane().add(lblOgrenciKod);
		
		JLabel lblOgrenciAd = new JLabel("Öğrenci Ad:");
		lblOgrenciAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblOgrenciAd.setBounds(10, 42, 154, 20);
		ogrenciForm.getContentPane().add(lblOgrenciAd);
		
		JLabel lblOgrenciSoyad = new JLabel("Öğrenci Soyad:");
		lblOgrenciSoyad.setHorizontalAlignment(SwingConstants.CENTER);
		lblOgrenciSoyad.setBounds(10, 73, 154, 20);
		ogrenciForm.getContentPane().add(lblOgrenciSoyad);
		
		JLabel lblOgrenciBolum = new JLabel("Öğrenci Bölüm:");
		lblOgrenciBolum.setHorizontalAlignment(SwingConstants.CENTER);
		lblOgrenciBolum.setBounds(10, 104, 154, 20);
		ogrenciForm.getContentPane().add(lblOgrenciBolum);
		
		JLabel lblOgrenciDonem = new JLabel("Öğrenci Dönem:");
		lblOgrenciDonem.setHorizontalAlignment(SwingConstants.CENTER);
		lblOgrenciDonem.setBounds(10, 135, 154, 20);
		ogrenciForm.getContentPane().add(lblOgrenciDonem);
		
		JLabel lblDers = new JLabel("Ders:");
		lblDers.setHorizontalAlignment(SwingConstants.CENTER);
		lblDers.setBounds(10, 166, 154, 20);
		ogrenciForm.getContentPane().add(lblDers);
		
		txtOgrenciKod = new JTextField();
		txtOgrenciKod.setHorizontalAlignment(SwingConstants.CENTER);
		txtOgrenciKod.setColumns(10);
		txtOgrenciKod.setBounds(174, 11, 200, 20);
		ogrenciForm.getContentPane().add(txtOgrenciKod);
		
		txtOgrenciAd = new JTextField();
		txtOgrenciAd.setHorizontalAlignment(SwingConstants.CENTER);
		txtOgrenciAd.setColumns(10);
		txtOgrenciAd.setBounds(174, 42, 200, 20);
		ogrenciForm.getContentPane().add(txtOgrenciAd);
		
		txtOgrenciSoyad = new JTextField();
		txtOgrenciSoyad.setHorizontalAlignment(SwingConstants.CENTER);
		txtOgrenciSoyad.setColumns(10);
		txtOgrenciSoyad.setBounds(174, 73, 200, 20);
		ogrenciForm.getContentPane().add(txtOgrenciSoyad);
		
		txtOgrenciBolum = new JTextField();
		txtOgrenciBolum.setHorizontalAlignment(SwingConstants.CENTER);
		txtOgrenciBolum.setColumns(10);
		txtOgrenciBolum.setBounds(174, 104, 200, 20);
		ogrenciForm.getContentPane().add(txtOgrenciBolum);
		
		JSpinner txtOgrenciDonem = new JSpinner();
		txtOgrenciDonem.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		txtOgrenciDonem.setBounds(174, 135, 200, 20);
		ogrenciForm.getContentPane().add(txtOgrenciDonem);
		
		JComboBox<String> comboDers = new JComboBox<>();
		comboDers.setMaximumRowCount(2);
		comboDers.setBounds(174, 165, 200, 22);
		ogrenciForm.getContentPane().add(comboDers);
		
		ogrenciler.doldur(comboDers);
		
		JButton btnKaydet = new JButton("Öğrenci Kaydet");
		btnKaydet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(txtOgrenciKod.getText().isEmpty() || txtOgrenciAd.getText().isEmpty()  || txtOgrenciSoyad.getText().isEmpty() || txtOgrenciBolum.getText().isEmpty() || Integer.parseInt(txtOgrenciDonem.getValue().toString()) == 0 || comboDers.getSelectedItem().toString().isEmpty())
				{
					JOptionPane.showMessageDialog(ogrenciForm, "Lütfen Boş Alan Bırakmayın!");
				}
				else
				{
					ogrenciler nesne = new ogrenciler();
					
					nesne.ogrenciKod = txtOgrenciKod.getText().toString();
					nesne.ogrenciAd = txtOgrenciAd.getText().toString();
					nesne.ogrenciSoyad = txtOgrenciSoyad.getText().toString();
					nesne.ogrenciBolum = txtOgrenciBolum.getText().toString();
					nesne.ogrenciDonem = txtOgrenciDonem.getValue().toString();
					nesne.ders = comboDers.getSelectedItem().toString();
					
					if (nesne.kaydet(nesne))
					{
						JOptionPane.showMessageDialog(ogrenciForm, "Veriler Kayıt Edildi.");
						
						txtOgrenciKod.setText(null);
						txtOgrenciAd.setText(null);
						txtOgrenciSoyad.setText(null);
						txtOgrenciBolum.setText(null);
						txtOgrenciDonem.setValue(0);
						comboDers.setSelectedIndex(0);
					}
					else
					{
						JOptionPane.showMessageDialog(ogrenciForm, "Girilen Öğrenci Kodu ve Ders Kodu Daha Önce Kayıt Edilmiş!");
					}
				}
			}
		});
		btnKaydet.setBounds(174, 216, 200, 34);
		ogrenciForm.getContentPane().add(btnKaydet);
	}
}
