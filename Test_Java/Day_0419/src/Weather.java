
public enum Weather {
	����("sunny"){
		public String playKor() {
			return "��ǳ";
		}
		public String playEng() {
			return "picnic";
		}
	},
	�Ȱ�("foggy"){
		public String playKor() {
			return "����";
		}
		public String playEng() {
			return "music";
		}
	},
	�帲("cloudy"){
		public String playKor() {
			return "����";
		}
		public String playEng() {
			return "book";
		}
	},
	��("rain"){
		public String playKor() {
			return "���ø���";
		}
		public String playEng() {
			return "netflix";
		}
	},
	��("snow"){
		public String playKor() {
			return "��Ű";
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
		return "����";
	}
	
	public String playEng() {
		return "Study";
	}
}
