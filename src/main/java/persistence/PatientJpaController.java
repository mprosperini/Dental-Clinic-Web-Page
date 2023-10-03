package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logic.KidGuardian;
import logic.Patient;
import persistence.exceptions.NonexistentEntityException;

public class PatientJpaController implements Serializable {

    public PatientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public PatientJpaController() {
        emf = Persistence.createEntityManagerFactory("DentalClinicProjectJava_PU");
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Patient patient) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            KidGuardian kidGuardian = patient.getKidGuardian();
            if (kidGuardian != null) {
                kidGuardian = em.getReference(kidGuardian.getClass(), kidGuardian.getIdPerson());
                patient.setKidGuardian(kidGuardian);
            }
            em.persist(patient);
            if (kidGuardian != null) {
                Patient oldaPatientOfKidGuardian = kidGuardian.getaPatient();
                if (oldaPatientOfKidGuardian != null) {
                    oldaPatientOfKidGuardian.setKidGuardian(null);
                    oldaPatientOfKidGuardian = em.merge(oldaPatientOfKidGuardian);
                }
                kidGuardian.setaPatient(patient);
                kidGuardian = em.merge(kidGuardian);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Patient patient) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patient persistentPatient = em.find(Patient.class, patient.getIdPerson());
            KidGuardian kidGuardianOld = persistentPatient.getKidGuardian();
            KidGuardian kidGuardianNew = patient.getKidGuardian();
            if (kidGuardianNew != null) {
                kidGuardianNew = em.getReference(kidGuardianNew.getClass(), kidGuardianNew.getIdPerson());
                patient.setKidGuardian(kidGuardianNew);
            }
            patient = em.merge(patient);
            if (kidGuardianOld != null && !kidGuardianOld.equals(kidGuardianNew)) {
                kidGuardianOld.setaPatient(null);
                kidGuardianOld = em.merge(kidGuardianOld);
            }
            if (kidGuardianNew != null && !kidGuardianNew.equals(kidGuardianOld)) {
                Patient oldaPatientOfKidGuardian = kidGuardianNew.getaPatient();
                if (oldaPatientOfKidGuardian != null) {
                    oldaPatientOfKidGuardian.setKidGuardian(null);
                    oldaPatientOfKidGuardian = em.merge(oldaPatientOfKidGuardian);
                }
                kidGuardianNew.setaPatient(patient);
                kidGuardianNew = em.merge(kidGuardianNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = patient.getIdPerson();
                if (findPatient(id) == null) {
                    throw new NonexistentEntityException("The patient with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patient patient;
            try {
                patient = em.getReference(Patient.class, id);
                patient.getIdPerson();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The patient with id " + id + " no longer exists.", enfe);
            }
            KidGuardian kidGuardian = patient.getKidGuardian();
            if (kidGuardian != null) {
                kidGuardian.setaPatient(null);
                kidGuardian = em.merge(kidGuardian);
            }
            em.remove(patient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Patient> findPatientEntities() {
        return findPatientEntities(true, -1, -1);
    }

    public List<Patient> findPatientEntities(int maxResults, int firstResult) {
        return findPatientEntities(false, maxResults, firstResult);
    }

    private List<Patient> findPatientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Patient.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Patient findPatient(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Patient.class, id);
        } finally {
            em.close();
        }
    }

    public int getPatientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Patient> rt = cq.from(Patient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
