package it.polito.tdp.crimes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.crimes.db.EventsDao;

public class Model {
	
	private Graph<Integer, DefaultWeightedEdge> grafo;
	private EventsDao dao;
	private List<Adiacenza> archi;
	
	public Model() {
		this.dao = new EventsDao();
	}
	
	public String creaGrafo(int anno) {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//Aggiungo i vertici
		Graphs.addAllVertices(this.grafo, this.dao.getVertici());
		
		//Aggiungo gli archi
		List<Distretti> distretti = this.dao.getDistretti(anno);
		this.archi = new ArrayList<Adiacenza>();
		System.out.println(distretti);
		for(Distretti d1: distretti) {
			for(Distretti d2 : distretti) {
				if(d1.getIdDistr() > d2.getIdDistr()) {
					
					LatLng val1 = new LatLng(d1.getLan(), d1.getLon());
					LatLng val2 = new LatLng(d2.getLan(), d2.getLon());
					
					double distanza = LatLngTool.distance(val1, val2, LengthUnit.KILOMETER);
					
					archi.add(new Adiacenza(d1.getIdDistr(), d2.getIdDistr(), distanza));
					
					Graphs.addEdge(this.grafo, d1.getIdDistr(),d2.getIdDistr(), distanza);
					
				}
			}
		}
		
		return "Grafo creato!\nNumero di vertici: " + this.grafo.vertexSet().size() + "\nNumero di archi: " + this.grafo.edgeSet().size();
		
	}
	
	public List<Adiacenza> getAdiacentiVertice(int vertice) {
		
		List<Adiacenza> result = new ArrayList<Adiacenza>();
		for(Adiacenza a : this.archi) {
			if(a.getId1() == vertice || a.getId2() == vertice) {
				result.add(a);
			}	
		}
		
		Collections.sort(result);
		return result;	
		
	}
	
	public Graph<Integer, DefaultWeightedEdge> getGrafo() {
		return this.grafo;
	}
	
	
}
