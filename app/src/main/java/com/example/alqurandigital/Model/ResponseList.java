package com.example.alqurandigital.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseList{

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("rukuk")
	private String rukuk;

	@SerializedName("nama")
	private String nama;

	@SerializedName("ayat")
	private int ayat;

	@SerializedName("urut")
	private String urut;

	@SerializedName("arti")
	private String arti;

	@SerializedName("asma")
	private String asma;

	@SerializedName("audio")
	private String audio;

	@SerializedName("type")
	private String type;

	@SerializedName("nomor")
	private String nomor;

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setRukuk(String rukuk){
		this.rukuk = rukuk;
	}

	public String getRukuk(){
		return rukuk;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setAyat(int ayat){
		this.ayat = ayat;
	}

	public int getAyat(){
		return ayat;
	}

	public void setUrut(String urut){
		this.urut = urut;
	}

	public String getUrut(){
		return urut;
	}

	public void setArti(String arti){
		this.arti = arti;
	}

	public String getArti(){
		return arti;
	}

	public void setAsma(String asma){
		this.asma = asma;
	}

	public String getAsma(){
		return asma;
	}

	public void setAudio(String audio){
		this.audio = audio;
	}

	public String getAudio(){
		return audio;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setNomor(String nomor){
		this.nomor = nomor;
	}

	public String getNomor(){
		return nomor;
	}
}