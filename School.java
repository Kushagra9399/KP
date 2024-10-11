package school_college;
import java.util.Scanner;

public class School implements S_C_ {
	Scanner sc = new Scanner(System.in);
	public String name;
	public int classes;
	public void get_name() {
		System.out.println("Name of School: " + this.name);
	}
	public void set_name(String d) {
		this.name = d;
	}
	public void total_class() {
		System.out.println("Enter number of classes to be present: ");
		this.classes = sc.nextInt();
	}
}
