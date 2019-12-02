package com.example.alqurandigital.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseDetail{

	@SerializedName("ar")
	private String ar;

	@SerializedName("id")
	private String id;

	@SerializedName("nomor")
	private String nomor;

	@SerializedName("tr")
	private String tr;

	public void setAr(String ar){
		this.ar = ar;
	}

	public String getAr(){
		return ar;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNomor(String nomor){
		this.nomor = nomor;
	}

	public String getNomor(){
		return nomor;
	}

	public void setTr(String tr){
		this.tr = tr;
	}

	public String getTr(){
		return tr;
	}
}