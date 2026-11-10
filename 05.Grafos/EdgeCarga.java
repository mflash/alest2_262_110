public class EdgeCarga implements Comparable<EdgeCarga> {
  private String v;
  private String w;
  private double tempo;
  private double maxCarga;
  private String color;

  public EdgeCarga(String v, String w, double tempo, double maxCarga) {
    this.v = v;
    this.w = w;
    this.tempo = tempo;
    this.maxCarga = maxCarga;
    this.color = "";
  }

  public String getV() {
    return v;
  }

  public String getW() {
    return w;
  }

  public double getTempo() {
    return tempo;
  }

  public void setTempo(double weight) {
    this.tempo = weight;
  }

  public double getMaxCarga() {
      return maxCarga;
  }

  public void setMaxCarga(double maxCarga) {
      this.maxCarga = maxCarga;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  @Override
  public int compareTo(EdgeCarga other) {
    return Double.compare(this.tempo, other.tempo);
  }

  @Override
  public String toString() {
    return v + "-" + w + " (" + tempo + "/" + maxCarga + ")" + color;
  }
}
