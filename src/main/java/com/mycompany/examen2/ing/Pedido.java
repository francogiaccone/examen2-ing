package com.mycompany.examen2.ing;

import java.util.Date;
import java.util.List;

public class Pedido {

    private List<Caja> cajas;
    private Campaña campaña;
    private String domicilio;
    private boolean estadoPago;
    private Date fechaEntrega;
    private Date fechaIngreso;
    private Date fechaPago;
    private double importe;
    private int numero;
    private String qr;
    private Revendedora revendedor;
}
