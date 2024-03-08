package com.jwt;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
	
   @Autowired
    Service service;

    @RequestMapping("/emps")
    @ResponseBody
    public List<Emp> showAll() {
        return this.service.showAll();
    }

    @RequestMapping("/emps/{id}")
    @ResponseBody
    public Optional<Emp> showById(@PathVariable int id) {
        return this.service.getEmp(id);
    }

    @RequestMapping(value = "/emps/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Optional<Emp> deleteById(@PathVariable int id) {
        return this.service.delEmp(id);
    }

    @RequestMapping(value = "/emps/update/{id}/{newName}/{newSalary}", method = RequestMethod.PUT)
    @ResponseBody
    public Optional<Emp> updateEmployee(
            @PathVariable int id,
            @PathVariable String newName,
            @PathVariable int newSalary) {
        return this.service.updEmp(id, newName, newSalary);
    }

    @RequestMapping(value = "/emps/add", method = RequestMethod.POST)
    @ResponseBody
    public void addEmployee(@RequestBody Emp newEmployee) {
        this.service.addEmp(newEmployee);
    }
}