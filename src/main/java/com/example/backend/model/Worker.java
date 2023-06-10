package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker extends Person {
    @Column(nullable = false)
    private Date workStartDate;
    @Enumerated(EnumType.STRING)
    private WorkerRole workerRole;
    @OneToMany
    private Collection<Ride> rides;

    public static EnumSet<WorkerRole> getWorkerRoles() {
        return EnumSet.allOf(WorkerRole.class);
    }

    public enum WorkerRole {
        MANAGER, TECHNICIAN, RECEPTIONIST, OWNER
    }
}
