package iterator;

import java.util.Vector;

import domain.Event;

public class ExtendedIteratorClass implements ExtendedIterator<Event>{
	Vector<Event> events;
	int p = 0;

	public ExtendedIteratorClass(Vector<Event> events2) {
		this.events = events2;
		//this.p = events2.size()-1;
	}

	@Override
	public Event next() {
		Event ev = events.get(p);
		p = p+1;
		return ev;
	}
	
	@Override
	public boolean hasNext() {
		return p<events.size();
	}

	@Override
	public Event previous() {
		Event ev = events.get(p);
		p = p-1;
		return ev;
	}

	@Override
	public boolean hasPrevious() {
		return p>0;
	}

	@Override
	public void goFirst() {
		p = 0;
	}

	@Override
	public void goLast() {
		p = events.size()-1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return events.isEmpty();
	}

}
