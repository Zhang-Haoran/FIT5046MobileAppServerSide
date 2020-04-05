/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import MobileAppServerSide.Credentialstable;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 61402
 */
@Stateless
@Path("mobileappserverside.credentialstable")
public class CredentialstableFacadeREST extends AbstractFacade<Credentialstable> {

    @PersistenceContext(unitName = "FIT5046MobleAppServerSidePU")
    private EntityManager em;

    public CredentialstableFacadeREST() {
        super(Credentialstable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credentialstable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Credentialstable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Credentialstable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentialstable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentialstable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
        
  @GET
    @Path("findByUsername/{username}")
    @Produces({"application/json"})
    public List<Credentialstable> findByUsername(@PathParam("username") String username)
        {
            Query query = em.createNamedQuery("Credentialstable.findByUsername");
            query.setParameter("username",username);
            return query.getResultList();
        }
    
    @GET
    @Path("findByPasswordhash/{passwordhash}")
    @Produces({"application/json"})
    public List<Credentialstable> findByPasswordhash(@PathParam("passwordhash") String passwordhash)
        {
            Query query = em.createNamedQuery("Credentialstable.findByPasswordhash");
            query.setParameter("passwordhash",passwordhash);
            return query.getResultList();
        }
    
    @GET
    @Path("findBySignupdate/{signupdate}")
    @Produces({"application/json"})
    public List<Credentialstable> findBySignupdate(@PathParam("signupdate") Date signupdate)
        {
            Query query = em.createNamedQuery("Credentialstable.findBySignupdate");
            query.setParameter("signupdate",signupdate);
            return query.getResultList();
        }
}
