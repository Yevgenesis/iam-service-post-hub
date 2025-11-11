package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.service.CommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("advancedCommentService")
public class SecondCommentServiceImpl implements CommentService {

    private final List<String> comments = new ArrayList<>();

    @Override
    public void addComment(String comment) {
        String advancedComment = "[" + LocalDateTime.now() + "] " + comment.toUpperCase();
        System.out.println(advancedComment);
        comments.add(advancedComment);
    }
}
