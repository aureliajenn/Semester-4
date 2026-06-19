public class TemperatureDisplay implements WeatherObserver {
    private String name;

    public TemperatureDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(double temperature, double humidity) {
        System.out.printf("Display %s: Suhu %.1f\n", this.name, temperature);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
