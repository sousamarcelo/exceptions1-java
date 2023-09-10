/*
 * ATENÇÃO: primera solução, muito ruim
 * 
 * Um dos grande problema dessa solução é a delegação, a logica da reserva deveria está na Reserva e não no programa principal
 */

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { // o parametro "throws" indica que essa exceção não será tratada "ParseExceptio" nesse metodo, ou seja tem exceções não tratadas e será propagada para um possivel metodo que chame esse metodo
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");
					
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdfIn.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdfIn.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);	
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdfIn.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdfIn.parse(sc.next());
			
			Date now = sdfIn.parse("06/06/2018"); //chumbando data para ficar igual ao do exercicio, mas no exercicio ele utiliza new Date() pra pegar a data atual.
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}			
			
		}
		
		
		
		
		sc.close();
	}

}
