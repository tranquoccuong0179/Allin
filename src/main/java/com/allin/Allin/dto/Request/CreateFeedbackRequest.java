package com.allin.Allin.dto.Request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateFeedbackRequest {
    String feedbackContent;

    Date feedbackDate;

    String feedbackInteract;
}
