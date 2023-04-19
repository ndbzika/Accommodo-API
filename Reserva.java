import java.util.Date;

public class Reserva {
  private int id;
  private Hospede hospede;
  private Quarto quarto;
  private Date dataCheckIn;
  private Date dataCheckOut;

  public Reserva(Hospede hospede, Quarto quarto) {
    this.hospede = hospede;
    this.quarto = quarto;
  }
  public int getId() {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public Hospede getHospede() {
    return this.hospede;
  }
  public void setHospede(Hospede hospede) {
    this.hospede = hospede;
  }

  public Quarto getQuarto() {
    return this.quarto;
  }
  public void setQuarto(Quarto quarto) {
    this.quarto = quarto;
  }

  public Date getDataCheckIn() {
    return this.dataCheckIn;
  }
  public void setDataCheckIn(Date dataCheckIn) {
    this.dataCheckIn = dataCheckIn;
  }

  public Date getDataCheckOut() {
    return this.dataCheckOut;
  }
  public void setDataCheckOut(Date dataCheckOut) {
    this.dataCheckOut = dataCheckOut;
  }
}
