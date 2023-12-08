import java.io.*;

public class dersler
{
	// Ders bilgileri ile ilgili alanlar.
	public String dersKod;
	public String dersAd;
	public String dersDonem;
	public String dersKredi;
	public String dersKota;
	
	// Belirtilen ders kodunu CSV belgesinde arar. Kayıt var ise false, yok ise true döndürür.
	public boolean dersVarMi(String arananDersKodu)
	{
	    String csvDosyaYolu = "dersler.csv";
	    String line = "";
	    String cvsSplitBy = ",";
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvDosyaYolu)))
	    {
	        while ((line = br.readLine()) != null)
	        {
	            String[] ders = line.split(cvsSplitBy);
	            
	            if (ders[0].equals(arananDersKodu))
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

	// Ders bilgilerini CSV belgesine kayıt eder.
	public boolean kaydet(dersler nesne)
	{
	    if (dersVarMi(nesne.dersKod))
	    {
	    	String csvDosyaYolu = "dersler.csv";
	    	
		    try
		    {
		        FileWriter fileWriter = new FileWriter(csvDosyaYolu, true);
		        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		        
		        bufferedWriter.write(nesne.dersKod + "," + nesne.dersAd + "," + nesne.dersDonem + "," + nesne.dersKredi + "," + nesne.dersKota);
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
}
