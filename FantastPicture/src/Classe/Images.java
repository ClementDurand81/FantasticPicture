package Classe;

public class Images {
    private String url;
    private String nomImg;

    public Images(String url, String nomImg) {
        this.setUrl(url);
        this.setNomImg(nomImg);
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNomImg() {
		return nomImg;
	}

	public void setNomImg(String nomImg) {
		this.nomImg = nomImg;
	}
}