import java.time.LocalDate;

public class Vehicle extends Asset {
  String makeModel;
  int year;
  int odometer;

  public Vehicle(
      double originalCost,
      String dateAcquired,
      String description,
      String makeModel,
      int year,
      int odometer) {
    super(originalCost, dateAcquired, description);
    this.makeModel = makeModel;
    this.year = year;
    this.odometer = odometer;
  }

  public String getMakeModel() {
    return makeModel;
  }

  public void setMakeModel(String makeModel) {
    this.makeModel = makeModel;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getOdometer() {
    return odometer;
  }

  public void setOdometer(int odometer) {
    this.odometer = odometer;
  }

  @Override
  public double getValue() {
    // A car's value is determined as
    // 0-3 years old - 3% reduced value of cost per year
    // 4-6 years old - 6% reduced value of cost per year
    // 7-10 years old - 8% reduced value of cost per year
    // over 10 years old - $1000.00
    // MINUS reduce final value by 25% if over 100,000 miles
    // unless makeModel contains word Honda or Toyota

    double value = 0;
    if (makeModel.toLowerCase().contains("honda") || makeModel.toLowerCase().contains("toyota") || description.toLowerCase().contains("toyota") || description.toLowerCase().contains("honda"))
      return getOriginalCost();
    int i = Math.abs(year - LocalDate.now().getYear());

    if (i <= 3) {
      value = getOriginalCost() * 0.97;
    }
    if (i >= 4 && i <= 6) {
      value = getOriginalCost() * 0.94;
    }
    if (i >= 7 && i <= 10) {
      value = getOriginalCost() * 0.92;
    }
    if (i > 10) {
      value = 1000;
    }
    if (getOdometer() > 100000) {
      value *= 0.75;
    }

    return value;
  }
}
