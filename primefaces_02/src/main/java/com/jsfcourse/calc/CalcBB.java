package com.jsfcourse.calc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String kwota;
	private String czas;
	private String oprocentowanie;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getCzas() {
		return czas;
	}

	public void setCzas(String czas) {
		this.czas = czas;
	}

	public String getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(String oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}	

	// Go to "showresult" if ok
	public String calc() {
		try {
			double kwota = Double.parseDouble(this.kwota);
			double czas = Double.parseDouble(this.czas);
			double oprocentowanie = Double.parseDouble(this.oprocentowanie);

			result = (double) Math.round(((kwota/(czas*12))+(kwota/(czas*12))*(oprocentowanie/100))*100)/100;;

			  ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
	            return "showresult"; 
	        } catch (Exception e) {
	            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
	            return null; 
	        }

	    }

	    public String info() {
	        return "info"; 
	    }
	}