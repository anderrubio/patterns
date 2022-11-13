package iterator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.BLFacade;
import businesslogic.BusinessLogicFactory;
import domain.Event;

public class IteratorMain {
	public static void main(String[] args) {
		boolean isLocal=true;
		//Facade objektua lortu lehendabiziko ariketa erabiliz 
		BLFacade facadeInterface = (new BusinessLogicFactory()).createFacadeInterface(isLocal, null);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		
		try {
			date = sdf.parse("09/12/2022");
			ExtendedIterator<Event> i = facadeInterface.getEvents(date); 
			Event ev;
			System.out.println("________");
			System.out.println("Atzetik aurrera");
			i.goLast();
			while (i.hasPrevious()){
				ev=i.previous();
				System.out.println(ev.toString());
			}
			System.out.println();
			System.out.println("________");
			System.out.println("Aurretik atzera");
			i.goFirst();
			while (i.hasNext()){
				ev=i.next();
				System.out.println(ev.toString()); 
			}
		}catch (ParseException e1){
			System.out.println("Problems");
		}

	}
}

