/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import Clinic.KeyDinamicsLists;
import java.util.Iterator;
import java.util.TreeSet;
/**
 *
 * @author matam
 */
public class appointmentsList implements KeyDinamicsLists<Appointment,String>{
    private TreeSet<Appointment> appointments;

    public appointmentsList() {
        this.appointments = new TreeSet<>();
    }
    
    public appointmentsList(TreeSet<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    @Override
    public Appointment get(String code) {
        for (Appointment appo : appointments){
            if(appo.getCode().equals(code))return appo;
        }
        return null;
    }

    @Override
    public boolean remove(String id) {
        Appointment appo=this.get(id);
        if(appo==null)return false;
        return appointments.remove(appo);
    }

    @Override
    public boolean add(Appointment item) {
        return appointments.add(item);
    }

    @Override
    public int size() {
        return appointments.size();

    }

    @Override
    public boolean isEmpty() {
        return appointments.isEmpty();
    }

    @Override
    public Iterator<Appointment> getALL() {
    if (appointments.isEmpty()) return null;
    return appointments.iterator();
    }                
}