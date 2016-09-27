/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessions;

import Entity.EmailEntry;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author DalidasMac
 */
@Stateless
public class EmailEntryFacade extends AbstractFacade<EmailEntry> {

    @PersistenceContext(unitName = "EmailEditorPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmailEntryFacade() {
        super(EmailEntry.class);
    }

    public List<EmailEntry> findById(int id) {
       Query q=em.createNamedQuery("EmailEntry.findById");
        q.setParameter("id", id);
        List<EmailEntry> emailEntry = q.getResultList();
        return emailEntry;
  }

    public void deleteById(EmailEntry entity) throws Exception {
 try {
            remove(entity);
        }
        catch(Exception e) {
            throw new Exception("Delete Transaction Failed");
        }    }

    public List<EmailEntry> findByLastName(String lastName) {
      // Query q = em.createNamedQuery("EmailEntry.findByLastname");
        Query q = em.createQuery("SELECT g FROM EmailDB g WHERE g.lastname = :lastname");
        q.setParameter("lastname", lastName);
        List<EmailEntry> emailEntry = q.getResultList();
        return emailEntry;    }

    public List<EmailEntry> showAllRecords() {
        Query q=em.createNamedQuery("EmailEntry.findAll");
        List<EmailEntry> emailEntry = q.getResultList();
        return emailEntry; 
    }

    public int getNumberOfRecords() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<EmailEntry> rt = cq.from(EmailEntry.class);
        cq.select(cb.count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public void persistEmailData(int id, String firstName, String lastName, String emailAddress) {
    try {
            EmailEntry g = new EmailEntry();
            g.setId(id);
            g.setFirstName(firstName);
            g.setLastName(lastName);
            g.setEmailAddress(emailAddress);
            em.persist(g);
        }
        catch (Exception e) {
            e.printStackTrace();
        }    }
    
    
    
    
    
    
    
}
