/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinic;
import appointments.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import patients.Patient;
/**
 *
 * @author matam
 */
public class ClinicControl {

    private static ClinicControl instance;
    private View<Appointment> view;
    private List<Appointment> appointmentsList = new ArrayList<>();
    private List<Patient> patientsList = new ArrayList<>();

    private ClinicControl(View<Appointment> view) {
        this.view = view;
    }

    public static ClinicControl getInstance(View<Appointment> view) {
        if (instance == null) {
            instance = new ClinicControl(view);
        } else {
            instance.view = view; 
        }
        return instance;
    }

    public Iterator<Appointment> getAppointment() {
        return appointmentsList.iterator();
    }

    public Patient findPatient(String id) {
        for (Patient p : patientsList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean scheduleAppointment(Appointment app) {
        for (Appointment a : appointmentsList) {
            if (a.getCode().equalsIgnoreCase(app.getCode())) {
                return false; 
            }
        }
        return appointmentsList.add(app);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        for (Appointment a : appointmentsList) {
            if (a.getCode().equalsIgnoreCase(code)) {
                a.setDate(newDate);
                a.setTime(newTime);
                return true;
            }
        }
        return false;
    }

    public boolean cancelAppointment(String code) {
        return appointmentsList.removeIf(a -> a.getCode().equalsIgnoreCase(code));
    }

    public void addPatient(Patient p) {
        patientsList.add(p);
    }
}
