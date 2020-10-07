import java.io.FileNotFoundException; 
import java.util.ArrayList; 
import java.util.*;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.*;


public class Compare { 
 
    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException
	{
	 	String line = ""; 
		String splitBy = ",";  
		String[] register = null;

		try   
			{
		 HashMap<String, String> map1 = new HashMap<>(); 
		 HashMap<String, String> map2 = new HashMap<>(); 


			FileWriter writer=new FileWriter("/home/credentek/Result.csv");


			BufferedReader br = new BufferedReader(new FileReader("/home/credentek/convertcsv.csv"));   
			while ((line = br.readLine()) != null)   //returns a Boolean value  
				{  
				//System.out.println("Line: " +line);
				register = line.split(splitBy);    // use comma as separator  
				//System.out.println("Roll=" + register[0]);				
				//System.out.println(roll);	

					map1.put(register[0], register[1]+","+register[2]+","+register[3]+","+register[4]);
				}  
				//System.out.println("Size of Map : "+map1);



			br = new BufferedReader(new FileReader("/home/credentek/convertcsv1.csv"));   
			while ((line = br.readLine()) != null)   //returns a Boolean value  
				{  
				//System.out.println("Line: " +line);
				String[] payment = line.split(splitBy);    // use comma as separator  
				//System.out.println("Roll=" + payment[0] + ", Name=" + payment[1]); 
				map2.put(payment[0], payment[1]); 
				}
				
							


				for (String y : map1.keySet())
        			{
				
           			if (!map2.containsKey(y)) {
               			//System.out.println("Roll.no:" +y);
				String val=map1.get(y);
     				System.out.println("The Value mapped to Key is:" +y+ " "+ val);
				writer.append(y);
				writer.append(val);
				writer.append("\n");
     				System.out.println("Successful");
				writer.flush();
           			}
        			} 
				  			            
           			writer.close();
			}   
			catch (IOException e)   
			{  
			e.printStackTrace();  
			}catch(ArrayIndexOutOfBoundsException e)  
                 	 {  
                  	 System.out.println("ArrayIndexOutOfBounds Exception occurs");
			 e.printStackTrace();  
                  	} catch(NullPointerException e)
			{
			e.printStackTrace();
			}
			finally
			{
			
			}
 

	}
}
