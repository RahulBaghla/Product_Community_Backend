package com.sears.controller;

import com.sears.entity.Likes;
import com.sears.service.LikesService;
import com.sears.utils.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/likes")
public class LikesController {

	@Autowired
	public LikesService likesService;

	@PostMapping
	public ResponseEntity<Object> likeDislike(@RequestBody Likes like) {
		likesService.likeDislike(like);
		return ResponseHandler.generateResponse("Response updated", HttpStatus.ACCEPTED);
	}

}
