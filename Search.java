package school_college;

public class Search {
	public boolean search(Student s, String a){
		if (s.name.equals(a) || s.mob.equals(a)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean search(Student s, int a){
		if (s.age==a || s.class_study==a) {
			return true;
		} else {
			return false;
		}
	}
}
