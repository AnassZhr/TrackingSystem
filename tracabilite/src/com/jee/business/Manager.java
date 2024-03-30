package com.jee.business;
import java.util.List;

import com.jee.dao.AdminDao;
import com.jee.dao.ClientDao;
import com.jee.dao.DossierDao;
import com.jee.dao.EmployeDao;
import com.jee.dao.PersonneDao;
import com.jee.dao.SuperAdminDao;
import com.jee.dao.TacheDao;

import mrtier.entities.client;
import mrtier.entities.dossier;
import mrtier.entities.employe;
import mrtier.entities.personne;
import mrtier.entities.superAdmin;
import mrtier.entities.tache;
import mrtier.entities.admin;

public interface Manager {
public int add(dossier Dossier)	;
public dossier get(String id);
public List<dossier>list();
public void delete(String id);
public int updateProduct(dossier Dossier);

public int addTache(tache Tache);
public tache getTache(String id);
public List<tache>listTache();
public void deleteTache(String id);
public int updateTache(tache Tache);
public List<tache> getTacheDossier(String id_dossier);
public List<tache> getTacheEmploye(String id_employe);
public List<tache> getTacheEmploye0rdre(String id_employe);


public int addPersonne(personne Personne);
public personne getPersonne(String id);
public List<personne>listPersonne();
public void deletePersonne(String id);
public int updatePersonne(personne Personne);

public int addEmploye(employe Employe);
public employe getEmploye(String id);
public List<employe>listEmploye();
public void deleteEmploye(String id);
public int updateEmploye(employe Employe);

public int addClient(client Client);
public client getClient(String id);
public List<client>listClient();
public void deleteClient(String id);
public int updateClient(client Client);

public int addAdmin(admin Admin);
public admin getAdmin(String id);
public List<admin>listAdmin();
public void deleteAdmin(String id);
public int updateAdmin(admin Admin);

public int addSuperAdmin(superAdmin SuperAdmin);
public superAdmin getSuperAdmin(String id);
public List<superAdmin>listSuperAdmin();
public void deleteSuperAdmin(String id);
public int updateSuperAdmin(superAdmin SuperAdmin);


public AdminDao getAdminDao();
public void setAdminDao(AdminDao adminDao);

public SuperAdminDao getSuperAdminDao();
public void setSuperAdminDao(SuperAdminDao superAdminDao);


public EmployeDao getEmployeDao();
public void setEmployeDao(EmployeDao employeDao);

public PersonneDao getPersonneDao();
public void setPersonneDao(PersonneDao personneDao);

public TacheDao getTacheDao();
public void setTacheDao(TacheDao tacheDao);

public DossierDao getDossierDao();
public void setDossierDao(DossierDao dossierDao);

public ClientDao getClientDao();
public void setClientDao(ClientDao clientDao);
public void validerTache(String id, int i);


public admin authentificationAdmin(String email , String password);
public employe authentificationEmploye(String email , String password);

public float getProgreession(int id_dossier);

public dossier getDossierParNum(String numTracking);
public List<tache> tachesValider(String id_employe);



}
