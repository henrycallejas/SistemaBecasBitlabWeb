/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.convertidores;

import com.bitlab.controladores.AlumnoControlador;
import com.bitlab.controladores.EstPerfilControlador;
import com.bitlab.entidades.Alumno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author henry
 */
@FacesConverter("alumnoConvertidor") 
public class AlumnoConvertidor implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            AlumnoControlador alumnoControlador = new AlumnoControlador();
            return alumnoControlador.encontrar(Integer.parseInt(value));
        } catch (Exception ex) {
            Logger.getLogger(RolConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Alumno) value).getAluIdPk().toString();
    }
    
}