package school_college;
import java.util.Scanner;

public class Student {
	static int count = 0;
	public int serial_num;
	public String name;
	public int age;
	public int class_study;
	public String mob;
	Scanner sc = new Scanner(System.in);
	Student(){
		this.serial_num = count+1;
		set_name();
		set_age();
		set_class();
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
	public void set_age() {
		System.out.println("Enter age of student: ");
		this.age = sc.nextInt();
	}
	public void display() {
		System.out.println("-------------------------");
		System.out.println(this.serial_num + ".");
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Class: " + this.class_study);
		System.out.println("Mobile Number: " + this.mob);
		System.out.println("-------------------------");
	}
	public void set_class() {
		System.out.println("Enter class of study: ");
		this.class_study = sc.nextInt();
	}
	public void set_mobile() {
		System.out.println("Enter Mobile number: ");
		this.mob = sc.next();
	}
	public int total_student() {
		return count;
	}
	public int get_age() {
		return this.age;
	}
	public String get_mob() {
		return this.mob;
	}
	public int get_class() {
		return this.class_study;
	}
}
