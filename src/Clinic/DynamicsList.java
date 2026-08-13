/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clinic;

import java.util.Iterator;

/**
 *
 * @author matam
 * @param <T>
 */
public interface DynamicsList <T>{
    public boolean add(T item);
    public Iterator getALL();
    public int size();
    public boolean isEmpty();
    
}
