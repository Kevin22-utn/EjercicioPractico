/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Clinic;

/**
 *
 * @author matam
 * @param <T>
 * @param <K>
 */
public interface WaitingLists <T,K> extends DynamicsList<T>{
    public T get(K id);
    public boolean remove(K id);
}

