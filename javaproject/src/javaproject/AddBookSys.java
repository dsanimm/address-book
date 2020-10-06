package javaproject;

import java.util.Scanner;
import java.util.stream.Stream;

public class AddBookSys {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Scanner sc = new Scanner(System.in);

		String firstName, lastName, city, email, name;
		int zip, choice = 1;
		long phoneNo;
		AddContactArray add = new AddContactArray();

		while (choice != 5) {
			System.out.println(
					"Enter your choice:\n1. Create new Address Book\n2. Select AddressBook\n3. Search person by city\n4. Count by City\n5. List sorted by names\n6. List sorted by city\n7. List sorted by zip\n8. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name of AddressBook:");
				name = sc.next();
				add.addAddressBook(name);
				add.selectAddBook(name);
				break;
			case 2:
				System.out.println("Enter Name of AddressBook:");
				name = sc.next();
				add.selectAddBook(name);
				break;
			case 3:
				System.out.println("Enter City Name:");
				city = sc.next();
				add.searchCity(city);
				break;
			case 8:
				choice = 4;
				break;
			case 4:
				System.out.println("Enter City Name:");
				city = sc.next();
				add.countByCity(city);
				choice = 4;
				break;
			case 6:
				System.out.println("List of names sorted:");
				add.sortByCity();
				choice = 4;
				break;
			case 7:
				System.out.println("List of names sorted:");
				add.sortByZip();
				choice = 4;
				break;
			case 5:
				System.out.println("List of names sorted:");
				add.sortName();
				choice=4;
			default:
				System.out.println("Wrong choice");
			}
			while (choice != 4) {

				System.out.println("Enter your choice:\n1. Enter contact\n2. Edit Contact\n3. Delete Contact\n4. Exit");

				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter First Name:");
					firstName = sc.next();
					System.out.println("Enter Last Name:");
					lastName = sc.next();
					System.out.println("Enter city:");
					city = sc.next();
					System.out.println("Enter zip:");
					zip = sc.nextInt();
					System.out.println("Enter phone No.:");
					phoneNo = sc.nextLong();
					System.out.println("Enter email address:");
					email = sc.next();
					add.addContact(firstName, lastName, city, zip, phoneNo, email);
					System.out.println("Record Added");
					break;
				case 2:
					System.out.println("Enter First Name:");
					firstName = sc.next();

					if (add.containsKey(firstName)) {
						System.out.println("Enter Last Name:");
						lastName = sc.next();
						System.out.println("Enter city:");
						city = sc.next();
						System.out.println("Enter zip:");
						zip = sc.nextInt();
						System.out.println("Enter phone No.:");
						phoneNo = sc.nextInt();
						System.out.println("Enter email address:");
						email = sc.next();
						add.editContact(firstName, lastName, city, zip, phoneNo, email);
					} else
						System.out.println("Record Not Found");

					break;
				case 3:
					System.out.println("Enter First Name:");
					firstName = sc.next();

					if (add.containsKey(firstName)) {
						add.deleteContact(firstName);
					} else
						System.out.println("Record not found");
					break;
				case 4:
					break;
				default:
					System.out.println("Wrong choice");

				}
			}
		}
	}
}
