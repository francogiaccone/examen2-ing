package com.mycompany.examen2.ing;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;

public class RevendedoraTest {
    
    private static Revendedora revCuenta;
    private static Revendedora rev3;
    private static int i = 0;
    
    public RevendedoraTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        LocalDate fechaActual = LocalDate.now();

        // Formatear la fecha en un formato específico
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("es-AR"));
        String fechaFormateada = fechaActual.format(formatter);

        // Imprimir la fecha formateada
        System.out.println("Fecha de transaccion " + fechaFormateada);
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("FIN de la transaccion");
    }
    
    @BeforeEach
    public void setUp() {
        revCuenta = new Revendedora("Julia A.", "11223344", 1);
        rev3 = new Revendedora("Angela B.", "55667788", 2);
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Transaccion " + i + "> El monto en cuenta es " + revCuenta.getSaldo());
    }

    @Test
    public void testRetirarFallo() {
        assertThrows(Exception.class, () -> revCuenta.retirarDinero(88000.0));
        i++;
    }
    
    @Test
    public void testRetirarExito() throws Exception{
        double saldoInicial = 10000;
        double monto = 5000;
        revCuenta.setSaldo(saldoInicial);
        revCuenta.retirarDinero(monto);
        assertEquals(saldoInicial - monto, revCuenta.getSaldo());
        i++;
    }
    
    @Test
    public void testDepositarDinero() throws Exception {
        revCuenta.setSaldo(9000);
        assertNull(revCuenta.getNroCuenta());
        revCuenta.depositarDinero(2000);
        assertEquals(11000.0, revCuenta.getSaldo(), 0.2);
        i++;
    }
    
    @Test
    public void testTransferirCuentaNoNula() throws Exception {
        assertNull(revCuenta.getNroCuenta());
        revCuenta.transferirDinero(rev3, 5000.0);
        i++;
    }
    
    @Test
    public void testSiempreFalla() {
        fail("Este test siempre falla");
        i++;
    }
    
    @Test
    public void testDolarMEP1() {
        assertEquals(1300, revCuenta.convertirMoneda("1300"), 0);
        i++;
    }

    @Test
    public void testDolarMEP2() {
        assertEquals(1300, revCuenta.convertirMoneda("1300 U$S"), 0);
        i++;
    }

    @Test
    public void testMismaRevendedora() {
        assertSame(revCuenta, rev3, "Las cuentas son diferentes");
        i++;
    }

    @Test
    @Timeout(1)
    public void testPagoDemorado() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> revCuenta.pagoDemorado(100));
        i++;
    }
    
}
