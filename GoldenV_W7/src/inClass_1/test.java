package inClass_1;

import java.util.Scanner;

// node class
class Node {
	String fname;
	String lname;
	String phone;
	String mail;

	Node link;

	/* Constructor */
	public Node() {
		link = null;
		phone = null;
		mail = null;
		fname = null;
		lname = null;
	}

	/* Constructor */
	public Node(String fname, String lname, String phone, String mail, Node n) {
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.mail = mail;
		link = n;
	}

	/* Function to set link to next Node */
	public void setLink(Node n) {
		link = n;
	}

	/* Function to set data to current Node */
	public void setData(String fname, String lname, String phone, String mail) {
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.mail = mail;
	}

	/* Function to get link to next node */
	public Node getLink() {
		return link;
	}

	/* Function to get data from current Node */
	public String getMail() {
		return mail;
	}

	// return first name
	public String getfname() {
		return fname;
	}

	// return last name
	public String getlname() {
		return lname;
	}

	// return phone no
	public String getPhone() {
		return phone;
	}

	// set phone no
	public void setPhone(String p) {
		this.phone = p;
	}
}

/* Class linkedList */
class linkedList {
	Node start;
	Node end;
	public int size;

	/* Constructor */
	public linkedList() {
		start = null;
		end = null;
		size = 0;
	}

	// Function to insert an element
	public void insert(String fname, String lname, String phone, String mail) {
		Node nptr = new Node(fname, lname, phone, mail, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
	}

	// print all data
	void print() {
		Node ptr = start;

		if (ptr == null)
			System.out.print("\nNo element in the list\n");
		while (ptr != null) {
			System.out.print(
					ptr.getfname() + " " + ptr.getlname() + " " + ptr.getPhone() + " " + ptr.getMail() + " " + "\n");
			ptr = ptr.link;
		}
	}

	// search by mail id
	void searchByMail(String m, Scanner sc) {
		Node ptr = start;
		if (ptr == null)
			System.out.print("\nNo element in the list\n");
		while (ptr != null) {
			if (ptr.getMail().equals(m)) {
				System.out.print(ptr.getfname() + " " + ptr.getlname() + " " + ptr.getPhone() + " " + ptr.getMail()
						+ " " + "\n");
				System.out.print("Enter phone no to change: ");
				String p = sc.next();
				ptr.setPhone(p);
				System.out.println("Phone no changed");
				return;
			}
			ptr = ptr.link;
		}
		System.out.print("Mail id not found\n");
	}
}

// main function
public class test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String fname, lname, mail, phone;

		linkedList ll = new linkedList();

		// get details from user
		for (int i = 0; i < 3; i++) {
			System.out.print("Enter first name: ");
			fname = sc.next();
			System.out.print("Enter last name: ");
			lname = sc.next();
			System.out.print("Enter phone no: ");
			phone = sc.next();
			System.out.print("Enter mail id: ");
			mail = sc.next();

			// add to list
			ll.insert(fname, lname, phone, mail);
		}
		// get mail id to search
		System.out.print("Enter mail id to search: ");
		mail = sc.next();

		// search
		ll.searchByMail(mail, sc);
		// print all data
		ll.print();

	}
}
