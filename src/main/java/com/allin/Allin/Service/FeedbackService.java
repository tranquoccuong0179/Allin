package com.allin.Allin.Service;

import com.allin.Allin.dto.Response.ResponseObj;
import org.springframework.http.ResponseEntity;

public interface FeedbackService {
    ResponseEntity<ResponseObj> getAllFeedback();
}
