
import entity.Patient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andrei
 */
@ManagedBean(name = "dentistForm")
@ApplicationScoped
public class DentistForm {

    private Patient patient;
    private List<Patient> listPatient = new ArrayList<>();
    private List<String> listDoctor = new ArrayList<>();
    private boolean active=true;

    private Map<String, List<String>> mapProcedure;
    private Map<String, String> proced_descript;

    private String procedureDesc = "Choose one procedure";
    private String docDesc = "Choose one Doctor";
    private String check="";
      private boolean activebt;

    @PostConstruct
    public void init() {
        patient = new Patient();
        initProcedure();
    }
    
    public void newBook(){
        active=true;
          patient = new Patient();
          activebt=false;
          check="";
          procedureDesc = "Choose one procedure";
          docDesc = "Choose one Doctor";
    }

    public void booking() {
        listPatient.add(patient);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Save success", ""));
    }

    public void initDoctor() {
        listDoctor = mapProcedure.get(patient.getProcedure());
        procedureDesc = proced_descript.get(patient.getProcedure());
    }

    public void initDescDoctor() {
        docDesc = proced_descript.get(patient.getDoctor());
        if (patient.getDoctor() == null) {
            active = true;
        } else {
            active = false;
        }
    }
    public void checkAvailable(){
        if(listPatient.size()>0){
        for (Patient patientSaved:listPatient) {
            if(patientSaved.equals(patient)){
                check="unAvailable";
                activebt=true;
                break;
            }else{
                check="available";
                activebt=false;
            }
        }
        }else{
             check="available";
        }
        
    }
    

    private void initProcedure() {
        mapProcedure = new HashMap<>();
        proced_descript = new HashMap<>();

        mapProcedure.put("Procedura 1", Arrays.asList("Doctor 1"));
        mapProcedure.put("Procedura 2", Arrays.asList("Doctor 3"));
        mapProcedure.put("Procedura 3", Arrays.asList("Doctor 6", "Doctor 8"));
        mapProcedure.put("Procedura 4", Arrays.asList("Doctor 4", "Doctor 9", "Doctor 10"));

        proced_descript.put("Procedura 1", "Something about procedure1");
        proced_descript.put("Procedura 2", "color teeth procedure");
        proced_descript.put("Procedura 3", "change tooth");
        proced_descript.put("Procedura 4", "info porcedure 4");

        proced_descript.put("Doctor 1", "info Doctor 1");
        proced_descript.put("Doctor 3", "info Doctor 3");
        proced_descript.put("Doctor 6", "info Doctor 6");
        proced_descript.put("Doctor 8", "info Doctor 8");
        proced_descript.put("Doctor 4", "info Doctor 4");
        proced_descript.put("Doctor 9", "info Doctor 9");
        proced_descript.put("Doctor 10", "info Doctor 10");

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Patient> getListPatient() {
        return listPatient;
    }

    public void setListPatient(List<Patient> listPatient) {
        this.listPatient = listPatient;
    }

    public List<String> getListDoctor() {
        return listDoctor;
    }

    public void setListDoctor(List<String> listDoctor) {
        this.listDoctor = listDoctor;
    }

    public String getProcedureDesc() {
        return procedureDesc;
    }

    public void setProcedureDesc(String procedureDesc) {
        this.procedureDesc = procedureDesc;
    }

    public String getDocDesc() {
        return docDesc;
    }

    public void setDocDesc(String docDesc) {
        this.docDesc = docDesc;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public boolean isActivebt() {
        return activebt;
    }

    public void setActivebt(boolean activebt) {
        this.activebt = activebt;
    }

    
}
