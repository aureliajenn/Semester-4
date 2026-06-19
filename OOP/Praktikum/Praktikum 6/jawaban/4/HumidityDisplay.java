public class HumidityDisplay implements WeatherObserver {
    private String name;

    public HumidityDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(double temperature, double humidity) {
        System.out.printf("Display %s: Kelembaban %.1f%%\n", this.name, humidity);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
