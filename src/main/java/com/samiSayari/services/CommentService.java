package com.samiSayari.services;

import com.samiSayari.entities.Comment;
import com.samiSayari.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment addComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> findAllReclamations(){
        return commentRepository.findAll();
    }

    public Comment findReclamationById(int id) {
        return commentRepository.findById(id).get();
    }

    public void deleteReclamationById(int id) {
        commentRepository.deleteById(id);
    }

    public Comment updateProduct(Comment comment) {
        Comment existingComment = commentRepository.findById(comment.getId()).get();
        if (existingComment != null) {
            return commentRepository.save(comment);
        }
        return null;
    }
}
