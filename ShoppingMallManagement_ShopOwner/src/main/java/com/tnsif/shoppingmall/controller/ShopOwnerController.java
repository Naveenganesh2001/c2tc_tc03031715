package com.tnsif.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.shoppingmall.entity.ShopOwner;
import com.tnsif.shoppingmall.repository.ShopOwnerRepository;

@RestController
@RequestMapping("/shopOwners")
@CrossOrigin
//(origins = "http://localhost:4200")
public class ShopOwnerController {
	
	@Autowired
	ShopOwnerRepository shopOwnerRepo;


	@GetMapping("/{id}")
	public ShopOwner getShopOwnerById(@PathVariable Long id) {
		return shopOwnerRepo.findById(id).get();
	}

	@GetMapping
	public List<ShopOwner> getAllShopOwners() {
		return shopOwnerRepo.findAll();
	}

	@PostMapping
	public ShopOwner createShopOwner(@RequestBody ShopOwner ShopOwner) {
		return shopOwnerRepo.save(ShopOwner);
	}

	@PutMapping("/{id}")
	public void updateShopOwner(@PathVariable Long id, @RequestBody ShopOwner ShopOwner) {

		ShopOwner.setId(id);
		shopOwnerRepo.save(ShopOwner);

	}

	@DeleteMapping("/{id}")
	public void deleteShopOwnerById(@PathVariable Long id) {
		shopOwnerRepo.deleteById(id);
	}
	
	

}
