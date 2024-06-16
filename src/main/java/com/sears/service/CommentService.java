package com.sears.service;

import com.sears.entity.Comment;

public interface CommentService {
	Comment saveComment(Comment comment);
	int deleteComment(long commentId);
}
