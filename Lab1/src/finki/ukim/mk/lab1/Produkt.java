package finki.ukim.mk.lab1;

public class Produkt {

		private String ime;
		private int cena;
		private float popust;
		
		public Produkt() {
			super();
		}
		public Produkt(String ime, int cena, float popust) {
			super();
			this.ime = ime;
			this.cena = cena;
			this.popust = popust;
		}
		
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
		public int getCena() {
			return cena;
		}
		public void setCena(int cena) {
			this.cena = cena;
		}
		public float getPopust() {
			return popust;
		}
		public void setPopust(float popust) {
			this.popust = popust;
		}
		@Override
		public String toString() {
			return "Produkt [ime=" + ime + ", cena=" + cena + ", popust="
					+ popust + "]";
		}
		
}
