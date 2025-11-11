package com.post_hub.iam_service.controller;

import com.post_hub.iam_service.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService defaultService;
    private final CommentService advancedService;

    public CommentController(CommentService defaultService,
                             @Qualifier("advancedCommentService") CommentService advancedService) {
        this.defaultService = defaultService;
        this.advancedService = advancedService;
    }

    @PostMapping("/default")
    public ResponseEntity<String> createComment(@RequestBody Map<String, Object> requestBody){
        String comment = (String) requestBody.get("comment");
        defaultService.addComment(comment);

        return new ResponseEntity<>("Default Service: " + comment, HttpStatus.OK);
    }

    @PostMapping("/advanced")
    public ResponseEntity<String> switchService(@RequestBody Map<String, Object> requestBody){

        String comment = (String) requestBody.get("comment");
        advancedService.addComment(comment);

        return new ResponseEntity<>("Advanced Service: " + comment, HttpStatus.OK);
    }
}
