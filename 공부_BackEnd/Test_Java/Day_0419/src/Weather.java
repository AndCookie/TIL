
public enum Weather {
	¸¼À½("sunny"){
		public String playKor() {
			return "¼ÒÇ³";
		}
		public String playEng() {
			return "picnic";
		}
	},
	¾È°³("foggy"){
		public String playKor() {
			return "À½¾Ç";
		}
		public String playEng() {
			return "music";
		}
	},
	Èå¸²("cloudy"){
		public String playKor() {
			return "µ¶¼­";
		}
		public String playEng() {
			return "book";
		}
	},
	ºñ("rain"){
		public String playKor() {
			return "³ÝÇÃ¸¯½º";
		}
		public String playEng() {
			return "netflix";
		}
	},
	´«("snow"){
		public String playKor() {
			return "½ºÅ°";
		}
		public String playEng() {
			return "ski";
		}
	};

	
	private String eng;
	
	Weather(String eng) {
		this.eng = eng;
	}
	
	public String getEng() {
		return this.eng;
	}
	
	public String playKor() {
		return "°øºÎ";
	}
	
	public String playEng() {
		return "Study";
	}
}
