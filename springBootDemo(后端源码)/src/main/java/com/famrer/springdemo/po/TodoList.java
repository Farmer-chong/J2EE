package com.famrer.springdemo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoList {
    private int id;

    @NotBlank(message = "任务名不能为空")
    private String task;

    @NotNull(message = "任务状态不能空")
    private Integer state;

    @JsonIgnore
    private Integer userId;

    @NotNull(message = "任务状态不能为空")
    private Boolean completed;
}
