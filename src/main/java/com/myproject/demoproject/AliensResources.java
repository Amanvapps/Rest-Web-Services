package com.myproject.demoproject;


import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("aliens")
public class AliensResources 
{
	

AlienDatabaseRepository repo = new AlienDatabaseRepository();

	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Aliens> getAliens()
	{
	
		return repo.getAliens() ; 
	}
	
	
	@Path("getOneAlien/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) 
	public Aliens getAlien(@PathParam("id") int id)
	{
	     return repo.getAlien(id) ; 
	}
	
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("createalien")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Aliens createAlien(Aliens a1)
	{
		System.out.println(a1);
		
		repo.create(a1);
		
		return a1 ;
	}
	
	

	@PUT 
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("createalien")
	@Consumes({MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON})
	public Aliens updateAlien(Aliens a1)
	{
		System.out.println(a1);
		
		if(repo.getAlien(a1.getId()).getId() == 0)
		{
		   repo.create(a1);	 
		}
		
		else
		{
		repo.update(a1);
		}
		
		return a1 ;
	}
	
	@DELETE
	@Path("getOneAlien/{id}")
	public Aliens killAlien(@PathParam("id") int id )
	{
		Aliens a = repo.getAlien(id);
		
		if(a.getId()!=0)
		{
		repo.delete(id);
		}
		
		return a ;
	}
	
	
}
