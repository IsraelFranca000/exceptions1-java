package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservations;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = scan.nextInt();
		System.out.print("Check-In date (DD/MM/YYYY): ");
		Date dataCheckIn = (Date) sdf.parse(scan.next());
		System.out.print("Check-Out date (DD/MM/YYYY): ");
		Date dataCheckOut = (Date) sdf.parse(scan.next());
		
		if(!dataCheckOut.after(dataCheckIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservations reservations = new Reservations(roomNumber, dataCheckIn, dataCheckOut);
			System.out.println("Reservation: " + reservations);
			
			System.out.println();
			System.out.println("Enter data to Update the Reservation");
			System.out.print("Check-In date (DD/MM/YYYY): ");
			dataCheckIn = (Date) sdf.parse(scan.next());
			System.out.print("Check-Out date (DD/MM/YYYY): ");
			dataCheckOut = (Date) sdf.parse(scan.next());
			
			String error = reservations.updateDates(dataCheckIn, dataCheckOut);
			
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservations);
			}
			
		}
		
		
		scan.close();
	}

}
