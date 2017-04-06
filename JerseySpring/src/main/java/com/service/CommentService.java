package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.comment.Comment;

public class CommentService {

	static Logger log = Logger.getLogger(CommentService.class.getName());

	Configuration config = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionfactory = config.buildSessionFactory();

	public List<Comment> getAllComments() {
		Session session = sessionfactory.openSession();
		log.info("Starting getAllComments");
		List<Comment> list = session.createQuery("from Comment").list();
		return list;
	}

	public Comment getCommentById(Integer commentId) {
		log.info("Starting get Comment By Id" + commentId);

		Session session = sessionfactory.openSession();
		Comment comment = session.get(Comment.class, commentId);
		session.close();
		return comment;

	}
}
