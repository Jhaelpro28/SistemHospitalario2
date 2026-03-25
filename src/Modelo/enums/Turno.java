/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.enums;

/**
 *
 * @author Usuario
 */
public enum Turno {

    MANANA(50),
    TARDE(100),
    NOCHE(200);

    private double bono;

    Turno(double bono) {
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }
}