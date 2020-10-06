package javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddContactArray {
	// private HashMap<String,AddressContact> add;
	private HashMap<String, AddressContact> arr;
	private HashMap<String, HashMap<String, AddressContact>> addbook = new HashMap<String, HashMap<String, AddressContact>>();

	public void addAddressBook(String name) {
		HashMap<String, AddressContact> obj = new HashMap<String, AddressContact>();
		addbook.put(name, obj);
	}

	public void selectAddBook(String name) {
		this.arr = addbook.get(name);
	}

	public boolean containsKey(String firstName) {
		if (this.arr.containsKey(firstName))
			return true;
		else
			return false;
	}

	public void addContact(String firstName, String lastName, String city, int zip, long phoneNo, String email) {
		AddressContact add = new AddressContact(firstName, lastName, city, zip, phoneNo, email);
		arr.put(firstName, add);
	}

	public void editContact(String firstName, String lastName, String city, int zip, long phoneNo, String email) {
		AddressContact add = new AddressContact(firstName, lastName, city, zip, phoneNo, email);
		arr.replace(firstName, add);
		System.out.println("Record Changed");

	}

	public void deleteContact(String firstName) {
		arr.remove(firstName);
		System.out.println("Contact deleted");
	}

	public void searchCity(String cityname) {
		addbook.entrySet().stream()
				.forEach(y -> y.getValue().entrySet().stream().filter(m -> ((m.getValue()).city).equals(cityname))
						.map(Map.Entry::getValue).map(a -> a.firstName).forEach(System.out::println));

	}

	public void countByCity(String cityname) {
		List<Entry<String, AddressContact>> myList = new ArrayList<Entry<String, AddressContact>>();
		addbook.entrySet().stream().forEach(y -> y.getValue().entrySet().stream()
				.filter(m -> ((m.getValue()).city).equals(cityname)).forEach(e -> myList.add(e)));
		System.out.println(myList.size());

	}

	public void sortByZip() {
		List<AddressContact> myList = new ArrayList<AddressContact>();
		addbook.entrySet().stream().forEach(y -> y.getValue().entrySet().stream().sorted((s1, s2) -> (s1.getValue().zip)>(s2.getValue().zip) ? 1 : 0).forEach(e -> myList.add(e.getValue())));
		Iterator<AddressContact> i = myList.iterator();
		while(i.hasNext()) {
	         System.out.println("First Name: "+i.next().firstName+"\nLast Name: "+i.next().lastName+"\nLast Name: "+i.next().city+"\nLast Name: "+i.next().email+"\nLast Name: "+i.next().phoneNo+"\nLast Name: "+i.next().zip);
	      }

	}
	public void sortByCity() {
		List<AddressContact> myList = new ArrayList<AddressContact>();
		addbook.entrySet().stream().forEach(y -> y.getValue().entrySet().stream().sorted((s1, s2) -> s1.getValue().firstName.compareTo(s2.getValue().firstName)).forEach(e -> myList.add(e.getValue())));
		Iterator<AddressContact> i = myList.iterator();
		while(i.hasNext()) {ssss
	         System.out.println("First Name: "+i.next().firstName+"\nLast Name: "+i.next().lastName+"\nLast Name: "+i.next().city+"\nLast Name: "+i.next().email+"\nLast Name: "+i.next().phoneNo+"\nLast Name: "+i.next().zip);
	      }

	}
	public void sortName() {
		List<AddressContact> myList = new ArrayList<AddressContact>();
		addbook.entrySet().stream().forEach(y -> y.getValue().entrySet().stream().sorted((s1, s2) -> s1.getValue().city.compareTo(s2.getValue().city)).forEach(e -> myList.add(e.getValue())));
		Iterator<AddressContact> i = myList.iterator();
		while(i.hasNext()) {
	         System.out.println("First Name: "+i.next().firstName+"\nLast Name: "+i.next().lastName+"\nLast Name: "+i.next().city+"\nLast Name: "+i.next().email+"\nLast Name: "+i.next().phoneNo+"\nLast Name: "+i.next().zip);
	      }

	}
}



