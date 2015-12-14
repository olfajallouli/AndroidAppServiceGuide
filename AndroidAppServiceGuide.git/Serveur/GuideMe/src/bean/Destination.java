package bean;

public class Destination {

	int id;
	double lat, lng;
	String nom;
	String numT;//numero de telephone
	String img,desc,adresse,type;


	public Destination(int id, double lat, double lng, String nom, String numT,
			String img, String desc, String adresse,String type) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.nom = nom;
		this.numT = numT;
		this.img = img;
		this.desc = desc;
		this.adresse = adresse;
		this.type=type;
	}
	public int getId() {
		return id;
	}
	public String getType(){
		return type;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumT() {
		return numT;
	}
	public void setNumT(String numT) {
		this.numT = numT;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
