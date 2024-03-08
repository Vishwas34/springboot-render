package com.jwt;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class Service {
	 private ArrayList<Emp> al = new ArrayList<>();

	    public Service() {
	        al.add(new Emp(1, "ajay", 25000));
	        al.add(new Emp(2, "jay", 35000));
	        al.add(new Emp(3, "jaya", 45000));
	        al.add(new Emp(4, "yash", 15000));
	        al.add(new Emp(5, "Ram", 50000));
	    }

	    public List<Emp> showAll() {
	        return al;
	    }

	    public Optional<Emp> getEmp(int id) {
	        return al.stream()
	                .filter(emp -> emp.getId() == id)
	                .findFirst()
	                .or(() -> Optional.of(new Emp(-1, "ID not exists", 0))); // Custom message when ID doesn't exist
	    }

	    public Optional<Emp> delEmp(int id) {
	        for (int i = 0; i < al.size(); i++) {
	            if (al.get(i).getId() == id) {
	                return Optional.of(al.remove(i)); // Return Optional containing the deleted employee
	            }
	        }
	        return Optional.empty(); // Return empty Optional if employee with given ID is not found
	    }

	    public Optional<Emp> updEmp(int id, String newName, int newSalary) {
	        for (Emp emp : al) {
	            if (emp.getId() == id) {
	                emp.setName(newName);
	                emp.setSal(newSalary);
	                return Optional.of(emp); // Return Optional containing the updated employee
	            }
	        }
	        return Optional.empty(); // Return empty Optional if employee with given ID is not found
	    }

	    public void addEmp(Emp newEmployee) {
	        al.add(newEmployee);
	    }
}

