package com.example.thymeleafTest.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Data // lombok의 여러 annotation(getter,setter 등) 한꺼번에 담고 있음
public class FormDto {
    private String name;
    private boolean trueOrFalse;
    private List<String> hobbies;
}
