/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinic;

import appointments.Appointment;
import patients.PatientsList;
import appointments.WaitingRoomLists;
import appointments.appointmentsList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;
/**
 *
 * @author matam
 */
public class Clinica {
    private PatientsList patients;
    private appointmentsList appointmets;
    private WaitingRoomLists waiting;

    public Clinica() {
        this.patients = new PatientsList();
        this.appointmets = new appointmentsList();
        this.waiting = new WaitingRoomLists();
    }

    public boolean addPatient(Patient patient) {
        return patients.add(patient);
    }

    public Patient findPatient(String id) {
        return patients.get(id);
    }

    public boolean removePatient(String id) {
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getALL();
    }

    public boolean scheduleAppointment(Appointment appointment) {
        return appointmets.add(appointment);
    }

    public Appointment findAppointment(String code) {
        return appointmets.get(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        Appointment appointment = findAppointment(code);
        if (appointment == null) {
            return false;
        }
        
        appointment.setDate(newDate); 
        appointment.setTime(newTime);
        return true;
    }

    public boolean cancelAppointment(String code) {
        return appointmets.remove(code);
    }

    public Iterator<Appointment> getAppointments() {
        return appointmets.getALL();
    }

    public boolean checkInPatient(String patientId) {
        Patient patient = findPatient(patientId);
        if (patient == null) {
            return false;
        }
        return waiting.add(patient); 
    }

    public Patient getNextPatient() {
        if (waiting.isEmpty()) return null;
        return waiting.get();
    }

    public Patient attendNextPatient() {
        if (waiting.isEmpty()) return null;
        Patient next = waiting.get(); 
        waiting.remove();            
        return next;
    }

    public int getWaitingPatientCount() {
        return waiting.size();
    }

    public boolean isPatientWaiting(String patientId) {
        Patient patient = findPatient(patientId);
        if (patient == null) return false;
        return waiting.contains(patient);
    }    
}
