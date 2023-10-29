package displayer;

public class DisplayerFactory {
    public static Displayer getDisplayer(ChartType chartType) {
        return switch (chartType) {
            case Spreadsheet -> new SpreadsheetDisplayer();
            case BarChart -> new BarChartDisplayer();
            case PieChart -> new PieChartDisplayer();
            default -> throw new IllegalArgumentException("Invalid chart type");
        };
    }
}
