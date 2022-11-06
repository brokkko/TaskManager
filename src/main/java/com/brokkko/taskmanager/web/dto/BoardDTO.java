package com.brokkko.taskmanager.web.dto;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoardDTO {
    private UUID id;
    private String name;
    private UUID user_id;
}
