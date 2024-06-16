package com.sears.serviceimpl;

import java.util.Objects;

import com.sears.dao.LikesDao;
import com.sears.entity.Likes;
import com.sears.service.LikesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService{

	@Autowired
	public LikesDao likesRepo;

	@Override
	public Likes likeDislike(Likes like) {
		Likes likes=likesRepo.findByLikedByAndPosts(like.getLikedBy().getId(),like.getPosts().getPostId());
		if(Objects.isNull(likes)) {
			likesRepo.save(like);
		}
		else {
			likesRepo.delete(likes);
		}
		return likes;
	}
	

}
