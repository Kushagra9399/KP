package school_college;

import java.util.Scanner;

public class Student_mysql {
	static int count = 0;
	public int serial_num;
	public String name;
	public int roll_no;
	public int year_study;
	public String mob;
	Scanner sc = new Scanner(System.in);
	Student_mysql(){
		this.serial_num = count+1;
		set_name();
		set_roll_no();
		set_year();
		set_mobile();
		count++;
	}
	public void set_name() {
		System.out.println("Enter name of student: ");
		this.name = sc.nextLine();
	}
	public String get_name() {
		return this.name;
	}
	public void set_roll_no() {
		System.out.println("Enter age of student: ");
		this.roll_no = sc.nextInt();
	}
	public void display() {
		System.out.println("-------------------------");
		System.out.println(this.serial_num + ".");
		System.out.println("Name: " + this.name);
		System.out.println("Roll No.: " + this.roll_no);
		System.out.println("Year: " + this.year_study);
		System.out.println("Mobile Number: " + this.mob);
		System.out.println("-------------------------");
	}
	public void set_year() {
		System.out.println("Enter year of study: ");
		this.year_study = sc.nextInt();
	}
	public void set_mobile() {
		System.out.println("Enter Mobile number: ");
		this.mob = sc.next();
	}
	public int total_student() {
		return count;
	}
	public int get_roll_no() {
		return this.roll_no;
	}
	public String get_mob() {
		return this.mob;
	}
	public int get_year() {
		return this.year_study;
	}
}
