package otomasyon;//21100011062 HAKAN EMİK

public class Ders {
private int dersId;
private String dersAd;




public Ders(int dersId, String dersAd) {
	
	this.dersId = dersId;
	this.dersAd = dersAd;
}
public String getDersAd() {
	return dersAd;
}
public void setDersAd(String dersAd) {
	this.dersAd = dersAd;
}

public int getDersId() {
	return dersId;
}

public void setDersId(int dersId) {
	this.dersId = dersId;
}


}
