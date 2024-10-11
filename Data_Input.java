package school_college;
import java.util.Scanner;
import java.util.ArrayList;

public class Data_Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		School sch = new School();
		Search sea = new Search();
		String a,b;
		b = "y";
		System.out.println("Enter School name: ");
		a = sc.nextLine();
		sch.set_name(a);
		sch.total_class();
		System.out.println("Enter total students in a class: ");
		int m = sc.nextInt();
		ArrayList<Student> st = new ArrayList<>();
		int i = 0;
		String op = "1.Enter Data\n2.Display Data\n3.Search\n4.Update\n5.Exit";
		while (true) {
			System.out.println("Choose any one: ");
			System.out.println(op);
			int k = sc.nextInt();
			if (k==1) {
				do {
					if (i==m) {
						System.out.println("Already entered total students data...\nWant to add more students? (y/n): ");
						b = sc.next();
						if (b.equals("y") || b.equals("Y")) {
							m++;
						} else {
							break;
						}
					}
					st.add(new Student());
					i++;
					System.out.println("Enter student data (y or n): ");
					b = sc.next();
				} while (b.equals("y") || b.equals("Y"));
			} else if (k==2) {
				for (Student student:st) {
					student.display();
				}
			} else if (k==3) {
				b = "1.Search by Name\n2.Search by Mobile Number\n3.Search by Age\n4.Search by class of study\n5.Back";
				System.out.println(b);
				int l = sc.nextInt();
				String p = "";
				int q = 0;
				boolean found = false;
				if (l==1) {
					System.out.println("Enter Name to be searched: ");
					p = sc.next();	
				} else if (l==2) {
					System.out.println("Enter Mobile Number to be searched: ");
					p = sc.next();
				} else if (l==3) {
					System.out.println("Enter Age to be searched: ");
					q = sc.nextInt();
				} else if (l==4) {
					System.out.println("Enter class of study: ");
					q = sc.nextInt();
				} else {
					continue;
				}
				for (Student student:st) {
					if (l==1 || l==2) {
						if (sea.search(student, p)) {
							student.display();
							found = true;
						}
					} else if (l==3 || l==4) {
						if (sea.search(student, q)) {
							student.display();
							found = true;
						}
					}
				}
				if (!found) {
					System.out.println("No Such Element Found.\nTry Another...");
				}
			} else if (k==4) {
				System.out.println("Update by Serial number...");
				System.out.println("Search needed first to update if not then enter another number:");
				b = "1.Search by Name\n2.Search by Mobile Number\n3.Search by Age\n4.Search by class of study\n5.Back";
				System.out.println(b);
				int l = sc.nextInt();
				String p = "";
				int q = 0;
				boolean found = false;
				if (l==1) {
					System.out.println("Enter Name to be searched: ");
					p = sc.next();	
				} else if (l==2) {
					System.out.println("Enter Mobile Number to be searched: ");
					p = sc.next();
				} else if (l==3) {
					System.out.println("Enter Age to be searched: ");
					q = sc.nextInt();
				} else if (l==4) {
					System.out.println("Enter class of study: ");
					q = sc.nextInt();
				}
				for (Student student:st) {
					if (l==1 || l==2) {
						if (sea.search(student, p)) {
							student.display();
							found = true;
						}
					} else if (l==3 || l==4) {
						if (sea.search(student, q)) {
							student.display();
							found = true;
						}
					}
				}
				if (!found) {
					System.out.println("No Such Element Found.\nTry Another...");
				} else {
					System.out.println("Enter Serial Number: ");
					int ser = sc.nextInt();
					try {
					Student sd = st.get(ser-1);
					sd.display();
					System.out.println("Enter what to update: ");
					System.out.println("1.Name\n2.Age\n3.Class\n4.Mobile Number\n5.Back");
					ser = sc.nextInt();
					if (ser==1) {
						sd.set_name();
					} else if (ser==2) {
						sd.set_age();
					} else if (ser==3) {
						sd.set_class();
					} else if (ser==4) {
						sd.set_mobile();
					} else {
						break;
					}
					sd.display();
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Invalid Serial Number...");
					}
				}
			} else {
				break;
			}
		}
		sc.close();
	}
}
