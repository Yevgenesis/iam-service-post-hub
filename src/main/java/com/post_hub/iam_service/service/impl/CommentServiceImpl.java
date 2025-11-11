package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.service.CommentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CommentServiceImpl implements CommentService {
    private final List<String> comments = new ArrayList<>();

    @Override
    public void addComment(String comment) {
        System.out.println("Adding comment to default: " + comment);
        comments.add(comment);
    }
}
