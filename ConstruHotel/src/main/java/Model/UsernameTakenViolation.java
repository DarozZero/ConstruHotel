/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ErPat
 */
public class UsernameTakenViolation extends Exception{
    public UsernameTakenViolation(String message){
        super(message);
    }
}