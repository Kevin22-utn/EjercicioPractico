/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import Clinic.SequentialDynamicsLists;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import patients.Patient;
/**
 *
 * @author matam
 */
public class WaitingRoomLists implements SequentialDynamicsLists<Patient> {
    private Queue<Patient> waitingList;

    public WaitingRoomLists() {
        this.waitingList = new ArrayDeque<>();
    }

    public WaitingRoomLists(Queue<Patient> waitingList) {
        this.waitingList = waitingList;
    }

    @Override
    public Patient get() {
        return waitingList.peek();
    }

    @Override
    public boolean remove() {
        return waitingList.poll() != null;
    }

    @Override
    public boolean add(Patient item) {
        try {
            return waitingList.add(item);
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override
    public int size() {
        return waitingList.size();
    }

    @Override
    public boolean isEmpty() {
        return waitingList.isEmpty();
    }

    @Override
    public Iterator<Patient> getALL() {
        if (waitingList.isEmpty()) return null;
        return waitingList.iterator();
    }

    public boolean contains(Patient patient) {
        return waitingList.contains(patient);
    }
}