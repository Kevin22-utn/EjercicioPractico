/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package appointments;

import appointments.AppointmentStatus;
import java.time.LocalDate;
import java.time.LocalTime;
import patients.Patient;


public class Appointment implements Comparable<Appointment> {
    
    private String code;
    private Patient patient;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private AppointmentStatus status;

    public Appointment(String code, Patient patient, LocalDate date, LocalTime time, String reason) {
        this.code = code;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public String getCode() {
        return code;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public void reschedule(LocalDate newDate, LocalTime newTime) {
        this.date = newDate;
        this.time = newTime;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    public boolean isPending() {
        return this.status == AppointmentStatus.SCHEDULED;
    }

    public boolean isToday() {
        return this.date != null && this.date.equals(LocalDate.now());
    }

    @Override
    public int compareTo(Appointment other) {
        if (other == null) return 1;

        int dateCmp = this.date.compareTo(other.date);
        if (dateCmp != 0) return dateCmp;

        int timeCmp = this.time.compareTo(other.time);
        if (timeCmp != 0) return timeCmp;

        return this.code.compareTo(other.code);
    }
}
