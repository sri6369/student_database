package com.example.sriDb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sriDb.Entity.sData;
import com.example.sriDb.Services.RpService;

@RequestMapping("/home")
@RestController("/rs")
public class RpController {
@Autowired
RpService  rs;


@PostMapping("/post")
public sData method1(@RequestBody sData st) {
	return this.rs.method2(st);
			}
@GetMapping("/get/{id}")
public sData handleGetById(@PathVariable("id") int id) {
    return this.rs.getById(id);
}

@DeleteMapping("/del/{id}")
public String method4(@PathVariable(value="id") int id){
	return this.rs.deleteById(id);
}

@PutMapping("/up/{id}")
public sData method5(@RequestBody sData st,@PathVariable(value="id") int id) {
	return this.rs.updateData(st,id);
}
}
