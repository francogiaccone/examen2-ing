package com.mycompany.examen2.ing;

import java.util.Date;
import java.util.List;
import java.lang.Exception;

public class Revendedora {

    private Campaña campañaActual;
    private String dni;
    private boolean hizoPedido;
    private String nombreCompleto;
    private int nroCuenta;
    private List<Pedido> pedidos;
    private double saldo;

    public Revendedora(String nombreCompleto, String dni, int nroCuenta) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.nroCuenta = nroCuenta;
    }
    
    //gets y sets
    public Campaña getCampañaActual() {
        return campañaActual;
    }

    public void setCampañaActual(Campaña campañaActual) {
        this.campañaActual = campañaActual;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isHizoPedido() {
        return hizoPedido;
    }

    public void setHizoPedido(boolean hizoPedido) {
        this.hizoPedido = hizoPedido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void retirarDinero(double monto) throws Exception {
        if (monto > saldo) {
            throw new Exception("Saldo insuficiente");
        }
        this.saldo -= monto;
    }
    
    public void depositarDinero(double monto) throws Exception {
        if (monto < 0) {
            throw new Exception("Saldo negativo");
        }
        this.saldo += monto;
    }
    
    public void transferirDinero(Revendedora revendedora, double monto) throws Exception {
        if (monto < 0) {
            throw new Exception("Saldo negativo");
        }
        revendedora.setSaldo(revendedora.getSaldo() + monto);
        this.saldo -= monto;
    }
    
    public double convertirMoneda(String cantidad) {
        return Double.parseDouble(cantidad);
    }
    

    public void cambiarCampana(Campaña campaña) {

    }

    public Caja hacerCaja(Producto producto, int cantidad) {
        return null;
    }

    public Pedido hacerPedido(int numero, Date fechaIngreso, Date fechaEntrega, List<Caja> cajas, String domicilio, String qr) {
        return null;
    }

    public List<Pedido> listarPedidos() {
        return null;
    }
    
    public void pagoDemorado(int tiempo) throws InterruptedException {
        Thread.sleep(tiempo);
        System.out.println("Pago realizado despues de " + tiempo + "ms");
    }
}
