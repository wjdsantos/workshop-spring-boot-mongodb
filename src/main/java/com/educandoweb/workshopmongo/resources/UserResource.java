package com.educandoweb.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.dto.UserDTO;
import com.educandoweb.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
//		User maria = new User("1", "Maria Brown", "maria@gmail.com");
//		User alex = new User("2", "Alex Green", "alex@gmail.com");
//		list.addAll(Arrays.asList(maria, alex));
		List<User> list = service.findAll(); //Agora buscando do banco MongoDB
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());  //Refatorando o métdo findAll - aula347
//		return ResponseEntity.ok().body(list);
		return ResponseEntity.ok().body(listDto);
		
	}
}
