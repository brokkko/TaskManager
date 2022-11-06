package com.brokkko.taskmanager.enumerations;

import lombok.Getter;

@Getter
public enum TaskStatus {
    TODO("TODO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");
    private final String taskStatus;

    TaskStatus(String status) {
        this.taskStatus = status;
    }


}
