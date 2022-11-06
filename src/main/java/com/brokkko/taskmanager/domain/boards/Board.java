package com.brokkko.taskmanager.domain.boards;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Board {
    private UUID id;
    private String name;
}
