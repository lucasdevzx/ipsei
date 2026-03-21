package com.project.ipsei.Entities;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Embeddable
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Audit {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private UUID changedBy;

    public void onCreate(UUID userId) {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.changedBy = requireNonNull(userId, "userId cannot be null");
    }

    public void onUpdate(UUID userId) {
        validateForUpdate();
        this.updatedAt = LocalDateTime.now();
        this.changedBy = requireNonNull(userId, "userId cannot be null");
    }

    public void onDelete(UUID userId) {
        validateForDelete();
        this.deletedAt = LocalDateTime.now();
        this.changedBy = requireNonNull(userId, "userId cannot be null");
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }

    private void validateForUpdate() {
        if (createdAt == null) {
            throw new IllegalStateException("Cannot update an entity that hasn't been created");
        }
        if (isDeleted()) {
            throw new IllegalStateException("Cannot update a deleted entity");
        }
    }

    private void validateForDelete() {
        if (createdAt == null) {
            throw new IllegalStateException("Cannot delete an entity that hasn't been created");
        }
        if (isDeleted()) {
            throw new IllegalStateException("Entity is already deleted");
        }
    }
}