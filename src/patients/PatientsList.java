/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patients;

import java.util.Iterator;
import Clinic.KeyDinamicsLists;
import java.util.HashMap;

/**
 *
 * @author ricar
 */
public class PatientsList implements KeyDinamicsLists<Patient, String> {
    private HashMap<String, Patient> patients;

    public PatientsList() {
        this.patients = new HashMap<>();
    }

    public PatientsList(HashMap<String, Patient> patients) {
        this.patients = patients;
    }

    @Override
    public Patient get(String id) {
        return patients.get(id); 
    }

    @Override
    public boolean remove(String id) {
        return patients.remove(id) != null; 
    }

    @Override
    public boolean add(Patient item) {
        if (item == null || item.getId() == null) return false;
        boolean alreadyExists = patients.containsKey(item.getId());
        patients.put(item.getId(), item);
        return !alreadyExists;
    }

    @Override
    public int size() {
        return patients.size();
    }

    @Override
    public boolean isEmpty() {
        return patients.isEmpty();
    }

    @Override
    public Iterator<Patient> getALL() {
        if (patients.isEmpty()) return null;
        return patients.values().iterator(); 
    }
}
