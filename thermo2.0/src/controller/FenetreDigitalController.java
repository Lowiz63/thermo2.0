/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionListener;
import metier.Capteur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import metier.ComposantCapteurGlobal;
import metier.Generateur;

/**
 *
 * @author pereiraloann
 */
    

public class FenetreDigitalController {
    @FXML
    private TextField textField;
    @FXML
    private Label nom;
    @FXML
    private Label tem;
    private Generateur gen;
    private  ObjectProperty<ComposantCapteurGlobal> monCapteur = new SimpleObjectProperty<>();
        public final ComposantCapteurGlobal getMonCapteur()  { return monCapteur.get(); }
        public final void setMonCapteur(ComposantCapteurGlobal value) { monCapteur.set(value); }
        public ObjectProperty<ComposantCapteurGlobal> monCapteurProperty() {return monCapteur;}
        
    
  
    
    public void onExit(Event event){
       // System.out.println("Arret de : "+monCapteur.get());
       // System.out.println("Arret du thread: "+Thread.currentThread());
       
        gen.arret();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    public void chargement(ComposantCapteurGlobal cap, Generateur gen){
        setMonCapteur(cap);
        this.gen=gen;
        nom.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        tem.textProperty().bind(Bindings.selectInteger(monCapteur, "temperature").asString());
    }
}
