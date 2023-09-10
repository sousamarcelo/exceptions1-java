/*
 * ATENÇÃO: Terceira solução, boa.
 * 
 * Utilizando try/catch, o codigo principal sem if/else, se comportando como se tudo desse certo.
 */

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  { 
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdfIn.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdfIn.parse(sc.next());
			
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);	
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdfIn.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdfIn.parse(sc.next());
			
			 reservation.updateDates(checkIn, checkOut);		
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Erro in reservatin: " + e.getMessage());			
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
				
		sc.close();
	}
}
