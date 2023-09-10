package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy"); // objeto criado estatico para que não seja instanciado um novo objeto sdf para cada instancia de reservation
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
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
	
	public void updateDates(Date checkIn, Date checkOut) {
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
