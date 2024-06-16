package com.sears.service;

import java.util.List;

import com.sears.entity.Comment;
import com.sears.entity.Post;
import com.sears.entity.SearchFilter;

public interface PostService {

	Post createPost(Post post);
	List<Post> getPosts(SearchFilter filter);
	int deletePost(long postId);
	Post getPost(long id);
	long getNoOfPosts();
	int updateAnswer(long postId,Comment comment);
	int getNoOfSolvedPosts();
}
 