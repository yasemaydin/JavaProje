import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainForm
{
	private JFrame mainForm;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					mainForm window = new mainForm();
					window.mainForm.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public mainForm()
	{
		initialize();
	}
	
	private void initialize()
	{
		mainForm = new JFrame();
		mainForm.setTitle("Menü");
		mainForm.setBounds(100, 100, 300, 80);
		mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainForm.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnDers = new JButton("Ders Form");
		btnDers.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dersForm.main(null);
			}
		});
		mainForm.getContentPane().add(btnDers);
		
		JButton btnOgrenci = new JButton("Öğrenci Form");
		btnOgrenci.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ogrenciForm.main(null);
			}
		});
		mainForm.getContentPane().add(btnOgrenci);
	}
}
