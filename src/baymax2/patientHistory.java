/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baymax2;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author USCHAS
 */
public class patientHistory {


    private SimpleStringProperty name, date, consultant;

    public patientHistory(String name, String date, String consultant) {
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.consultant = new SimpleStringProperty(consultant);
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    public String getConsultant() {
        return consultant.get();
    }

    public void setConsultant(SimpleStringProperty consultant) {
        this.consultant = consultant;
    }


}
