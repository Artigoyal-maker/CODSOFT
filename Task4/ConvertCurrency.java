package Currency_Converter;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ConvertCurrency {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Welcome to Currency Converter!");
			System.out.print("Enter base currency (USD, INR, EUR): ");
			String base = s.next().toUpperCase();
			System.out.print("Enter target currency (USD, INR, EUR): ");
			String target = s.next().toUpperCase();
			
			System.out.print("Enter Amount: ");
			double amount = s.nextDouble();
			
			String api = "d3f17c8cc5a90d2160750af1";
			String urlStr = "https://v6.exchangerate-api.com/v6/" + api + "/pair/" + base + "/" + target;
	        URL u = new URL(urlStr);
			BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
			StringBuilder response = new StringBuilder();
	           String line;

	           while ((line = br.readLine()) != null) {
	                response.append(line);
	           }
	           br.close();
               String resp = response.toString();
               
	            if(resp.contains("\"result\":\"success\"")) {
	            	String rates = resp.split("\"conversion_rate\":")[1].split("[,}]")[0];
	                double rate = Double.parseDouble(rates);

	                double res = amount * rate;

	                String symbol = "";
	                if(target.equals("USD"))
	                    symbol = "$";
	                else if(target.equals("INR"))
	                    symbol = "₹";
	                else if(target.equals("EUR"))
	                    symbol = "€";

	                System.out.println("Converted Amount: " + symbol + res + " " + target);

	            } else {
	                System.out.println("Invalid currency code or API issue.");
	            }
	     
		}catch(Exception e) {
			System.out.println("Error fetching data. Check API or internet.");
			 e.printStackTrace();
		}
		s.close();
	}
}
