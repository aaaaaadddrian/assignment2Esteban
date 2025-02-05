import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// A Lot of the code comes from https://steemit.com/visualization/@datatreemap/visualize-a-multiple-lines-graph-with-jfreechart-in-java

public class Graphing extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Graphing().setVisible(true);
            }
        });

    }

    public Graphing(){
        super("XY Line Chart Example with JFreechart");
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private JPanel createChartPanel(){
        String chartTitle = "Sorting Algorithms Sort-Times";
        String xAxisLabel = "Items in Array";
        String yAxisLabel = "Time in Seconds";

        XYDataset dataset = createDataset2();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);

        customizeChart(chart);

        File imageFile = new File("ALG-RUN-TIME-CHART.png");
        int width = 1920;
        int height = 1080;

        try {
            ChartUtils.saveChartAsPNG(imageFile, chart, width, height);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return new ChartPanel(chart);

    }

    private XYDataset createDataset(){

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Insertion Sort");
        XYSeries series2 = new XYSeries("Bubble Sort");
        XYSeries series3 = new XYSeries("Selection Sort");
        XYSeries series4 = new XYSeries("Shell Sort");
        XYSeries series5 = new XYSeries("Quick Sort");
        XYSeries series6 = new XYSeries("Merge Sort");

        series1.add(100,1.9759499991778284E-4 );
        series1.add(500,5.743949979660102E-4  );
        series1.add(1000,0.002324325000518002 );
        series1.add(2000, 0.007966419997683261);
        series1.add(5000, 0.05128352000319865);
        series1.add(10000, 0.2158895599975949 );
        series1.add(20000,0.6535573450019001 );
        series1.add(75000, 10.24898306500254);
        series1.add(150000, 41.136799014998545);


        series2.add(100,1.917850022437051E-4 );
        series2.add(500,3.8706500199623404E-4   );
        series2.add(1000,7.959299968206323E-4 );
        series2.add(2000, 0.002345480002986733);
        series2.add(5000, 0.012583170000289102);
        series2.add(10000, 0.0744951199987554 );
        series2.add(20000,0.4554539749995456 );
        series2.add(75000, 7.036538640005165);
        series2.add(150000, 28.650306565001664);


        int[] size = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        double[] selectS = {1.454299985198304E-4 ,4.8411999887321144E-4, 2.4999999877763914E-4, 9.626800019759685E-4 ,0.005609409998578485, 0.02126517999859061, 0.08850158500281395, 1.1275677400000859, 4.462000809998426};

        for(int i = 0; i < 9; i++){
            series3.add(size[i], selectS[i]);
        }

        double[] shellS = {3.6910001654177904E-5,8.047000010265037E-5,1.270599997951649E-4 ,1.9940999773098155E-4,  4.49889998708386E-4, 9.11389994143974E-4, 0.002873165003256872,  0.009292040001309943, 0.02268674499791814};

        for(int i = 0; i < 9; i++){
            series4.add(size[i], shellS[i]);
        }

        double[] quickS = {1.0829995153471827E-5, 3.4274997597094624E-5, 2.263500209664926E-5, 4.263000300852582E-5, 8.550000056857243E-5, 1.9198999943910168E-4, 1.0849500395124779E-4, 5.520300008356571E-4, 0.001010739998309873};

        for(int i = 0; i < 9; i++){
            series5.add(size[i], quickS[i]);
        }

        double[] mergeS = { 1.0614000202622265E-4, 1.4334999868879095E-4, 2.5773499946808444E-4, 0.0016211349997320213, 4.461849996005185E-4, 7.895250004366971E-4, 0.0017032649950124324, 0.008113754999067168, 0.015970229999220466};

        for(int i = 0; i < 9; i++){
            series6.add(size[i], mergeS[i]);
        }

        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        dataset.addSeries(series6);

        return dataset;

    }

    private void customizeChart(JFreeChart chart){

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();


        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.YELLOW);
        renderer.setSeriesPaint(4, Color.PINK);
        renderer.setSeriesPaint(5, Color.MAGENTA);

        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(4.0f));
        renderer.setSeriesStroke(4, new BasicStroke(3.0f));
        renderer.setSeriesStroke(5, new BasicStroke(2.0f));

        plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(2.0f));

        plot.setRenderer(renderer);

        plot.setBackgroundPaint(Color.DARK_GRAY);


        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

    }

    private XYDataset createDataset2(){

        XYSeriesCollection dataset = new XYSeriesCollection();

//        XYSeries series3 = new XYSeries("Selection Sort");
        XYSeries series4 = new XYSeries("Shell Sort");
        XYSeries series5 = new XYSeries("Quick Sort");
        XYSeries series6 = new XYSeries("Merge Sort");

        int[] size = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};
        double[] selectS = {1.454299985198304E-4 ,4.8411999887321144E-4, 2.4999999877763914E-4, 9.626800019759685E-4 ,0.005609409998578485, 0.02126517999859061, 0.08850158500281395, 1.1275677400000859, 4.462000809998426};

//        for(int i = 0; i < 9; i++){
//            series3.add(size[i], selectS[i]);
//        }

        double[] shellS = {3.6910001654177904E-5,8.047000010265037E-5,1.270599997951649E-4 ,1.9940999773098155E-4,  4.49889998708386E-4, 9.11389994143974E-4, 0.002873165003256872,  0.009292040001309943, 0.02268674499791814};

        for(int i = 0; i < 9; i++){
            series4.add(size[i], shellS[i]);
        }

        double[] quickS = {1.0829995153471827E-5, 3.4274997597094624E-5, 2.263500209664926E-5, 4.263000300852582E-5, 8.550000056857243E-5, 1.9198999943910168E-4, 1.0849500395124779E-4, 5.520300008356571E-4, 0.001010739998309873};

        for(int i = 0; i < 9; i++){
            series5.add(size[i], quickS[i]);
        }

        double[] mergeS = { 1.0614000202622265E-4, 1.4334999868879095E-4, 2.5773499946808444E-4, 0.0016211349997320213, 4.461849996005185E-4, 7.895250004366971E-4, 0.0017032649950124324, 0.008113754999067168, 0.015970229999220466};

        for(int i = 0; i < 9; i++){
            series6.add(size[i], mergeS[i]);
        }

//        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        dataset.addSeries(series6);

        return dataset;
    }


}
