package com.allin.Allin.Service.Implement;

import com.allin.Allin.Repository.FeedbackRepository;
import com.allin.Allin.Service.FeedbackService;
import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public ResponseEntity<ResponseObj> getAllFeedback() {
        return null;
    }
}
