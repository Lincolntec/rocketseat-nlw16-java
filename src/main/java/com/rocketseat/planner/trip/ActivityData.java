package com.rocketseat.planner.trip;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityData(UUID id, String titulo, LocalDateTime occursAt) {
}
