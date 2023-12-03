/*
 * UsernameTakenViolation
 *
 * Ver 1.0 - Versión funcional final
 *
 * 04/12/2004
 *
 * Copyright - MuñozÁviles2024
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
