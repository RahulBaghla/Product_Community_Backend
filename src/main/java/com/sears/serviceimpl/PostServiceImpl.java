package com.sears.serviceimpl;

import java.util.List;
import java.util.Objects;

import com.sears.controller.PostController;
import com.sears.dao.PostDao;
import com.sears.entity.Comment;
import com.sears.entity.Post;
import com.sears.entity.SearchFilter;
import com.sears.service.PostService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class PostServiceImpl implements PostService {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(PostController.class);

	@Autowired
	PostDao postRepo;

	@Override
	public Post createPost(Post post) {
		return postRepo.save(post);
	}

	@Override
	public List<Post> getPosts(SearchFilter searchFilter) {
		if (!Objects.isNull(searchFilter)) {
			logger.info(searchFilter.toString());
			if (searchFilter.getEmail() == null)
				searchFilter.setEmail("");
			if (searchFilter.getSearch() == null)
				searchFilter.setSearch("");
			return postRepo.findByFilter(searchFilter.getSearch(), searchFilter.getDate(),searchFilter.getEmail(), searchFilter.getProductId());
			}
		return postRepo.findAll();
	}

	@Override
	public int deletePost(long postId) {
		try {
			postRepo.deleteById(postId);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Post getPost(long id) {
		return postRepo.findById(id).orElseThrow();
	}

	@Override
	public long getNoOfPosts() {
		return postRepo.findAll().size();
	}

	@Override
	public int updateAnswer(long postId, Comment comment) {

		Post post = postRepo.findById(postId).orElseThrow();
		if (!Objects.isNull(post)) {
			post.setAnswer(comment);
			postRepo.save(post);
			return 1;
		}
		return 0;
	}

	@Override
	public int getNoOfSolvedPosts() {
		return postRepo.findByAnswer().size();
	}

}
