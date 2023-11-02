package com.allin.Allin.Controller;

import com.allin.Allin.Service.FeedbackService;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    public ResponseEntity<ResponseObj> getAllFeedback(){
        return feedbackService.getAllFeedback();
    }
}
