import java.io.*;
import javax.swing.*;

public class ogrenciler
{
	// Öğrenci bilgileri ile ilgili alanlar.
	public String ogrenciKod;
	public String ogrenciAd;
	public String ogrenciSoyad;
	public String ogrenciBolum;
	public String ogrenciDonem;
	public String ders;
	
	// Belirtilen öğrenci kodunu ve ders kodunu CSV belgesinde arar. Kayıt var ise false, yok ise true döndürür.
	public boolean ogrenciVarMi(String arananOgrenciKodu, String arananDersKodu)
	{
	    String csvDosyaYolu = "ogrenciler.csv";
	    String line = "";
	    String cvsSplitBy = ",";
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvDosyaYolu)))
	    {
	        while ((line = br.readLine()) != null)
	        {
	            String[] ders = line.split(cvsSplitBy);
	            
	            if (ders[0].equals(arananOgrenciKodu) && ders[5].equals(arananDersKodu))
	            {
	                return false;
	            }
	        }
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    
	    return true;
	}
	
	// Öğrenci bilgilerini CSV belgesine kayıt eder.
	public boolean kaydet(ogrenciler nesne)
	{
		if (ogrenciVarMi(nesne.ogrenciKod, nesne.ders))
	    {
			String csvDosyaYolu = "ogrenciler.csv";
		    
		    try
		    {
		        FileWriter fileWriter = new FileWriter(csvDosyaYolu, true);
		        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		        
		        bufferedWriter.write(nesne.ogrenciKod + "," + nesne.ogrenciAd + "," + nesne.ogrenciSoyad + "," + nesne.ogrenciBolum + "," + nesne.ogrenciDonem + "," + nesne.ders);
		        bufferedWriter.newLine();
		        
		        bufferedWriter.close();
		        fileWriter.close();
		        
		        return true;
		    }
		    catch (IOException e)
		    {
		        e.printStackTrace();
		    }
	    }
		
		return false;
	}
	
	// Derslerin bulunduğu CSV dosyasını tarar. Ders adlarını belirtilen ComboBox nesnesine ekler.
	public static void doldur(JComboBox<String> nesne)
	{
		String csvDosyaYolu = "dersler.csv";
	    String satir = "";
	    String csvAyirici = ",";
	    
	    try
	    {
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvDosyaYolu));
	        
	        while ((satir = bufferedReader.readLine()) != null)
	        {
	            String[] dersler = satir.split(csvAyirici);
	            
	            if(dersler.length > 1)
	            {
	                nesne.addItem(dersler[1]);
	            }
	            else
	            {
	                nesne.addItem("");
	            }
	        }
	        
	        bufferedReader.close();
	    }
	    catch (FileNotFoundException e)
	    {
	        e.printStackTrace();
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
}
