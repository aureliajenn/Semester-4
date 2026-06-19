import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    private List<WeatherObserver> observers;
    private double temperature;
    private double humidity;

    public WeatherStation() {
        this.observers = new ArrayList<>();
        this.temperature = 0.0;
        this.humidity = 0.0;
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public boolean removeObserver(String name) {
        for (WeatherObserver observer : observers) {
            if (observer.getName().equals(name)) {
                observers.remove(observer);
                return true;
            }
        }
        return false;
    }

    public boolean hasObserver(String name) {
        for (WeatherObserver observer : observers) {
            if (observer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void setMeasurements(double temperature, double humidity) {
        // TODO:
        // Perbarui nilai temperature dan humidity.
        // Setelah diperbarui, panggil notifyObservers() untuk
        // memberitahu semua observer yang terdaftar.

        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        // TODO:
        // Iterasi seluruh observer dalam daftar (sesuai urutan pendaftaran)
        // dan panggil update(temperature, humidity) pada masing-masing observer.
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    public double getTemperature() {
        // TODO:
        // Kembalikan nilai temperature saat ini.

        return this.temperature;
    }

    public double getHumidity() {
        // TODO:
        // Kembalikan nilai humidity saat ini.

        return this.humidity;
    }

    public int getObserverCount() {
        // TODO:
        // Kembalikan jumlah observer yang saat ini terdaftar.

        return this.observers.size();
    }
}