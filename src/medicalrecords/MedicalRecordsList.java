/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicalrecords;

import Clinic.SequentialDynamicsLists;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 *
<<<<<<< Updated upstream
 * @author josea
=======
 * @author ricar
>>>>>>> Stashed changes
 */
public class MedicalRecordsList implements SequentialDynamicsLists<MedicalRecord>{
    private Stack<MedicalRecord> medicalHistory;

    @Override
    public MedicalRecord get() {
        try{
            return medicalHistory.peek();
        }catch(EmptyStackException e){
            return null;
        }
    }

    @Override
    public boolean remove() {
        try{
            return medicalHistory.pop()!=null;
        }catch(EmptyStackException e){
            return false;
        }
    }

    @Override
    public boolean add(MedicalRecord item) {
       return medicalHistory.add(item);
    }

    @Override
    public Iterator getALL() {
        if(medicalHistory.isEmpty())return null;
        return medicalHistory.iterator();
    }

    @Override
    public int size() {
        return medicalHistory.size();
    }

    @Override
    public boolean isEmpty() {
        return medicalHistory.isEmpty();
    }
    
}
