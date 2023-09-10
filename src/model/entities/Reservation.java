package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy"); // objeto criado estatico para que não seja instanciado um novo objeto sdf para cada instancia de reservation
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new  DomainException("check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		// calculando a diferenteça em mile segundo na variavel "diff" e depois converntendo essa variavel em dia utilizando a classe enumerada "TimeUnit"
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws ParseException, DomainException { // esse metodo lancara uma exceção para que seja tratada por que chamar esse metodo
		
		Date now = sdfOut.parse("06/06/2018"); //chumbando data para ficar igual ao do exercicio, mas no exercicio ele utiliza new Date() pra pegar a data atual.
		
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates.") ;
		}
		
		if (!checkOut.after(checkIn)) {
			throw new  DomainException("check-out date must be after check-in date");
		}		
		this.checkin = checkIn;
		this.checkout = checkOut;		
	}	
		
	@Override
	public String toString() {
		return "Room "
				+ getRoomNumber()
				+ ", check-in: "
				+ sdfOut.format(checkin)
				+ ", check-out: "
				+ sdfOut.format(checkout)
				+ ", "
				+ duration()
				+ " nights";				
	}

}
