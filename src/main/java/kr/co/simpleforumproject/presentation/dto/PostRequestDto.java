package kr.co.simpleforumproject.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String postSubject;
    private String postContent;
}
