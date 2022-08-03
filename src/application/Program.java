package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		List<Product> list = new ArrayList<>();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/MM/yyyy");

		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.println("Common, used or imported (c/u/i)?");
			char c = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
				if (c == 'u') {				
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				String stringDate = sc.next();
				LocalDate date = LocalDate.parse(stringDate, fmt);
				
				Product product = new UsedProduct(name, price, date);
				list.add(product);
			} 
				else if (c == 'i') {
				System.out.print("Customs Fee: ");
				double fee = sc.nextDouble();

				Product product = new ImportedProduct(name, price, fee);
				list.add(product);
			} 
				else {
				Product product = new Product(name, price);
				list.add(product);
			}

		} //for ends here
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for (Product p : list) {
			System.out.println(p.priceTag());
		}

		
		sc.close();
	}
	
}
