package com.jee.business;

import java.util.List;

import com.jee.dao.*;

import mrtier.entities.*;

public class DefaultManager implements Manager {
	private DossierDao dossierDao;
	private TacheDao tacheDao;
	private PersonneDao personneDao;
	private EmployeDao employeDao;
	private ClientDao clientDao;
	private AdminDao adminDao;
	private SuperAdminDao superAdminDao;

	
	
	
	
	
	
	public ClientDao getClientDao() {
		return clientDao;
	}
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}
	
	public DefaultManager(ClientDao clientDao) {
		super();
		this.clientDao = clientDao;
	}
	public int addClient(client Client) {
		return clientDao.insert(Client);
	}
	public client getClient(String id){
		return clientDao.select(id);
	}
	public employe getEmploye(String id){
		return employeDao.select(id);
	}
	public List<client>listClient() {
		return clientDao.selectAll();
	}
	public void deleteClient(String id) {
		clientDao.delete(id);
	}
	public int updateClient(client Client) {
		return clientDao.updateClient(Client);
	}
	
	
	
	public EmployeDao getEmployeDao() {
		return employeDao;
	}
	public void setEmployeDao(EmployeDao employeDao) {
		this.employeDao = employeDao;
	}
	public DefaultManager(EmployeDao employeDao) {
		super();
		this.employeDao = employeDao;
	}
	public int addEmploye(employe Employe) {
		return employeDao.insert(Employe);
	}
	
	public List<employe>listEmploye() {
		return employeDao.selectAll();
	}
	public void deleteEmploye(String id) {
		employeDao.delete(id);
	}
	public int updateEmploye(employe Employe) {
		return employeDao.updateEmploye(Employe);
	}
	
	
	
	public PersonneDao getPersonneDao() {
		return personneDao;
	}
	public void setPersonneDao(PersonneDao personneDao) {
		this.personneDao = personneDao;
	}
	public DefaultManager(PersonneDao personneDao) {
		super();
		this.personneDao = personneDao;
	}
	
	
	public TacheDao getTacheDao() {
		return tacheDao;
	}
	public void setTacheDao(TacheDao tacheDao) {
		this.tacheDao = tacheDao;
	}
	
	public DefaultManager(TacheDao tacheDao) {
		super();
		this.tacheDao = tacheDao;
	}
	public int addPersonne(personne Personne) {
		return personneDao.insert(Personne);
	}
	
	public int addTache(tache Tache) {
		return tacheDao.insert(Tache);
		}
	public personne getPersonne(String id){
		return personneDao.select(id);
	}
	public tache getTache(String id) {
		return tacheDao.select(id);	
		}
	
	public List<personne>listPersonne() {
		return personneDao.selectAll();
	}
	
	public List<tache> listTache() {
		List<tache> LT = tacheDao.selectAll();
		for(tache t : LT) {
			int id_employe = t.getId_employe();
			employe e=employeDao.select(id_employe+"");
			t.setEmploye(e);
			int id_dossier = t.getId_dossier();
			dossier d=dossierDao.select(id_dossier+"");
			t.setDossier(d);
		}
		
		return LT;
		}
public List<dossier> list() {
		
		
		
		List<dossier> LD = dossierDao.selectAll();
		for(dossier d : LD) {
			int id_client = d.getId_client();
			client c=clientDao.select(id_client+"");
			d.setClient(c);
		}
		return LD;
	}
	public void deletePersonne(String id) {
		personneDao.delete(id);
	}
	public void deleteTache(String id) {
		tacheDao.delete(id);
		}
	public int updatePersonne(personne Personne) {
		return personneDao.updatePersonne(Personne);
	}
	
	public int updateTache(tache Tache) {
		return tacheDao.updateTache(Tache);
		}
	
   public List<tache> getTacheDossier(String id_dossier){
	 
	   
		List<tache> LT = tacheDao.tachesParDossier(id_dossier);
		for(tache t : LT) {
			int id_employe = t.getId_employe();
			employe e=employeDao.select(id_employe+"");
			t.setEmploye(e);
		
			dossier d=dossierDao.select(id_dossier+"");
			t.setDossier(d);
		}
		
		return LT;
   }
   public List<tache> getTacheEmploye(String id_employe){
	   employe e=employeDao.select(id_employe+"");
	   System.out.println("ççççççççççççççççççççççççççç Emloye= "+e);
		List<tache> LT = tacheDao.tachesParEmploye(id_employe);
		for(tache t : LT) {
			
			dossier d=dossierDao.select(t.getId_dossier()+"");
			t.setDossier(d);
			
			t.setEmploye(e);
			System.out.println("gggggggggg tache= "+t);
		}
		
		return LT;
  }
   public List<tache> getTacheEmploye0rdre(String id_employe){
	   employe e=employeDao.select(id_employe+"");
	   System.out.println("ççççççççççççççççççççççççççç Emloye= "+e);
		List<tache> LT = tacheDao.tachesParEmployeOrdre(id_employe);
		for(tache t : LT) {
			
			dossier d=dossierDao.select(t.getId_dossier()+"");
			t.setDossier(d);
			
			t.setEmploye(e);
			System.out.println("gggggggggg tache= "+t);
		}
		
		return LT;
  }
	
	
	
	
	
	
	
	public DefaultManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DefaultManager(DossierDao dossierDao) {
		super();
		this.dossierDao = dossierDao;
	}
	

	public DossierDao getDossierDao() {
		return dossierDao;
	}
	public void setDossierDao(DossierDao dossierDao) {
		this.dossierDao = dossierDao;
	}
	@Override
	public int add(dossier Dossier) {
	return dossierDao.insert(Dossier);
	}

	@Override
	public dossier get(String id) {
	return dossierDao.select(id);	
	}


	public void delete(String id) {
	dossierDao.delete(id);
	}

	@Override
	public int updateProduct(dossier Dossier) {
	return dossierDao.updateDossier(Dossier);
	}
	@Override
	public int addAdmin(admin Admin) {
		return adminDao.insert(Admin);
	}
	@Override
	public admin getAdmin(String id) {
		return adminDao.select(id);	
	}
	@Override
	public List<admin> listAdmin() {
		return adminDao.selectAll();
	}
	@Override
	public void deleteAdmin(String id) {
		personneDao.delete(id);
		
	}
	@Override
	public int updateAdmin(admin Admin) {
		return adminDao.updateAdmin(Admin);
	}
	@Override
	public AdminDao getAdminDao() {
		// TODO Auto-generated method stub
		return adminDao;
	}
	@Override
	public void setAdminDao(AdminDao adminDao) {
		// TODO Auto-generated method stub
		this.adminDao = adminDao;
	}
	
	public int addSuperAdmin(superAdmin SuperAdmin) {
		return superAdminDao.insert(SuperAdmin);
	}
	@Override
	public superAdmin getSuperAdmin(String id) {
		return superAdminDao.select(id);	
	}
	@Override
	public List<superAdmin> listSuperAdmin() {
		return superAdminDao.selectAll();
	}
	@Override
	public void deleteSuperAdmin(String id) {
		personneDao.delete(id);
		
	}
	@Override
	public int updateSuperAdmin(superAdmin SuperAdmin) {
		return superAdminDao.updateSuperAdmin(SuperAdmin);
	}
	@Override
	public SuperAdminDao getSuperAdminDao() {
		// TODO Auto-generated method stub
		return superAdminDao;
	}
	@Override
	public void setSuperAdminDao(SuperAdminDao superAdminDao) {
		// TODO Auto-generated method stub
		this.superAdminDao = superAdminDao;
	}
	@Override
	public void validerTache(String id,int id_dossier) {
		// TODO Auto-generated method stub
		tacheDao.validerTache(id,id_dossier);
	}
	public admin authentificationAdmin(String email , String password) {
		return adminDao.authentificationAdmin(email, password);
	}
	public employe authentificationEmploye(String email , String password) {
		return employeDao.authentificationEmploye(email, password);
	}
	@Override
	public float getProgreession(int id_dossier) {
		// TODO Auto-generated method stub
		return dossierDao.getProgression(id_dossier);
	}
	@Override
	public dossier getDossierParNum(String numTracking) {
		// TODO Auto-generated method stub
		return dossierDao.selectNumTracking(numTracking);	

	}
	public List<tache> tachesValider(String id_employe){
		 employe e=employeDao.select(id_employe+"");
		   System.out.println("ççççççççççççççççççççççççççç Emloye= "+e);
			List<tache> LT = tacheDao.tachesValider(id_employe);
			for(tache t : LT) {
				
				dossier d=dossierDao.select(t.getId_dossier()+"");
				t.setDossier(d);
				
				t.setEmploye(e);
				System.out.println("gggggggggg tache= "+t);
			}
			
			return LT;
	}
	





}
