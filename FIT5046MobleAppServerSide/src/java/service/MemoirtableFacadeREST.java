/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import MobileAppServerSide.Memoirtable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
@Path("mobileappserverside.memoirtable")
public class MemoirtableFacadeREST extends AbstractFacade<Memoirtable> {

    @PersistenceContext(unitName = "FIT5046MobleAppServerSidePU")
    private EntityManager em;

    public MemoirtableFacadeREST() {
        super(Memoirtable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Memoirtable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Memoirtable entity) {
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
    public Memoirtable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Memoirtable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Memoirtable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findByMoviename/{moviename}")
    @Produces({"application/json"})
    public List<Memoirtable> findByMoviename(@PathParam("moviename") String moviename)
        {
            Query query = em.createNamedQuery("Memoirtable.findByMoviename");
            query.setParameter("moviename",moviename);
            return query.getResultList();
        }
    
      @GET
    @Path("findByMoviereleasedate/{moviereleasedate}")
    @Produces({"application/json"})
    public List<Memoirtable> findByMoviereleasedate(@PathParam("moviereleasedate") Date moviereleasedate)
        {
            Query query = em.createNamedQuery("Memoirtable.findByMoviereleasedate");
            query.setParameter("moviereleasedate",moviereleasedate);
            return query.getResultList();
        }
    
       @GET
    @Path("findByWatchdate/{watchdate}")
    @Produces({"application/json"})
    public List<Memoirtable> findByWatchdate(@PathParam("watchdate") Date watchdate)
        {
            Query query = em.createNamedQuery("Memoirtable.findByWatchdate");
            query.setParameter("watchdate",watchdate);
            return query.getResultList();
        }
    
       @GET
    @Path("findByWatchtime/{watchtime}")
    @Produces({"application/json"})
    public List<Memoirtable> findByWatchtime(@PathParam("watchtime") Time watchtime)
        {
            Query query = em.createNamedQuery("Memoirtable.findByWatchtime");
            query.setParameter("watchtime",watchtime);
            return query.getResultList();
        }
    
        @GET
    @Path("findByComment/{comment}")
    @Produces({"application/json"})
    public List<Memoirtable> findByComment(@PathParam("comment") String comment)
        {
            Query query = em.createNamedQuery("Memoirtable.findByComment");
            query.setParameter("comment",comment);
            return query.getResultList();
        }
    
      @GET
    @Path("findByRatingscore/{ratingscore}")
    @Produces({"application/json"})
    public List<Memoirtable> findByRatingscore(@PathParam("ratingscore") int ratingscore)
        {
            Query query = em.createNamedQuery("Memoirtable.findByRatingscore");
            query.setParameter("ratingscore",ratingscore);
            return query.getResultList();
        }
    
    @GET
    @Path("findByMovienameANDCinemaname/{moviename}/{cinemaname}")
    @Produces({"application/json"})
    public List<Memoirtable>findByMovienameANDCinemaname(@PathParam("moviename") String moviename, @PathParam("cinemaname") String cinemaname)
    {
            TypedQuery<Memoirtable> query = em.createQuery("SELECT m FROM Memoirtable m WHERE m.moviename =:moviename AND m.cinemaid = (SELECT c.cinemaid FROM Cinematable c WHERE c.cinemaname =:cinemaname) ",Memoirtable.class);
            query.setParameter("moviename",moviename);
            query.setParameter("cinemaname",cinemaname);
            return query.getResultList();
    }
    
       @GET
    @Path("findByMovienameANDSuburb/{moviename}/{suburb}")
    @Produces({"application/json"})
    public List<Memoirtable> findByMovienameANDSuburb(@PathParam("moviename") String moviename,@PathParam("suburb") String suburb )
        {
            Query query = em.createNamedQuery("Memoirtable.findByMovienameANDSuburb");
            query.setParameter("moviename",moviename);
            query.setParameter("suburb",suburb);
            return query.getResultList();
        }
    
   
    @GET
    @Path("findByUseridANDYear/{userid}/{year}")
    @Produces({"application/json"})
    public JsonArray findByUseridANDYear(@PathParam("userid") int userid, @PathParam("year") String year){
        TypedQuery<Memoirtable> query = em.createQuery("SELECT m FROM Memoirtable m WHERE m.userid.userid = :userid AND EXTRACT (YEAR FROM m.watchdate) = :year",Memoirtable.class);
        query.setParameter("userid", userid);
        query.setParameter("year", year); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");//date format MMMM gives the month name
        List<Memoirtable> result = query.getResultList();
        ArrayList<String> monthList = new ArrayList<>();
        JsonArrayBuilder monthJsonArray = Json.createArrayBuilder();  
        for(Memoirtable m: result){
            String month = dateFormat.format(m.getWatchdate());
        monthList.add(month);
//        monthJsonArray.add(month);
    }
         ArrayList<String> alreadyCalculated = new ArrayList<>();
        int numberCount =0;
        for(String s:monthList){
            numberCount = Collections.frequency(monthList,s);
            JsonObject suburbJson = Json.createObjectBuilder().add("The number of watched movie in "+s,numberCount).build();
            //check if it is a repeated value. the repated value only needs to show once in the result but the occurrence should be counted
            if(!alreadyCalculated.contains(s)){
            monthJsonArray.add(suburbJson);
            alreadyCalculated.add(s);
            }
        } 
        JsonArray jArrayResult = monthJsonArray.build();  
        return jArrayResult;
        
    }
    
    @GET
    @Path("findByUserid/{userid}")
    @Produces({"application/json"})
    public JsonArray findByUserid(@PathParam("userid") int userid)
        {
            TypedQuery<Memoirtable> query = em.createQuery("SELECT m FROM Memoirtable m WHERE m.userid.userid = :userid",Memoirtable.class);
            query.setParameter("userid", userid);
            List<Memoirtable> result = query.getResultList();
            List<Memoirtable> maxRatingMovie = query.getResultList();
            ArrayList<Integer> scoreList = new ArrayList<>();
            JsonArrayBuilder movieJsonArray = Json.createArrayBuilder();  
            for(Memoirtable m: result){
            int ratingScore = m.getRatingscore();
            scoreList.add(ratingScore);
    }
            int maxScore = Collections.max(scoreList);
            
            for(Memoirtable m: result){
                int ratingScore = m.getRatingscore();
                if(ratingScore == maxScore){
                    maxRatingMovie.add(m);
                }
            }
            for(Memoirtable m: maxRatingMovie){
               String eachMovie = (m.getUserid().getName())+" "+(m.getRatingscore())+" "+(m.getMoviereleasedate().toString());
               movieJsonArray.add(eachMovie);
            }
            JsonArray jArrayResult = movieJsonArray.build();  
            return jArrayResult;
        }
    
     @GET
    @Path("findMovieNameByUserid/{userid}")
    @Produces({"application/json"})
    public JsonArray findMovieNameByUserid(@PathParam("userid") int userid)
        {
            TypedQuery<Memoirtable> query = em.createQuery("SELECT m FROM Memoirtable m WHERE m.userid.userid = :userid AND EXTRACT (YEAR FROM m.moviereleasedate) = EXTRACT (YEAR FROM m.watchdate) ",Memoirtable.class);
            query.setParameter("userid", userid);
            List<Memoirtable> result = query.getResultList();
            ArrayList<String> movieList = new ArrayList<>();
            JsonArrayBuilder movieJsonArray = Json.createArrayBuilder();  
            for(Memoirtable m: result){
           
            String movieInfo = m.getMoviename()+" "+m.getMoviereleasedate().toString();
            movieList.add(movieInfo);
            movieJsonArray.add(movieInfo);
    }
            JsonArray jArrayResult = movieJsonArray.build();  
            return jArrayResult;
        }
    
     @GET
    @Path("findSameMovieNameByUserid/{userid}")
    @Produces({"application/json"})
    public JsonArray findSameMovieNameByUserid(@PathParam("userid") int userid)
        {
            TypedQuery<Memoirtable> query = em.createQuery("SELECT m FROM Memoirtable m WHERE m.userid.userid = :userid ",Memoirtable.class);
            query.setParameter("userid", userid);
            List<Memoirtable> result = query.getResultList();
            ArrayList<String> movieList = new ArrayList<>();
            ArrayList<String> sameMovieList = new ArrayList<>();
            JsonArrayBuilder movieJsonArray = Json.createArrayBuilder();  
            for(Memoirtable m: result){
            String moviename = m.getMoviename();
            if(movieList.contains(moviename)){
                sameMovieList.add(moviename);
            }
            movieList.add(moviename);
              }
           for(Memoirtable m: result){
               if(sameMovieList.contains(m.getMoviename())){
                   movieJsonArray.add(m.getMoviename()+" "+m.getMoviereleasedate());
               }
           }
            JsonArray jArrayResult = movieJsonArray.build();  
            return jArrayResult;
        }
    @GET
    @Path("findHighRatingMovieNameByUserid/{userid}")
    @Produces({"application/json"})
    public JsonArray findHighRatingMovieNameByUserid(@PathParam("userid") int userid)
        {
            TypedQuery<Memoirtable> query = em.createQuery("SELECT m FROM Memoirtable m WHERE m.userid.userid = :userid AND EXTRACT (YEAR FROM m.moviereleasedate) = EXTRACT (YEAR FROM current_date) ",Memoirtable.class);
            query.setParameter("userid", userid);
            List<Memoirtable> result = query.getResultList();
            ArrayList<List<Integer>> scoreList = new ArrayList<>();
            ArrayList<Integer> highScoreList = new ArrayList<>();
            JsonArrayBuilder movieJsonArray = Json.createArrayBuilder();  
            for(Memoirtable m: result){
            int ratingScore = m.getRatingscore();
            int memoirid = m.getMemoirid();
            
            ArrayList<Integer> scoreIdPair = new ArrayList<>();
            scoreIdPair.add(ratingScore);
            scoreIdPair.add(memoirid);
            scoreList.add(scoreIdPair);
              }
            Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            };
            Collections.sort(scoreList,comparator);
            Collections.reverse(scoreList);
            for(int i = 0; i<5;i++){
                highScoreList.add(scoreList.get(i).get(1));
            }
            
            
            for(int i: highScoreList){
                for(Memoirtable m: result){
                    if(m.getMemoirid() == i){
                        movieJsonArray.add(m.getMoviename()+" "+m.getMoviereleasedate()+ " "+ m.getRatingscore());
                    }
            }
            
        }
    
                JsonArray jArrayResult = movieJsonArray.build();  
                return jArrayResult;
}
}
