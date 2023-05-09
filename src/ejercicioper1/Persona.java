/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioper1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Objects;
 class Persona {
   private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }
    }

    private LocalDate generarFecha(String fechaNacimiento) {
        LocalDate fechaCorrecta;
        String fechaOrdenada;

        if (fechaNacimiento.charAt(2) == fechaNacimiento.charAt(5)
                && ((fechaNacimiento.charAt(2) == '-' || fechaNacimiento.charAt(2) == '-')
                || (fechaNacimiento.charAt(2) == '/' || fechaNacimiento.charAt(5) == '/'))) {
            fechaOrdenada = getFechaNacimiento('-', fechaNacimiento);
            try {
                fechaCorrecta = LocalDate.parse(fechaOrdenada);
                return fechaCorrecta;
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
      

    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
    }

    public String getFechaNacimiento(char separador, String fechaNacimiento) {
        String fechaCorrecta;
        try {
            fechaCorrecta = fechaNacimiento.substring(6, fechaNacimiento.length()) + separador + fechaNacimiento.substring(3, 5) + separador + fechaNacimiento.substring(0, 2);
        } catch (NullPointerException e) {
            fechaCorrecta = "null";
            return fechaCorrecta;
        }
        return fechaCorrecta;
    }

    public String setFechaNacimiento(String fechaNacimiento) {
        String nuevaFecha;
        generarFecha(fechaNacimiento);
        nuevaFecha = generarFecha(fechaNacimiento).toString();
        return nuevaFecha;
    }

    public int getEdadEnFecha(String cadenaFecha) {
        int edad;

        if (this.fechaNacimiento == null) {
            return -1;
        }

        LocalDate nuevaFecha = generarFecha(cadenaFecha);
        try {
            edad = nuevaFecha.getYear() - this.fechaNacimiento.getYear();
            if (this.fechaNacimiento.getMonthValue() > nuevaFecha.getMonthValue()
                    || (this.fechaNacimiento.getMonthValue() == nuevaFecha.getMonthValue()
                    && this.fechaNacimiento.getDayOfMonth() > nuevaFecha.getDayOfMonth())) {
                edad--;
            }
            return edad;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public int getEdad() {
        int edad;
        Period periodo = null;

        if (this.fechaNacimiento == null) {
            return -1;
        } else {
            try {

                periodo = periodo.between(fechaNacimiento, LocalDate.now());
                edad = periodo.getYears();
                if (edad < 0) {
                    edad = -1;
                }
                return edad;
            } catch (IllegalArgumentException e) {
                return -1;
            }

        }
      

    }
}