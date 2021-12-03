package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservations;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = scan.nextInt();
			System.out.print("Check-In date (DD/MM/YYYY): ");
			Date dataCheckIn = (Date) sdf.parse(scan.next());
			System.out.print("Check-Out date (DD/MM/YYYY): ");
			Date dataCheckOut = (Date) sdf.parse(scan.next());
			
			Reservations reservations = new Reservations(roomNumber, dataCheckIn, dataCheckOut);
			System.out.println("Reservation: " + reservations);
			
			System.out.println();
			System.out.println("Enter data to Update the Reservation");
			System.out.print("Check-In date (DD/MM/YYYY): ");
			dataCheckIn = (Date) sdf.parse(scan.next());
			System.out.print("Check-Out date (DD/MM/YYYY): ");
			dataCheckOut = (Date) sdf.parse(scan.next());
			
			reservations.updateDates(dataCheckIn, dataCheckOut);
			System.out.println("Reservation: " + reservations);		
		}
		catch (ParseException e) {
			System.out.println("Invalid Date Format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		scan.close();
	}

}
